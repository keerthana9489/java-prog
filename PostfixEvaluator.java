import java.util.Stack;

public class PostfixEvaluator {

    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        // Stack to hold operands
        Stack<Integer> stack = new Stack<>();
        
        // Loop through each character in the postfix expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            // If the character is a digit (operand), push it to the stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert char to integer
            } 
            // If the character is an operator, pop operands and apply the operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int operand2 = stack.pop(); // Second operand
                int operand1 = stack.pop(); // First operand
                
                // Apply the operator
                switch (ch) {
                    case '+': 
                        stack.push(operand1 + operand2);
                        break;
                    case '-': 
                        stack.push(operand1 - operand2);
                        break;
                    case '*': 
                        stack.push(operand1 * operand2);
                        break;
                    case '/': 
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        
        // The result will be the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "23*5+";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
        System.out.println("Result: " + result);
    }
}
