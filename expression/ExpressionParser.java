public class ExpressionParser {
    static String s;
    static int bal = 0;
    static int last;
    static void deleteSpaces() {
        while (last < s.length() && (s.charAt(last) == ' ' || s.charAt(last) == '\t')) {
            last++;
        }
    }
    static Expression3 operand() throws ExpressionExceptions {
        deleteSpaces();
        if (last >= s.length())
			throw new ExpressionExceptions("unexpected end of epression. \nExpected : operand");
        if (s.charAt(last) == '-') {
            last++;
            char c = s.charAt(last);
            if (s.length() > last && s.charAt(last) >= '0' && s.charAt(last) <= '9') {
				long val = 0;
				while (c >= '0' && c <= '9') {
					val = val * 10 + (c - '0');
					last++;
					if (last == s.length()) {
						break;
					}
					c = s.charAt(last);
				}
				val = -val;
				if (val < Integer.MIN_VALUE)
					throw new ExpressionExceptions("you wrote too small number");
				else return new Const((int)val);
			}
            return new UnaryMinus(brackets());
        }
        if (s.charAt(last) == '~') {
            last++;
            return new Not(brackets());
        }
        Expression3 res;
        char c = s.charAt(last);
        if (c >= '0' && c <= '9') {
            long val = 0;
            while (c >= '0' && c <= '9' && last < s.length()) {
				val = val * 10 + (c - '0');
                last++;
                if (last == s.length()) {
                    break;
                }
                c = s.charAt(last);
            }
            int val1 = (int)val;
            if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE)
				throw new ExpressionExceptions("you wrote too big number");
            res = new Const(val1);
        } else if ( c == 'x' || c == 'y' || c == 'z') {
                c = s.charAt(last);
                String name = "" + c;
				last++;
            res = new Variable(name);
        }
        else 
			throw new ExpressionExceptions("not correct expression.\nExpected : operand \nFound : " + s.charAt(last));
        return res;
    }
   
    static Expression3 brackets() throws ExpressionExceptions {
        Expression3 res;
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
        } else {
            res = operand();
        }
        return res;
    }
   
    static Expression3 factor() throws ExpressionExceptions {
        Expression3 res = brackets();
        deleteSpaces();
        while (last < s.length()) {
            switch (s.charAt(last)) {
                case '*':
                    last++;
                    res = new Multiply(res, brackets());
                    break;
                case '/':
                    last++;
                    res = new Divide(res, brackets());
                    break;
                case 'm' : 
					if (s.length() <= last + 3 || s.charAt(last+1) != 'o' || s.charAt(last + 2) != 'd')
						throw new ExpressionExceptions("Not correct expression. Expected: mod");
                    last += 3;
                    res  = new Mod(res, brackets());
                    break;
                default:
					deleteSpaces();
					if (s.charAt(last) != '+' && s.charAt(last) != '-' && s.charAt(last) != ')')
						throw new ExpressionExceptions("Not correct expression. \nExpected: +, - or ')'.\nFound: " + s.charAt(last));
                    return res;
            }
            deleteSpaces();
        }
        return res;
    }
   
    static Expression3 expr() throws ExpressionExceptions {
        Expression3 res = factor();
        deleteSpaces();
        while (last < s.length()) {
            switch (s.charAt(last)) {
                case '+':
                    last++;
                    res = new Add(res, factor());
                    break;
                case '-':
                    last++;
                    res = new Subtract(res, factor());
                    break;
                default:
                    return res;
            }
            deleteSpaces();
        }
        return res;
    }
   
    static Expression3 parse(String input) throws ExpressionExceptions {
		Expression3 res = null;
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
		if (bal != 0)
			throw new ExpressionExceptions("wrong brackets sequence.");
		return res;
    }
   
    public static void main(String args[]) throws ExpressionExceptions {
		int res = 0;
		//System.out.println(Integer.MIN_VALUE);
		try {
			res = parse("-2147483648 / -1").evaluate(17, 3, 0);
		} catch(ExpressionExceptions e)  {
			System.out.println(e.getMessage());
			System.exit(0);
		}
        System.out.println(res);
    }
}
