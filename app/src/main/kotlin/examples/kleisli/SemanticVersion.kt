package nikolasrh.utviklerforum.examples.kleisli

import arrow.core.curried

data class SemanticVersion
private constructor(val major: MajorVersion, val minor: MinorVersion, val patch: PatchVersion) {
    companion object {
        val create = { major: MajorVersion, minor: MinorVersion, patch: PatchVersion ->
            when {
                major.value == 0 && minor.value == 0 && patch.value == 0 ->
                        Error("Semantic version can't be 0.0.0")
                else -> Ok(SemanticVersion(major, minor, patch))
            }
        }

        val createCurried = create.curried()
    }
}
