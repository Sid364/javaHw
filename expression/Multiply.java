public class Multiply extends BinaryOperation {
    public Multiply(Expression3 f, Expression3 s) {
        super(f, s);
    }
    public int solve(int a, int b) throws ExpressionExceptions {
		long f = a, s = b;
			if ( f * s > Integer.MAX_VALUE ||
				f * s < Integer.MIN_VALUE)
			throw new ExpressionExceptions("overflow"); 
		return a * b;
	}
}
