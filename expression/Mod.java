public class Mod extends BinaryOperation {
	Mod(Expression3 a, Expression3 b) {
		super(a, b);
	}
	public int solve(int a, int b) throws ExpressionExceptions {
		if (b == 0) 
			throw new ExpressionExceptions("mod by zero, silly");
		return a % b;
	}
}
