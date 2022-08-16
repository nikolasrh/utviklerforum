package nikolasrh.utviklerforum.examples.exception

@JvmInline
value class PatchVersion(val value: Int) {
    init {
        require(value >= 0) { "Patch version can't be negative" }
    }
}
