public class Divide<T extends Number> extends BinaryOperation<T>{
    public Divide(Expression3<T> f, Expression3<T> s) {
        super(f, s);
    }
    public T solve(T a, T b, Arithmetic<T> A) throws ExpressionExceptions {
		return A.div(a, b);
	}
}
