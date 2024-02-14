public class Calculator {
    public static double evaluate(String expression) {
        try {
            String[] parts = expression.split(" ");
            double operand1 = Double.parseDouble(parts[0]);
            double operand2 = Double.parseDouble(parts[2]);
            String operator = parts[1];
            switch (operator) {
                case "+":
                    return operand1 + operand2;
                case "-":
                    return operand1 - operand2;
                case "*":
                    return operand1 * operand2;
                case "/":
                    if (operand2 != 0) {
                        return operand1 / operand2;
                    } else {
                        throw new ArithmeticException("Division by zero");
                    }
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }
}