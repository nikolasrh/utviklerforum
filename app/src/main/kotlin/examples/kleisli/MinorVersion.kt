package nikolasrh.utviklerforum.examples.kleisli

import nikolasrh.utviklerforum.*

@JvmInline
value class MinorVersion private constructor(val value: Int) {
    companion object {
        fun create(value: Int): Result<MinorVersion> =
                when {
                    value < 0 -> Error("Minor version can't be less than 0")
                    else -> Ok(MinorVersion(value))
                }
    }
}
