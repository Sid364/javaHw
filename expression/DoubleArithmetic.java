public class DoubleArithmetic implements Arithmetic<Double> {
	public Double add(Double a, Double b) {
		return Double.valueOf(a.doubleValue() + b.doubleValue());
	}
	public Double mul(Double a, Double b) {
		return Double.valueOf(a.doubleValue() * b.doubleValue());
	}
	public Double div(Double a, Double b) {
		return Double.valueOf(a.doubleValue() / b.doubleValue());
	}
	public Double mod(Double a, Double b) {
		return Double.valueOf(a.doubleValue() % b.doubleValue());
	}
	public Double neg(Double a) {
		return Double.valueOf(-a.doubleValue());
	}
	public Double sub(Double a, Double b) {
		return Double.valueOf(a.doubleValue() - b.doubleValue());
	}
	public Double not(Double a) throws ExpressionExceptions {
		throw new ExpressionExceptions("you cannot use ~ operation with double type, sorry");
	}
	public Double getNumber(String str) {
		return new Double(str);
	}
	public Double abs(Double a) {
		if ( a < 0)
			a = -a;
		return a;
	}
}

