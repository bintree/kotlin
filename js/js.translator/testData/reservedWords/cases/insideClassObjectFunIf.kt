package foo

// NOTE THIS FILE IS AUTO-GENERATED by the generateTestDataForReservedWords.kt. DO NOT EDIT!

class TestClass {
    default object {
        fun `if`() { `if`() }

        fun test() {
            testNotRenamed("if", { ::`if` })
        }
    }
}

fun box(): String {
    TestClass.test()

    return "OK"
}