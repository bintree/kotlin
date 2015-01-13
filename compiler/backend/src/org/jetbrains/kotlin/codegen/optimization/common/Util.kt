/*
 * Copyright 2010-2014 JetBrains s.r.o.
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
 */

package org.jetbrains.kotlin.codegen.optimization.common

import org.jetbrains.org.objectweb.asm.tree.AbstractInsnNode
import org.jetbrains.org.objectweb.asm.Opcodes
import org.jetbrains.org.objectweb.asm.tree.analysis.Frame
import org.jetbrains.org.objectweb.asm.tree.analysis.BasicValue

fun AbstractInsnNode.isStoreOperation(): Boolean = getOpcode() in Opcodes.ISTORE..Opcodes.ASTORE
fun AbstractInsnNode.isLoadOperation(): Boolean = getOpcode() in Opcodes.ILOAD..Opcodes.ALOAD
fun AbstractInsnNode.isReturnOperation(): Boolean = getOpcode() in Opcodes.IRETURN..Opcodes.RETURN
fun <V : BasicValue?> Frame<V>.getStackTop(): V = getStack(getStackSize() - 1)

class InsnStream(val from: AbstractInsnNode, val to: AbstractInsnNode?) : Stream<AbstractInsnNode> {
    override fun iterator(): Iterator<AbstractInsnNode> {
        return object : Iterator<AbstractInsnNode> {
            var current = from
            override fun next(): AbstractInsnNode {
                val result = current
                current = current.getNext()
                return result
            }
            override fun hasNext() = current != to
        }
    }
}
