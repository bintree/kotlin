// WITH_RUNTIME
// WITH_COROUTINES
import kotlin.coroutines.*

class A {
    suspend operator fun get(i: Int): String = CoroutineIntrinsics.suspendCoroutineOrReturn { x ->
        x.resume(i.toString())
        CoroutineIntrinsics.SUSPENDED
    }
}

fun builder(c: suspend () -> Unit) {
    c.startCoroutine(EmptyContinuation)
}

fun box(): String {
    var result = ""
    val a = A()

    builder {
        result = a[56]
    }

    if (result != "56") return "fail 1: $result"

    return "OK"
}
