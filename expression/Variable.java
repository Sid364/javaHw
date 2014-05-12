public class Variable<T extends Number> implements Expression3<T> {
    private String name;
    
    public Variable (String name) {
        assert name != null;
        this.name = name;
    }
    
    public T evaluate(T x, T y, T z, Arithmetic<T> A) {
        if (name.equals("x")) {
            return x;
        } else if (name.equals("y")) {
            return y;
        } else if (name.equals("z")) {
            return z;
        } else {
            return x;
        }
    }
}
