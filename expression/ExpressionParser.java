import java.math.BigInteger;
public class ExpressionParser <T extends Number> {
    String s;
    int bal = 0;
    int last;
    Arithmetic<T> A;
    void deleteSpaces() {
        while (last < s.length() && (s.charAt(last) == ' ' || s.charAt(last) == '\t')) {
            last++;
        }
    }
    ExpressionParser(Arithmetic<T> A) {
		this.A = A;
	}
	T getNumber(int sign) throws ExpressionExceptions{
		char c = s.charAt(last);
        int st = last;
        while (c >= '0' && c <= '9' || c == '.' || c == 'E' || c == '-') {
            last++;
            if (last == s.length()) {
                break;
            }
            c = s.charAt(last);
        }
        String number = s.substring(st, last);
        if (sign == -1) {
            number = "-" + number;
        }
        
        return A.getNumber(number);

	}
	Expression3<T> operand() throws ExpressionExceptions {
        deleteSpaces();
        if (last >= s.length())
			throw new ExpressionExceptions("Unexpected end of expression. \nExpected : operand");
        if (s.charAt(last) == '-') {
			last++;
			deleteSpaces();
            if ( last < s.length() && s.charAt(last) >= '0' && s.charAt(last) <= '9')
				return new Const<T>(getNumber(-1));
            return new UnaryMinus<T>(brackets());
        }
        if (s.charAt(last) == '~') {
            last++;
            deleteSpaces();
            return new Not<T>(brackets());
        }
        Expression3<T> res;
        char c = s.charAt(last);
        if (c >= '0' && c <= '9') {
           return new Const<T>(getNumber(1));
        } else if ( c == 'x' || c == 'y' || c == 'z') {
                c = s.charAt(last);
                String name = "" + c;
				last++;
            res = new Variable<T>(name);
        }
        else if ( c == 'a') {
			if (s.length() <= last + 3 || s.charAt(last+1) != 'b' || s.charAt(last + 2) != 's')
				throw new ExpressionExceptions("Not correct abs instruction"); 
			last += 3;
			return new Abs<T>(brackets());
		}
        else 
			throw new ExpressionExceptions("not correct expression.\nExpected : operand \nFound : " + s.charAt(last));
		return res;
    }
   
    Expression3<T> brackets() throws ExpressionExceptions {
        Expression3<T> res;
        deleteSpaces();
        if (last < s.length() && s.charAt(last) == '(') {
            last++;
            bal++;
            res = expr();
            deleteSpaces();
            if (s.length() == last || s.charAt(last) != ')')
				throw new ExpressionExceptions("Missed right bracket");
			else bal--;
            last++;
            deleteSpaces();
        } else {
            res = operand();
        }
        return res;
    }
   
    Expression3<T> factor() throws ExpressionExceptions {
        Expression3<T> res = brackets();
        deleteSpaces();
        while (last < s.length()) {
            switch (s.charAt(last)) {
                case '*':
                    last++;
                    res = new Multiply<T>(res, brackets());
                    break;
                case '/':
                    last++;
                    res = new Divide<T>(res, brackets());
                    break;
                case 'm' : 
					if (s.length() <= last + 3 || s.charAt(last+1) != 'o' || s.charAt(last + 2) != 'd')
						throw new ExpressionExceptions("Not correct mod instruction");
                    last += 3;
                    res  = new Mod<T>(res, brackets());
                    break;
                default:
					deleteSpaces();
					if (s.charAt(last) != '+' && s.charAt(last) != '-' && s.charAt(last) != ')')
						throw new ExpressionExceptions("Not correct expression. \nExpected: Some binary operation .\nFound: " + s.charAt(last));
                    return res;
            }
            deleteSpaces();
        }
        return res;
    }
   
    Expression3<T>  expr() throws ExpressionExceptions {
        Expression3<T> res = factor();
        deleteSpaces();
        while (last < s.length()) {
            switch (s.charAt(last)) {
                case '+':
                    last++;
                    res = new Add<T>(res, factor());
                    break;
                case '-':
                    last++;
                    res = new Subtract<T>(res, factor());
                    break;
                default:
                    return res;
            }
            deleteSpaces();
        }
        return res;
    }
   
    Expression3<T> parse(String input) throws ExpressionExceptions {
		bal = 0;
		Expression3<T> res = null;
		s = input;
        last = 0;
		res = expr();
		while (last < s.length()) {
			if (s.charAt(last) == '(')
				bal++;
			if (s.charAt(last) == ')')
				bal--;
			last++;
		}
		if (bal != 0) {
			throw new ExpressionExceptions("wrong brackets sequence. balance  = " + bal);
			
		}
		return res;
    }
    public void evaluate(String input) throws ExpressionExceptions {
		Expression3<T> exp = parse(input);
		for (int x = -100; x <= 100; x++) {
			for (int y = -100; y <= 100; y++) { 
				try {
					System.out.println( exp.evaluate(A.getNumber("" + x), A.getNumber("" + y), A.getNumber("3"), A) );
				} catch(Exception e) {
					System.out.println("error");
				}
			}
		}
	}
}
