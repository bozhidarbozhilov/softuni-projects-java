import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
public class p09_MaximumElement {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int max = Integer.MIN_VALUE;
        for(int i =0; i < cnt; i++) {
            String[] command = reader.readLine().split(" ");
            switch (command[0]) {
                case "1":
                    int element = Integer.parseInt(command[1]);
                    if (element > max) {
                        max = element;
                    }
                    stack.push(element);
                    break;
                case "2":
                    if (stack.pop() == max) {
                        max = Integer.MIN_VALUE;
                        for (int num : stack) {
                            if (num > max) {
                                max = num;
                            }
                        }
                    }
                    break;
                case "3":
                    res.append(max);
                    res.append("\n");
                    break;

            }
        }
        System.out.print(res);
    }
}
