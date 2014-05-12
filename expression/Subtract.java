public class Subtract<T extends Number> extends BinaryOperation<T> {
    public Subtract(Expression3<T> f, Expression3<T> s) {
        super(f, s);
    }
    public T solve(T a, T b, Arithmetic<T> A) throws ExpressionExceptions {
		return A.sub(a, b);
	}
}
