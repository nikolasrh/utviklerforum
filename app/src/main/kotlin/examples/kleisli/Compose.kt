package nikolasrh.utviklerforum.examples.kleisli

fun <A, B, C> compose(g: ((B) -> C), f: ((A) -> B)): (A) -> C = { x: A -> g(f(x)) }

infix fun <A, B, C> ((B) -> C).composeOp(f: ((A) -> B)): (A) -> C = { x: A -> this(f(x)) }

fun <A, B, C> kleisliCompose(g: (B) -> Result<C>, f: (A) -> Result<B>): (A) -> Result<C> = { x: A ->
    bind(g, f(x))
}

infix fun <A, B, C> ((B) -> Result<C>).kleisliComposeOp(f: (A) -> Result<B>): (A) -> Result<C> =
        { x: A ->
            bind(this, f(x))
        }
