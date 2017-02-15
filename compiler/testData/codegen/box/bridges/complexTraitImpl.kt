// FILE: JavaScriptParser.java
public class JavaScriptParser<T extends JSPsiTypeParser> {}
// FILE: JSPsiTypeParser.java
public class JSPsiTypeParser<T extends JavaScriptParser> {}

// FILE: ES6Parser.java

public class ES6Parser<T extends JSPsiTypeParser> extends JavaScriptParser<T> {}

// FILE: main.kt

fun createParser(): JavaScriptParser<*>? {
    ES6Parser<JSPsiTypeParser<*>>()
    return null
}
