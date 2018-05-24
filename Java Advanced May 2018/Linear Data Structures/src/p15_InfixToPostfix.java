import java.util.ArrayDeque;
import java.util.Scanner;

public class p15_InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        StringBuilder output = new StringBuilder();
        ArrayDeque<String> operators = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                if(!operators.isEmpty() &&
                        precedence(operators.peek())>=precedence(token)
                        && !"(".equals(token)){
                    output.append(operators.pop()).append(" ");
                }
                operators.push(token);

            } else if (")".equals(token)) {
                while(!operators.peek().equals("(")){
                    output.append(operators.pop()).append(" ");
                }
                operators.pop();
            } else {
                output.append(token).append(" ");
            }
        }
        System.out.print(output.toString());
        while(!operators.isEmpty()){
            System.out.print(operators.pop()+" ");
        }

    }

    private static boolean isOperator(String token) {
        return "-".equals(token) || "+".equals(token) ||
                "*".equals(token) || "/".equals(token) ||
                "(".equals(token);
    }

    private static int precedence(String operator){
        int precedence = 0;
        switch(operator){
            case "+":
            case "-":
                precedence = 2;
                break;
            case "*":
            case "/":
                precedence = 3;
                break;
            default:
                break;
        }
        return precedence;
    }
}
