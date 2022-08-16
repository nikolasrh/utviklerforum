/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package nikolasrh.utviklerforum

import nikolasrh.utviklerforum.examples.exception.*

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    // println(App().greeting)

    val major = MajorVersion(0)
    val minor = MinorVersion(0)
    val patch = PatchVersion(0)
    val semver = SemanticVersion(major, minor, patch)

    println(semver)
}