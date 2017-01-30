package word.machine;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yeison Melo <melo.yeison@gmail.com>
 */
public class WordMachine {

    private final static String POP = "POP";
    private final static String DUP = "DUP";
    private final static String ADD = "+";
    private final static String SUBS = "-";
    private static final int ERROR = -1;
    private static final String ELEMENTS_EXCEPTION = "Less than two elements in the stack";
    private static final String NEGATIVE_EXPCEPTION = "Substraction with negative result";
    private static final String ESPACE = " ";
    private static final String OVERFLOW_EXCEPTION = "Overflow exception";

    private static void dup(Stack stack) {
        int a = (int) stack.pop();
        stack.push(a);
        stack.push(a);
    }

    private static void add(Stack stack) throws Exception {
        if (stack.size() >= 2) {
            int a = (int) stack.pop();
            int b = (int) stack.pop();
            if (a + b < 0) {
                throw new Exception(OVERFLOW_EXCEPTION);
            }
            stack.push(a + b);
        } else {
            throw new Exception(ELEMENTS_EXCEPTION);
        }
    }

    private static void subs(Stack stack) throws Exception {
        if (stack.size() >= 2) {
            int a = (int) stack.pop();
            int b = (int) stack.pop();
            int c = a - b;
            if (c >= 0) {
                stack.push(c);
            } else {
                throw new Exception(NEGATIVE_EXPCEPTION);
            }
        } else {
            throw new Exception(ELEMENTS_EXCEPTION);
        }
    }


    /**
     * @param S the command line arguments
     * @return 
     */
    public static int solution(String S) {

        Stack stack = new Stack();
        String[] operations = S.split(ESPACE);

        for (int i = 0; i < operations.length; ++i) {
            if (null == operations[i]) {
                stack.push(Integer.parseInt(operations[i]));
            } else {
                switch (operations[i]) {
                    case POP:
                        stack.pop();
                        break;
                    case DUP:
                        dup(stack);
                        break;
                    case ADD:
                        try {
                            add(stack);
                        } catch (Exception ex) {
                            Logger.getLogger(WordMachine.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                            return -1;
                        }
                        break;
                    case SUBS:
                        try {
                            subs(stack);
                        } catch (Exception ex) {
                            Logger.getLogger(WordMachine.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                            return -1;
                        }
                        break;
                    default:
                        stack.push(Integer.parseInt(operations[i]));
                        break;
                }
            }
        }
        if (stack.isEmpty()) {
            return ERROR;
        }
        return (int) stack.pop();
    }
}
