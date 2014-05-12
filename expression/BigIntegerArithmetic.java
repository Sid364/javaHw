import java.math.BigInteger;
public class BigIntegerArithmetic implements Arithmetic<BigInteger> {
	public BigInteger add(BigInteger a, BigInteger b) {
		return a.add(b);
	}
	public BigInteger mul(BigInteger a, BigInteger b) {
		return a.multiply(b);
	}
	public BigInteger div(BigInteger a, BigInteger b) {
		return a.divide(b);
	}
	public BigInteger mod(BigInteger a, BigInteger b) {
		return a.mod(b);
	}
	public BigInteger neg(BigInteger a) {
		return a.multiply(new BigInteger("-1"));
	}
	public BigInteger sub(BigInteger a, BigInteger b) {
		return a.subtract(b);
	}
	public BigInteger not(BigInteger a) throws ExpressionExceptions{
		return not(a);
	}
	public BigInteger getNumber(String str) {
		return new BigInteger(str);
	}
	public BigInteger abs( BigInteger a) {
		a = a.abs();
		return a;
	}
}

