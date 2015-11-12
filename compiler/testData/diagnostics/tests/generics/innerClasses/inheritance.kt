// See KT-3357
public interface ReturnInnerSubclassOfSupersInner {
    open class Super<T> {
        inner open class Inner {
            open fun getOuter(): Super<T> = throw UnsupportedOperationException()
        }
    }

    class Sub<T1>() : Super<T1>() {
        inner class Inner: Super<T1>.Inner() { // 'Inner' is unresolved
            override fun getOuter(): Sub<T1> = throw UnsupportedOperationException()
        }
    }
}
