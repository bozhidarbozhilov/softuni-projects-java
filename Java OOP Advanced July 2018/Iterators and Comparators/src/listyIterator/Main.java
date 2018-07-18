package listyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        ListyIterator<String> listyIterator = null;

        while(!"END".equals(command)){
            String[] tokens = command.split("\\s+");
            switch(tokens[0]){
                case "Create":
                    if(tokens.length == 1){
                        listyIterator = new ListyIterator();
                    }else{
                        listyIterator = new ListyIterator(Arrays.copyOfRange(tokens, 1, tokens.length));
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try{
                        listyIterator.print();
                    }catch (UnsupportedOperationException uoe){
                        System.out.println(uoe.getMessage());
                    }

                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll(listyIterator);
                default:
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
