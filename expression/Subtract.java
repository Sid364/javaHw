public class Subtract extends BinaryOperation {
    public Subtract(Expression3 f, Expression3 s) {
        super(f, s);
    }
    public int solve(int a, int b) throws ExpressionExceptions {
		if ((b < 0 && a > Integer.MAX_VALUE + b) ||
			 b > 0 && a < Integer.MIN_VALUE + b) 
			throw new ExpressionExceptions("overflow");
		return a - b;
	}
}
