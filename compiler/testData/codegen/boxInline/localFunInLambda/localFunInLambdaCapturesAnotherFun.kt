// FILE: 1.kt
// WITH_RUNTIME
package test

public inline fun myRun(block: () -> Unit) {
    return block()
}

// FILE: 2.kt

//NO_CHECK_LAMBDA_INLINING
import test.*

fun box(): String {
    val x = ""
    buildString {
        fun f1() {
            x.length
        }
        fun f2() {
            f1()
        }
    }

    return "OK"
}
