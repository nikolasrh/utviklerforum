package nikolasrh.utviklerforum.examples.result

sealed interface Result<T>

data class Ok<T>(val value: T) : Result<T>

data class Error<T>(val error: String) : Result<T>
