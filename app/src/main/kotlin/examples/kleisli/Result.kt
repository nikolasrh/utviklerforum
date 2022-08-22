package nikolasrh.utviklerforum.examples.kleisli

sealed interface Result<T>

data class Ok<T>(val value: T) : Result<T>

data class Error<T>(val error: String) : Result<T>

fun <A> rtrn(x: A): Result<A> = Ok(x)

fun <A> id(x: A): A = x

fun <A> flatten(rrx: Result<Result<A>>): Result<A> = bind(::id, rrx)
// when (rrx) {
//     is Ok -> rrx.value
//     is Error -> Error(rrx.error)
// }

fun <A, B> bind(f: ((A) -> Result<B>), rx: Result<A>): Result<B> =
        when (rx) {
            is Ok -> f(rx.value)
            is Error -> Error(rx.error)
        }

fun <A, B> apply(rf: Result<(A) -> B>, rx: Result<A>): Result<B> =
        when {
            rf is Error && rx is Error -> Error("${rf.error}, ${rx.error}")
            rf is Error -> Error(rf.error)
            rx is Error -> Error(rx.error)
            rf is Ok && rx is Ok -> Ok(rf.value(rx.value))
            else -> throw Exception()
        }
// = bind({ f -> map(f, rx) }, rf)
// when (rf) {
//     is Error -> Error(rf.error)
//     is Ok ->
//             when (rx) {
//                 is Error -> Error(rx.error)
//                 is Ok -> Ok(rf.value(rx.value))
//             }
// }

infix fun <A, B> Result<(A) -> B>.`applyOp`(rx: Result<A>): Result<B> = apply(this, rx)
// when (this) {
//     is Error -> Error(this.error)
//     is Ok ->
//             when (rx) {
//                 is Error -> Error(rx.error)
//                 is Ok -> Ok(this.value(rx.value))
//             }
// }

fun <A, B> map(f: ((A) -> B), rx: Result<A>): Result<B> = bind(compose(::rtrn, f), rx)
// when (rx) {
//     is Ok -> Ok(f(rx.value))
//     is Error -> Error(rx.error)
// }

fun <A, B> mapError(f: ((String) -> String), rx: Result<A>): Result<A> =
        when (rx) {
            is Ok -> rx
            is Error -> Error(f(rx.error))
        }
