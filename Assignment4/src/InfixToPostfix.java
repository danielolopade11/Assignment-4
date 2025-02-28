public class InfixToPostfix {
    public static int precedence(char ch) {
        switch (ch) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }

    public static String infixToPostfix(String exp) {
        DoublyLinkedList stack = new DoublyLinkedList();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            else if (c == '(') {
                stack.add(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.getTail().data != '(') {
                    result.append(stack.removeLast().data);
                }
                stack.removeLast();
            }
            else {
                while (!stack.isEmpty() && precedence(stack.getTail().data) >= precedence(c)) {
                    result.append(stack.removeLast().data);
                }
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.removeLast().data);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Postfix Expression: "  + infixToPostfix(exp));
    }
}