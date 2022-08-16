package nikolasrh.utviklerforum.examples.exception

@JvmInline
value class MajorVersion(val value: Int) {
    init {
        require(value >= 0) { "Major version can't be negative" }
    }
}
