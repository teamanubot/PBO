package praktikum.sesi1;

import java.util.Scanner;
import java.util.Stack;

public class Kalkulator {
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == 'x' || c == ':' || c == '/';
    }

    public static int precedence(char operator) {
        if (operator == 'x' || operator == ':' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        }
        return -1;
    }

    public static double applyOperation(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'x':
                return a * b;
            case ':':
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Error: Division by zero");
                }
                return a / b;
            default:
                return 0;
        }
    }

    public static double evaluateExpression(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == ' ') {
                continue;
            }

            if (Character.isDigit(currentChar)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--;
                values.push(Double.parseDouble(sb.toString()));
            }

            else if (isOperator(currentChar)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(currentChar)) {
                    double b = values.pop();
                    double a = values.pop();
                    char op = operators.pop();
                    values.push(applyOperation(a, b, op));
                }
                operators.push(currentChar);
            }
        }

        while (!operators.isEmpty()) {
            double b = values.pop();
            double a = values.pop();
            char op = operators.pop();
            values.push(applyOperation(a, b, op));
        }

        return values.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan ekspresi matematika (contoh: 2 - 1 x 3 : 3): ");
        String input = scanner.nextLine();

        try {
            double result = evaluateExpression(input);
            System.out.println("Hasil: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Ekspresi tidak valid");
        }

        scanner.close();
    }
}
