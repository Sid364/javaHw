public class Multiply<T extends Number> extends BinaryOperation<T> {
    public Multiply(Expression3<T> f, Expression3<T> s) {
        super(f, s);
    }
    public T solve(T a, T b, Arithmetic<T> A) throws ExpressionExceptions {
		return A.mul(a, b);
	}
}
