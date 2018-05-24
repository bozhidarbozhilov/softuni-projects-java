import java.util.ArrayDeque;
import java.util.Scanner;

public class p12_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] sequenceOfParentheses = scanner.nextLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;

        for (char _char : sequenceOfParentheses) {
            if (_char == '[') {
                stack.push(_char);

            } else if (_char == '{') {
                stack.push(_char);

            } else if (_char == '(') {
                stack.push(_char);

            } else if (_char == '}') {
                if (stack.isEmpty()||stack.pop() != '{') {
                    isBalanced = false;
                    break;
                }

            } else if (_char == ']') {
                if (stack.isEmpty()||stack.pop() != '[') {
                    isBalanced = false;
                    break;
                }

            } else if (_char == ')') {
                if (stack.isEmpty()||stack.pop() != '(') {
                    isBalanced = false;
                    break;
                }

            }
        }
        if(isBalanced){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
