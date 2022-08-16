// package nikolasrh.utviklerforum

// infix fun <A, B> Result<A>.bind(f: (A) -> Result<B>) = bind(this, f)

// // infix fun <A, B, C> ((B) -> C).compose(f: ((A) -> B)) = compose(this, f)
// infix fun <A, B, C> ((B) -> C).compose(f: ((A) -> B)): (A) -> C = { x: A -> this(f(x)) }
