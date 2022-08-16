package nikolasrh.utviklerforum

import nikolasrh.utviklerforum.examples.result.*

fun main() {
        val major = MajorVersion.create(0)
        val minor = MinorVersion.create(0)
        val patch = PatchVersion.create(1)

        val semverElse =
                        when {
                                major is Ok && minor is Ok && patch is Ok ->
                                                SemanticVersion.create(
                                                                major.value,
                                                                minor.value,
                                                                patch.value
                                                )
                                else -> Error("Something was wrong with major, minor or patch...")
                        }

        println(semverElse)

        val semverElse2 =
                        when {
                                major is Ok && minor is Ok && patch is Ok ->
                                                SemanticVersion.create(
                                                                major.value,
                                                                minor.value,
                                                                patch.value
                                                )
                                major is Error -> Error(major.error)
                                minor is Error -> Error(minor.error)
                                patch is Error -> Error(patch.error)
                                else -> Error("This shouldn't really happen")
                        }

        println(semverElse2)

        val semverExhaustive =
                        when (major) {
                                is Error -> Error(major.error)
                                is Ok ->
                                                when (minor) {
                                                        is Error -> Error(minor.error)
                                                        is Ok ->
                                                                        when (patch) {
                                                                                is Error ->
                                                                                                Error(
                                                                                                                patch.error
                                                                                                )
                                                                                is Ok ->
                                                                                                SemanticVersion.create(
                                                                                                                major.value,
                                                                                                                minor.value,
                                                                                                                patch.value
                                                                                                )
                                                                        }
                                                }
                        }

        println(semverExhaustive)
}
