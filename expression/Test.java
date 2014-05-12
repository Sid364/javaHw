public class Test {
	public static void main(String args[]) throws ExpressionExceptions {
		String a[] = new String[10];
		a[0] = "-x5";
		a[1] = "abs ( - - x";
		a[2] = "5 mod ";
		a[3] = "-2147483648"; // Integer.MIN_VALUE
		a[4] = "-2147483648 / - 1";
		a[5] = "(x + 5";
		a[6] = " x / x";
		a[7] = "abss(5) ";
		a[8] = "5 + 5 )";
		a[9] = "((()))";  
		ExpressionParser<Integer> A;
		A = new ExpressionParser<Integer>(new IntegerArithmetic());
		for (int i = 0; i < 10; i++) {
			try {
				System.out.print("try to parse " + a[i] + "  = ");
				System.out.println(A.parse(a[i]).evaluate(0, 0, 0, A.A));
			} catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
	}
}
