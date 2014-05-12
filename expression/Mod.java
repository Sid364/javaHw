public class Mod<T extends Number> extends BinaryOperation<T> {
	Mod(Expression3<T> a, Expression3<T> b) {
		super(a, b);
	}
	public T solve(T a, T b, Arithmetic<T> A) throws ExpressionExceptions {
		if (b.intValue() == 0) 
			throw new ExpressionExceptions("mod by zero, silly");
		return A.mod(a, b);
	}
}
