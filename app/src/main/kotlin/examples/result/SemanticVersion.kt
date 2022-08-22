package nikolasrh.utviklerforum.examples.result

data class SemanticVersion
private constructor(val major: MajorVersion, val minor: MinorVersion, val patch: PatchVersion) {
    companion object {
        fun create(
                major: MajorVersion,
                minor: MinorVersion,
                patch: PatchVersion
        ): Result<SemanticVersion> =
                when {
                    major.value == 0 && minor.value == 0 && patch.value == 0 ->
                            Error("Semantic version can't be 0.0.0")
                    else -> Ok(SemanticVersion(major, minor, patch))
                }
    }
}
