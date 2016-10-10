/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *  *
 *
 * ASM: a very small and fast Java bytecode manipulation framework
 * Copyright (c) 2000-2011 INRIA, France Telecom
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holders nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.jetbrains.kotlin.codegen.optimization.common

import org.jetbrains.org.objectweb.asm.Opcodes
import org.jetbrains.org.objectweb.asm.Type
import org.jetbrains.org.objectweb.asm.tree.*
import org.jetbrains.org.objectweb.asm.tree.analysis.AnalyzerException
import org.jetbrains.org.objectweb.asm.tree.analysis.Interpreter
import org.jetbrains.org.objectweb.asm.tree.analysis.Value
import java.util.*


/**
 * A symbolic execution stack frame. A stack frame contains a set of local
 * variable slots, and an operand stack. Warning: long and double values are
 * represented by *two* slots in local variables, and by *one* slot in
 * the operand stack.

 * @param
 * *            type of the Value used for the analysis.
 * *
 * *
 * @author Eric Bruneton
 */
open class MethodFrame<V : Value>
/**
 * Constructs a new frame with the given size.

 * @param nLocals
 * *            the maximum number of local variables of the frame.
 * *
 * @param nStack
 * *            the maximum stack size of the frame.
 */
constructor(
        /**
         * The number of local variables of this frame.
         */
        /**
         * Returns the maximum number of local variables of this frame.

         * @return the maximum number of local variables of this frame.
         */
        val locals: Int, nStack: Int
) {

    /**
     * The expected return type of the analyzed method, or null if the
     * method returns void.
     */
    private var returnValue: V? = null

    /**
     * The local variables and operand stack of this frame.
     */
    private val values: Array<V?>

    /**
     * The number of elements in the operand stack.
     */
    /**
     * Returns the number of values in the operand stack of this frame. Long and
     * double values are treated as single values.

     * @return the number of values in the operand stack of this frame.
     */
    var stackSize: Int = 0
        private set

    init {
        @Suppress("UNCHECKED_CAST")
        this.values = arrayOfNulls<Value>(locals + nStack) as Array<V?>
    }

    /**
     * Copies the state of the given frame into this frame.

     * @param src
     * *            a frame.
     * *
     * @return this frame.
     */
    open fun init(src: MethodFrame<out V>): MethodFrame<V> {
        returnValue = src.returnValue
        System.arraycopy(src.values, 0, values, 0, values.size)
        stackSize = src.stackSize
        return this
    }

    /**
     * Sets the expected return type of the analyzed method.

     * @param v
     * *            the expected return type of the analyzed method, or
     * *            null if the method returns void.
     */
    fun setReturn(v: V?) {
        returnValue = v
    }

    /**
     * Returns the maximum stack size of this frame.

     * @return the maximum stack size of this frame.
     */
    val maxStackSize: Int
        get() = values.size - locals

    /**
     * Returns the value of the given local variable.

     * @param i
     * *            a local variable index.
     * *
     * @return the value of the given local variable.
     * *
     * @throws IndexOutOfBoundsException
     * *             if the variable does not exist.
     */
    fun getLocal(i: Int): V {
        if (i >= locals) {
            throw IndexOutOfBoundsException(
                    "Trying to access an inexistant local variable")
        }
        return values[i] ?: throw IllegalStateException("Variable $i should be initialized before its first usage")
    }

    /**
     * Sets the value of the given local variable.

     * @param i
     * *            a local variable index.
     * *
     * @param value
     * *            the new value of this local variable.
     * *
     * @throws IndexOutOfBoundsException
     * *             if the variable does not exist.
     */
    fun setLocal(i: Int, value: V) {
        if (i >= locals) {
            throw IndexOutOfBoundsException(
                    "Trying to access an inexistant local variable " + i)
        }
        values[i] = value
    }

    /**
     * Returns the value of the given operand stack slot.

     * @param i
     * *            the index of an operand stack slot.
     * *
     * @return the value of the given operand stack slot.
     * *
     * @throws IndexOutOfBoundsException
     * *             if the operand stack slot does not exist.
     */
    open fun getStack(i: Int): V {
        return values[i + locals] ?: throw IllegalStateException("Stack item $i should be initialized before its first usage")
    }

    /**
     * Clears the operand stack of this frame.
     */
    open fun clearStack() {
        stackSize = 0
    }

    /**
     * Pops a value from the operand stack of this frame.

     * @return the value that has been popped from the stack.
     * *
     * @throws IndexOutOfBoundsException
     * *             if the operand stack is empty.
     */

    open fun pop(): V {
        if (stackSize == 0) {
            throw IndexOutOfBoundsException(
                    "Cannot pop operand off an empty stack.")
        }
        return values[--stackSize + locals] ?: throw IllegalStateException("Top of the stack should be initialized before its first usage")
    }

    /**
     * Pushes a value into the operand stack of this frame.

     * @param value
     * *            the value that must be pushed into the stack.
     * *
     * @throws IndexOutOfBoundsException
     * *             if the operand stack is full.
     */

    open fun push(value: V) {
        if (stackSize + locals >= values.size) {
            throw IndexOutOfBoundsException(
                    "Insufficient maximum stack size.")
        }
        values[stackSize++ + locals] = value
    }

    open fun execute(insn: AbstractInsnNode, interpreter: Interpreter<V>) {
        val value1: V
        val value2: V
        val value3: V
        val value4: V
        val values: MutableList<V>
        val `var`: Int

        when (insn.opcode) {
            Opcodes.NOP -> {
            }
            Opcodes.ACONST_NULL, Opcodes.ICONST_M1, Opcodes.ICONST_0, Opcodes.ICONST_1,
            Opcodes.ICONST_2, Opcodes.ICONST_3, Opcodes.ICONST_4, Opcodes.ICONST_5,
            Opcodes.LCONST_0, Opcodes.LCONST_1, Opcodes.FCONST_0, Opcodes.FCONST_1,
            Opcodes.FCONST_2, Opcodes.DCONST_0, Opcodes.DCONST_1, Opcodes.BIPUSH,
            Opcodes.SIPUSH, Opcodes.LDC -> push(interpreter.newOperation(insn))
            Opcodes.ILOAD, Opcodes.LLOAD, Opcodes.FLOAD, Opcodes.DLOAD, Opcodes.ALOAD ->

                push(interpreter.copyOperation(insn, getLocal((insn as VarInsnNode).`var`)))

            Opcodes.IALOAD, Opcodes.LALOAD, Opcodes.FALOAD, Opcodes.DALOAD, Opcodes.AALOAD,
            Opcodes.BALOAD, Opcodes.CALOAD, Opcodes.SALOAD -> {
                value2 = pop()
                value1 = pop()
                push(interpreter.binaryOperation(insn, value1, value2))
            }

            Opcodes.ISTORE, Opcodes.LSTORE, Opcodes.FSTORE, Opcodes.DSTORE, Opcodes.ASTORE -> {
                value1 = interpreter.copyOperation(insn, pop())
                `var` = (insn as VarInsnNode).`var`
                setLocal(`var`, value1)
                if (value1.size == 2) {
                    setLocal(`var` + 1, interpreter.newValue(null))
                }
                if (`var` > 0) {
                    val local = getLocal(`var` - 1)
                    if (local.size == 2) {
                        setLocal(`var` - 1, interpreter.newValue(null))
                    }
                }
            }

            Opcodes.IASTORE, Opcodes.LASTORE, Opcodes.FASTORE, Opcodes.DASTORE, Opcodes.AASTORE,
            Opcodes.BASTORE, Opcodes.CASTORE, Opcodes.SASTORE -> {
                value3 = pop()
                value2 = pop()
                value1 = pop()
                interpreter.ternaryOperation(insn, value1, value2, value3)
            }

            Opcodes.POP -> if (pop().size == 2) {
                throw AnalyzerException(insn, "Illegal use of POP")
            }

            Opcodes.POP2 -> if (pop().size == 1) {
                if (pop().size != 1) {
                    throw AnalyzerException(insn, "Illegal use of POP2")
                }
            }

            Opcodes.DUP -> {
                value1 = pop()
                if (value1.size != 1) {
                    throw AnalyzerException(insn, "Illegal use of DUP")
                }
                push(value1)
                push(interpreter.copyOperation(insn, value1))
            }

            Opcodes.DUP_X1 -> {
                value1 = pop()
                value2 = pop()
                if (value1.size != 1 || value2.size != 1) {
                    throw AnalyzerException(insn, "Illegal use of DUP_X1")
                }
                push(interpreter.copyOperation(insn, value1))
                push(value2)
                push(value1)
            }

            Opcodes.DUP_X2 -> {
                value1 = pop()
                checkAnalyzerInvariant(value1.size == 1, insn, "Illegal use of DUP_X2")
                value2 = pop()
                if (value2.size == 1) {
                    value3 = pop()
                    checkAnalyzerInvariant(value3.size == 1, insn) { "Illegal use of DUP_X2" }
                    push(interpreter.copyOperation(insn, value1))
                    push(value3)
                    push(value2)
                    push(value1)
                }
                else {
                    push(interpreter.copyOperation(insn, value1))
                    push(value2)
                    push(value1)
                }
            }

            Opcodes.DUP2 -> {
                value1 = pop()
                if (value1.size == 1) {
                    value2 = pop()
                    checkAnalyzerInvariant(value2.size == 1, insn, "Illegal use of DUP2")
                        push(value2)
                        push(value1)
                        push(interpreter.copyOperation(insn, value2))
                        push(interpreter.copyOperation(insn, value1))
                }
                else {
                    push(value1)
                    push(interpreter.copyOperation(insn, value1))
                }
            }

            Opcodes.DUP2_X1 -> {
                value1 = pop()
                if (value1.size == 1) {
                    value2 = pop()
                    if (value2.size == 1) {
                        value3 = pop()
                        checkAnalyzerInvariant(value3.size == 1, insn, "Illegal use of DUP2_X1")
                        push(interpreter.copyOperation(insn, value2))
                        push(interpreter.copyOperation(insn, value1))
                        push(value3)
                        push(value2)
                        push(value1)
                    }
                }
                else {
                    value2 = pop()
                    checkAnalyzerInvariant(value2.size == 1, insn, "Illegal use of DUP2_X1")
                    push(interpreter.copyOperation(insn, value1))
                    push(value2)
                    push(value1)
                }
            }

            Opcodes.DUP2_X2 -> {
                value1 = pop()
                if (value1.size == 1) {
                    value2 = pop()
                    if (value2.size == 1) {
                        value3 = pop()
                        if (value3.size == 1) {
                            value4 = pop()
                            checkAnalyzerInvariant(value4.size == 1, insn, "Illegal use of DUP2_X2")
                            push(interpreter.copyOperation(insn, value2))
                            push(interpreter.copyOperation(insn, value1))
                            push(value4)
                            push(value3)
                            push(value2)
                            push(value1)
                        }
                        else {
                            push(interpreter.copyOperation(insn, value2))
                            push(interpreter.copyOperation(insn, value1))
                            push(value3)
                            push(value2)
                            push(value1)
                        }
                    }
                }
                else {
                    value2 = pop()
                    if (value2.size == 1) {
                        value3 = pop()
                        checkAnalyzerInvariant(value3.size == 1, insn, "Illegal use of DUP2_X2")
                        push(interpreter.copyOperation(insn, value1))
                        push(value3)
                        push(value2)
                        push(value1)
                    }
                    else {
                        push(interpreter.copyOperation(insn, value1))
                        push(value2)
                        push(value1)
                    }
                }
            }

            Opcodes.SWAP -> {
                value2 = pop()
                value1 = pop()
                if (value1.size != 1 || value2.size != 1) {
                    throw AnalyzerException(insn, "Illegal use of SWAP")
                }
                push(interpreter.copyOperation(insn, value2))
                push(interpreter.copyOperation(insn, value1))
            }

            Opcodes.IADD, Opcodes.LADD, Opcodes.FADD, Opcodes.DADD, Opcodes.ISUB, Opcodes.LSUB,
            Opcodes.FSUB, Opcodes.DSUB, Opcodes.IMUL, Opcodes.LMUL, Opcodes.FMUL, Opcodes.DMUL,
            Opcodes.IDIV, Opcodes.LDIV, Opcodes.FDIV, Opcodes.DDIV, Opcodes.IREM, Opcodes.LREM,
            Opcodes.FREM, Opcodes.DREM -> {
                value2 = pop()
                value1 = pop()
                push(interpreter.binaryOperation(insn, value1, value2))
            }

            Opcodes.INEG, Opcodes.LNEG, Opcodes.FNEG, Opcodes.DNEG -> push(interpreter.unaryOperation(insn, pop()))
            Opcodes.ISHL, Opcodes.LSHL, Opcodes.ISHR, Opcodes.LSHR, Opcodes.IUSHR, Opcodes.LUSHR,
            Opcodes.IAND, Opcodes.LAND, Opcodes.IOR, Opcodes.LOR, Opcodes.IXOR, Opcodes.LXOR -> {
                value2 = pop()
                value1 = pop()
                push(interpreter.binaryOperation(insn, value1, value2))
            }

            Opcodes.IINC -> {
                `var` = (insn as IincInsnNode).`var`
                setLocal(`var`, interpreter.unaryOperation(insn, getLocal(`var`)))
            }

            Opcodes.I2L, Opcodes.I2F, Opcodes.I2D, Opcodes.L2I, Opcodes.L2F, Opcodes.L2D, Opcodes.F2I,
            Opcodes.F2L, Opcodes.F2D, Opcodes.D2I, Opcodes.D2L, Opcodes.D2F, Opcodes.I2B, Opcodes.I2C,
            Opcodes.I2S ->
                push(interpreter.unaryOperation(insn, pop()))

            Opcodes.LCMP, Opcodes.FCMPL, Opcodes.FCMPG, Opcodes.DCMPL, Opcodes.DCMPG -> {
                value2 = pop()
                value1 = pop()
                push(interpreter.binaryOperation(insn, value1, value2))
            }

            Opcodes.IFEQ, Opcodes.IFNE, Opcodes.IFLT, Opcodes.IFGE, Opcodes.IFGT, Opcodes.IFLE -> interpreter.unaryOperation(insn, pop())
            Opcodes.IF_ICMPEQ, Opcodes.IF_ICMPNE, Opcodes.IF_ICMPLT, Opcodes.IF_ICMPGE, Opcodes.IF_ICMPGT,
            Opcodes.IF_ICMPLE, Opcodes.IF_ACMPEQ, Opcodes.IF_ACMPNE -> {
                value2 = pop()
                value1 = pop()
                interpreter.binaryOperation(insn, value1, value2)
            }

            Opcodes.GOTO -> {
            }

            Opcodes.JSR, Opcodes.RET -> throw AnalyzerException(insn, "Unexpected insn ${insn.opcode}")
            Opcodes.TABLESWITCH, Opcodes.LOOKUPSWITCH -> interpreter.unaryOperation(insn, pop())
            Opcodes.IRETURN, Opcodes.LRETURN, Opcodes.FRETURN, Opcodes.DRETURN, Opcodes.ARETURN -> {
                value1 = pop()
                interpreter.unaryOperation(insn, value1)
                interpreter.returnOperation(insn, value1, returnValue)
            }
            Opcodes.RETURN -> if (returnValue != null) {
                throw AnalyzerException(insn, "Incompatible return type")
            }

            Opcodes.GETSTATIC -> push(interpreter.newOperation(insn))
            Opcodes.PUTSTATIC -> interpreter.unaryOperation(insn, pop())
            Opcodes.GETFIELD -> push(interpreter.unaryOperation(insn, pop()))
            Opcodes.PUTFIELD -> {
                value2 = pop()
                value1 = pop()
                interpreter.binaryOperation(insn, value1, value2)
            }

            Opcodes.INVOKEVIRTUAL, Opcodes.INVOKESPECIAL, Opcodes.INVOKESTATIC, Opcodes.INVOKEINTERFACE -> {
                values = ArrayList<V>()
                val desc = (insn as MethodInsnNode).desc
                for (i in Type.getArgumentTypes(desc).size downTo 1) {
                    values.add(0, pop())
                }
                if (insn.getOpcode() != Opcodes.INVOKESTATIC) {
                    values.add(0, pop())
                }
                if (Type.getReturnType(desc) === Type.VOID_TYPE) {
                    interpreter.naryOperation(insn, values)
                }
                else {
                    push(interpreter.naryOperation(insn, values))
                }
            }

            Opcodes.INVOKEDYNAMIC -> {
                values = ArrayList<V>()
                val desc = (insn as InvokeDynamicInsnNode).desc
                for (i in Type.getArgumentTypes(desc).size downTo 1) {
                    values.add(0, pop())
                }
                if (Type.getReturnType(desc) === Type.VOID_TYPE) {
                    interpreter.naryOperation(insn, values)
                }
                else {
                    push(interpreter.naryOperation(insn, values))
                }
            }

            Opcodes.NEW -> push(interpreter.newOperation(insn))
            Opcodes.NEWARRAY, Opcodes.ANEWARRAY, Opcodes.ARRAYLENGTH -> push(interpreter.unaryOperation(insn, pop()))
            Opcodes.ATHROW -> interpreter.unaryOperation(insn, pop())
            Opcodes.CHECKCAST, Opcodes.INSTANCEOF -> push(interpreter.unaryOperation(insn, pop()))
            Opcodes.MONITORENTER, Opcodes.MONITOREXIT -> interpreter.unaryOperation(insn, pop())
            Opcodes.MULTIANEWARRAY -> {
                values = ArrayList<V>()
                for (i in (insn as MultiANewArrayInsnNode).dims downTo 1) {
                    values.add(0, pop())
                }
                push(interpreter.naryOperation(insn, values))
            }

            Opcodes.IFNULL, Opcodes.IFNONNULL -> interpreter.unaryOperation(insn, pop())
            else -> throw RuntimeException("Illegal opcode " + insn.opcode)
        }
    }

    private fun checkAnalyzerInvariant(condition: Boolean, insn: AbstractInsnNode, message: String) {
        checkAnalyzerInvariant(condition, insn) { message }
    }

    private inline fun checkAnalyzerInvariant(condition: Boolean, insn: AbstractInsnNode, message: () -> String) {
        if (!condition) throw AnalyzerException(insn, message())
    }

    /**
     * Merges this frame with the given frame.

     * @param frame
     * *            a frame.
     * *
     * @param interpreter
     * *            the interpreter used to merge values.
     * *
     * @return true if this frame has been changed as a result of the
     * *         merge operation, or false otherwise.
     * *
     * @throws AnalyzerException
     * *             if the frames have incompatible sizes.
     */
    fun merge(frame: MethodFrame<out V>, interpreter: Interpreter<V>): Boolean {
        if (stackSize != frame.stackSize) {
            throw AnalyzerException(null, "Incompatible stack heights")
        }
        var changes = false
        for (i in 0..locals + stackSize - 1) {
            val v = interpreter.merge(values[i], frame.values[i])
            if (v != values[i]) {
                values[i] = v
                changes = true
            }
        }
        return changes
    }

    /**
     * Returns a string representation of this frame.

     * @return a string representation of this frame.
     */
    override fun toString(): String {
        val sb = StringBuilder()
        for (i in 0..locals - 1) {
            sb.append(getLocal(i))
        }
        sb.append(' ')
        for (i in 0..stackSize - 1) {
            sb.append(getStack(i).toString())
        }
        return sb.toString()
    }
}
