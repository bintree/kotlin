package foo

// NOTE THIS FILE IS AUTO-GENERATED by the generateTestDataForReservedWords.kt. DO NOT EDIT!

trait export { default object {} }

fun box(): String {
    testNotRenamed("export", { export })

    return "OK"
}