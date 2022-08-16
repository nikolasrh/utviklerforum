package nikolasrh.utviklerforum.examples.exception

@JvmInline
value class MinorVersion(val value: Int) {
    init {
        require(value >= 0) { "Minor version can't be negative" }
    }
}
