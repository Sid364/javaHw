public class IntegerArithmetic implements Arithmetic<Integer> {
	public Integer add(Integer a, Integer b) throws ExpressionExceptions{
	//	long f = a.longValue(), s = b.longValue();
	//	if (f + s > Integer.MAX_VALUE || f + s < Integer.MIN_VALUE)
	//		throw new ExpressionExceptions("overflow");
		return Integer.valueOf(a.intValue() + b.intValue());
	}
	public Integer mul(Integer a, Integer b) throws ExpressionExceptions{
	//	long f = a.longValue(), s = b.longValue();
	//	if (f * s > Integer.MAX_VALUE || f * s < Integer.MIN_VALUE)
	//		throw new ExpressionExceptions("overflow");
		return Integer.valueOf(a.intValue() * b.intValue());
	}
	public Integer div(Integer a, Integer b) throws ExpressionExceptions{
		long f = a.longValue(), s = b.longValue();
		if (f / s > Integer.MAX_VALUE || f / s < Integer.MIN_VALUE)
			throw new ExpressionExceptions("overflow");
		if (b.intValue() == 0)
			throw new ExpressionExceptions("divide by zero, fool!");
		return Integer.valueOf(a.intValue() / b.intValue());
	}
	public Integer mod(Integer a, Integer b) throws ExpressionExceptions {
		if (b.intValue() == 0)
			throw new ExpressionExceptions("divide by zero, fool!");
		return Integer.valueOf(a.intValue() % b.intValue());
	}
	public Integer sub(Integer a, Integer b) throws ExpressionExceptions{
	//	long f = a.longValue(), s = b.longValue();
	//	if (f - s > Integer.MAX_VALUE || f - s < Integer.MIN_VALUE)
	//		throw new ExpressionExceptions("overflow");
		return Integer.valueOf(a.intValue() - b.intValue());
	}
	public Integer neg(Integer a) {
		return Integer.valueOf(-a.intValue());
	}
	public Integer not(Integer a) {
		return Integer.valueOf(~a.intValue());
	}
	public Integer getNumber(String str) throws ExpressionExceptions {
		return new Integer(str);
	}
	public Integer abs(Integer a) throws ExpressionExceptions {
		long c = Math.abs(a.longValue());
		if ( c > Integer.MAX_VALUE )
			throw new ExpressionExceptions("overflow");
		return Integer.valueOf((int)c);
	}
}

