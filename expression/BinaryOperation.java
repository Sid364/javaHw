public abstract class BinaryOperation implements Expression3 {
    Expression3 first, second;
    
    abstract public int solve(int a, int b) throws ExpressionExceptions;
    
    protected BinaryOperation(Expression3 first, Expression3 second) {
        assert first != null;
        assert second != null;
        this.first = first;
        this.second = second;
    }
    public int evaluate(int x, int y, int z) throws ExpressionExceptions {
		return solve(first.evaluate(x, y, z), second.evaluate(x, y, z));
	}
}
