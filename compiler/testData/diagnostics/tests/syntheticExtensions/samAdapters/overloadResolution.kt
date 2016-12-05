// !CHECK_TYPE
// FILE: A.java
public class A {
    public int foo(Runnable r) { return 0; }
    public String foo(Object r) { return null;}
}

// FILE: 1.kt
fun fn() {}
fun x() {
    A().foo(::fn) checkType { _<Int>() } // resolved to `foo(Object)` because SAM descriptor has low priority
    A().foo {} checkType { _<Int>() } // same problem
}
