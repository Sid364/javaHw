import java.math.BigInteger;
public class GenericParser {
	public static void main(String args[]) throws ExpressionExceptions {
		ExpressionParser<? extends Number> A;
		if ( args[0].equals("-i")) {
			A = new ExpressionParser<Integer>(new IntegerArithmetic());
		} else if ( args[0].equals("-d")) {
			A = new ExpressionParser<Double>(new DoubleArithmetic());
		} else {
			A = new ExpressionParser<BigInteger>(new BigIntegerArithmetic());
		}
		try {
			A.evaluate(args[1]);
		} catch(Exception e) {
			System.out.println("error");
		}
	}
}
