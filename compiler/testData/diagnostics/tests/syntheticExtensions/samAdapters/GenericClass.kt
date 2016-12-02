// FILE: KotlinFile.kt
fun foo(javaClass: JavaClass<String>): String {
    return javaClass.doSomething() { <!UNUSED_PARAMETER!>s<!>: String -> "" }
}

// FILE: JavaClass.java
public class JavaClass<T> {
    public T doSomething(I<T> i) { return t; }
}

interface I<T> {
    T doIt(T t);
}
