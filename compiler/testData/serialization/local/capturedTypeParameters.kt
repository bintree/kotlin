// CLASS_NAME_SUFFIX: A$main$Local

class A<E, F> {
    fun <G> main() {
        class Local<H> {
            val e: E = null!!
            val f: F = null!!
            val g: G = null!!
            val h: H = null!!
        }
    }
}
