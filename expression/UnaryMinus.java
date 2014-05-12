public class UnaryMinus<T extends Number> extends UnaryOperation<T> {
    UnaryMinus(Expression3<T> exp) {
        super(exp);
    }
    
    public T evaluate(T x, T y, T z, Arithmetic<T> A) throws ExpressionExceptions {
        return A.neg(exp.evaluate(x, y, z, A));
    }
}
