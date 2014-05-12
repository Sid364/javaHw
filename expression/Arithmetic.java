public interface Arithmetic<T extends Number> {
	T add(T a, T b) throws ExpressionExceptions;
	T mul(T a, T b) throws ExpressionExceptions;
	T sub(T a, T b) throws ExpressionExceptions;
	T neg(T a);
	T div(T a, T b) throws ExpressionExceptions;
	T not(T a) throws ExpressionExceptions;
	T mod(T a, T b) throws ExpressionExceptions;
	T getNumber(String str) throws ExpressionExceptions;
	T abs(T a) throws ExpressionExceptions;
}
