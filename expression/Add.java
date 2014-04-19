public class Add extends BinaryOperation {
    public Add(Expression3 f, Expression3 s) {
        super(f, s);
    }
    public int solve(int a, int b) throws ExpressionExceptions {
		//if (b > 0 && a  >  Integer.MAX_VALUE - b
        //|| (b < 0 && a < Integer.MIN_VALUE - b))
        long f = a, s = b;
			if ( f + s > Integer.MAX_VALUE ||
				f + s < Integer.MIN_VALUE)
			throw new ExpressionExceptions("overflow");
		return a + b;
	}
}
