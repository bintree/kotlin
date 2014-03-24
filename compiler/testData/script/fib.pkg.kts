package kotlin.scripting.fibonacci
// this script expected parameter num : Int

fun fib(n: Int): Int {
    val v = if(n < 2) 1 else fib(n-1) + fib(n-2)
    System.out.println("fib($n)=$v")
    return v
}

System.out.println("num: $num")
val result = fib(num)
