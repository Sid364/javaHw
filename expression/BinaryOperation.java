public abstract class BinaryOperation<T extends Number> implements Expression3<T> {
    Expression3<T> first, second;
    
    abstract public  T solve(T a, T b, Arithmetic<T> A) throws ExpressionExceptions;
    
    protected BinaryOperation(Expression3<T> first, Expression3<T> second) {
       // assert first != null;
        //assert second != null;
        this.first = first;
        this.second = second;
    }
    public T evaluate(T x, T y, T z, Arithmetic<T> A) throws ExpressionExceptions {
		return solve(first.evaluate(x, y, z, A), second.evaluate(x, y, z, A), A);
	}
}
