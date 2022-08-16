package nikolasrh.utviklerforum.examples.exception

data class SemanticVersion(
                val major: MajorVersion,
                val minor: MinorVersion,
                val patch: PatchVersion
) {
        init {
                require(major.value != 0 && minor.value != 0 && patch.value != 0) {
                        "Semantic version can't be 0.0.0"
                }
        }
}
