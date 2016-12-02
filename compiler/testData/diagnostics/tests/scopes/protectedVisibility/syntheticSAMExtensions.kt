// FILE: abc/A.java
package abc;
public class A {
    protected void foo(Runnable x) {}
}

// FILE: main.kt
import abc.A;


class B : A() {
    fun baz(a: A) {
        if (a is B) {
            <!DEBUG_INFO_SMARTCAST!>a<!>.foo {}
        }
    }
}
