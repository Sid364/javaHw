public class test {
	static <T extends Number> T print(T a) {
		if (a instanceof Integer)
			System.out.println("yes");
		else System.out.println("no");
		return a;
	}
	public static void main(String args[]) throws ExpressionExceptions {
		//Double x = new Double("xyz");
		System.out.println(new Integer("-5"));
	}
}
