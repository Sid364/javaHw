public class ExpressionParser {
    static String s;
    static int last;
   
    static void deleteSpaces() {
        while (last < s.length() && (s.charAt(last) == ' ' || s.charAt(last) == '\t')) {
            last++;
        }
    }
    static Expression3 operand() {
        deleteSpaces();
        if (s.charAt(last) == '-') {
            last++;
            return new UnaryMinus(brackets());
        }
        if (s.charAt(last) == '~') {
            last++;
            return new Not(brackets());
        }
        Expression3 res;
        char c = s.charAt(last);
        if (c >= '0' && c <= '9') {
            int val = 0;
            while (c >= '0' && c <= '9' && last < s.length()) {
                val = val * 10 + (c - '0');
                last++;
                if (last == s.length()) {
                    break;
                }
                c = s.charAt(last);
            }
            res = new Const(val);
        } else {
            String name = "";
            while (c >= 'a' && c <= 'z') {
                name = name + c;
                last++;
                if (last == s.length()) {
                    break;
                }
                c = s.charAt(last);
            }
            res = new Variable(name);
        }
        return res;
    }
   
    static Expression3 brackets() {
        Expression3 res;
        deleteSpaces();
        if (s.charAt(last) == '(') {
            last++;
            res = expr();
            deleteSpaces();
            last++;
        } else {
            res = operand();
        }
        return res;
    }
   
    static Expression3 factor() {
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
                    last += 3;
                    res  = new Mod(res, brackets());
                    break;
                default:
                    return res;
            }
            deleteSpaces();
        }
        return res;
    }
   
    static Expression3 expr() {
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
   
    static Expression3 parse(String input) {
        s = input;
        last = 0;
        return expr();
    }
   
    public static void main(String args[]) {
        int res = parse("~256 + 1").evaluate(0, 0, 0);
        System.out.println(res);
    }
}
