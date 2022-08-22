package nikolasrh.utviklerforum.examples.kleisli

import nikolasrh.utviklerforum.*

@JvmInline
value class PatchVersion private constructor(val value: Int) {
    companion object {
        fun create(value: Int): Result<PatchVersion> =
                when {
                    value < 0 -> Error("Patch version can't be less than 0")
                    else -> Ok(PatchVersion(value))
                }
    }
}
