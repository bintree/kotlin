/*
 * Copyright 2010-2015 JetBrains s.r.o.
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

package org.jetbrains.kotlin.lang.resolve.android

trait KotlinWriter {
    fun toStringBuffer(): StringBuffer
}

class KotlinStringWriter : KotlinWriter {

    private val ctx = Context()
    private val imports = ctx.fork()
    private val body = ctx.fork()

    fun writeFunction(name: String,
                      args: Collection<String>?,
                      retType: String,
                      statements: Collection<String>) {
        val returnTerm = if (retType == "" || retType == "Unit") "" else ": $retType"
        val argStr = if (args != null) args.join(", ") else ""
        body.writeln("fun $name($argStr)$returnTerm {")
        body.incIndent()
        for (stmt in statements)
            body.writeln(stmt)
        body.decIndent()
        body.writeln("}")
    }

    fun writeExtensionFunction(receiver: String,
                               name: String,
                               args: Collection<String>?,
                               retType: String,
                               body: Collection<String>) {
        writeFunction("$receiver.$name", args, retType, body)
    }

    fun writeImmutableProperty(name: String,
                               retType: String,
                               getterBody: Collection<String>) {
        body.writeln("val $name: $retType")
        body.incIndent()
        body.write("get() ")
        if (getterBody.size > 1) {
            body.writeNoIndent("{\n")
            body.incIndent()
            for (stmt in getterBody) {
                body.writeln(stmt)
            }
            body.decIndent()
            body.writeln("}")
        }
        else {
            body.writeNoIndent("=")
            body.writeNoIndent(getterBody.join("").replace("return", ""))
            body.newLine()
        }
        body.decIndent()
        body.newLine()
    }

    fun writeImmutableExtensionProperty(receiver: String,
                                        name: String,
                                        retType: String,
                                        getterBody: Collection<String>) {
        writeImmutableProperty("$receiver.$name", retType, getterBody)
    }

    fun writeImport(what: String) {
        imports.writeln("import $what")
    }

    fun writePackage(_package: String) {
        ctx.writeln("package $_package\n")
    }

    fun writeEmptyLine() {
        body.newLine()
    }

    override fun toStringBuffer(): StringBuffer {
        ctx.absorbChildren()
        return ctx.buffer
    }

    override fun toString(): String {
        return ctx.buffer.toString()
    }
}

