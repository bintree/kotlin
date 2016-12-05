// FILE: abc/A.java
package abc;
public class A {
    protected void foo(Runnable x) {}
}

// FILE: main.kt
import abc.A;

class Data(var x: A)

class B : A() {
    fun baz(a: A, b: B, d: Data) {
        a.<!NONE_APPLICABLE!>foo<!> { }

        b.foo { }

        if (a is B) {
            <!DEBUG_INFO_SMARTCAST!>a<!>.foo {}
        }

        if (d.x is B) {
            d.x.<!NONE_APPLICABLE!>foo<!> {}
        }
    }
}

fun baz(a: A) {
    a.<!NONE_APPLICABLE!>foo<!> { }
}
