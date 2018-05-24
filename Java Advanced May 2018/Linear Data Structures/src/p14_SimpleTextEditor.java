import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.IntStream;

public class p14_SimpleTextEditor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> undo = new ArrayDeque<>();
        ArrayDeque<String> commandStack = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        String prevState = "";
        for (int i = 0; i < num; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch(command){
                case "1":
                    String toAppend = tokens[1];
                    prevState = text.toString();
                    text.append(toAppend);
                    undo.push(prevState);
                    break;
                case "2":
                    int charsToErase = Integer.parseInt(tokens[1]);
                    prevState = text.toString();
                    if(text.length()-charsToErase <=0){
                        text.delete(0, text.length());
                    }else{
                        text.delete(text.length()-charsToErase, text.length());
                    }
                    undo.push(prevState);
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1])-1;
                    System.out.println(text.toString().charAt(index));
                    break;
                case "4":
                    text.replace(0,text.length(),undo.pop());
                    break;
                default:
                    break;
            }
        }
    }
}
