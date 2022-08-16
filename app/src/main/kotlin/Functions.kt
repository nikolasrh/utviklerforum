// package nikolasrh.utviklerforum

// fun <A, B, C> compose(g: ((B) -> C), f: ((A) -> B)): (A) -> C = { x: A -> g(f(x)) }

// fun <A, B> bind(rx: Result<A>, f: (A) -> Result<B>): Result<B> =
//         when (rx) {
//             is Ok -> f(rx.value)
//             is Error -> Error(rx.error)
//         }

// fun <A> rtrn(x: A) = Ok(x)

// fun <A> id(x: A) = x

// fun <A> flatten(rrx: Result<Result<A>>) = bind(rrx, ::id)

// val nestedResult: Result<Result<Int>> = Ok(Ok(1))

// val result = flatten(nestedResult)

// fun <A, B> map(rx: Result<A>, f: (A) -> B): Result<B> = bind(rx, compose(::rtrn, f))
