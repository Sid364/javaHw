public class Not<T extends Number> extends UnaryOperation<T> {
    Not(Expression3<T> exp)  {
        super(exp);
    }
    
    public T evaluate(T x, T y, T z, Arithmetic<T> A) throws ExpressionExceptions {
        return A.not(exp.evaluate(x, y, z, A));
    }
}
