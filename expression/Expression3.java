/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 * @version $$Id$$
 */
 import java.math.BigInteger;
 
public interface Expression3<T extends Number> {
     T evaluate(T x, T y, T z, Arithmetic<T> A) throws ExpressionExceptions;
}
