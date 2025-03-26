import java.util.Stack;

public class InfixToPostfix {

    // Method to get precedence of operators
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // Method to perform the conversion from infix to postfix
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // If the character is an operand, append it to the result
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }
            // If the character is '(', push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If the character is ')', pop until '(' is encountered
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Pop '('
            }
            // If the character is an operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all the operators from the stack and append to postfix
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + infix);
        System.out.println("Postfix Expression: " + infixToPostfix(infix));
    }
}
