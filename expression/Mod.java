public class Mod extends BinaryOperation {
	Mod(Expression3 a, Expression3 b) {
		super(a, b);
	}
	public int evaluate(int x, int y, int z) {
        return first.evaluate(x, y, z) % second.evaluate(x, y, z);
    }
}
