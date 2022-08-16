package nikolasrh.utviklerforum.examples.result

import nikolasrh.utviklerforum.*

@JvmInline
value class MajorVersion private constructor(val value: Int) {
    companion object {
        fun create(value: Int): Result<MajorVersion> =
                when {
                    value < 0 -> Error("Major version can't be less than 0")
                    else -> Ok(MajorVersion(value))
                }
    }
}
