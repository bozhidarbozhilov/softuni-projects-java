import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> inputList = Arrays.stream(Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf)
                .toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));
        boolean isTrue = true;
        while(isTrue){
            String[] command = scanner.nextLine().split("\\s+");

            switch(command[0]){
                case "Delete":
                    int element = Integer.valueOf(command[1]);
                    for (int i = 0; i < inputList.size(); i++) {
                        if(inputList.get(i) == element){
                            inputList.remove(i);
                            i -=1 ;
                        }
                    }
                    break;
                case "Insert":
                    int elementToInsert = Integer.valueOf(command[1]);
                    int position = Integer.valueOf(command[2]);
                    inputList.add(position,elementToInsert);
                    break;
                case "Even":
                    for (int i = 0; i < inputList.size(); i++) {
                        if(inputList.get(i)%2==0){
                            System.out.print(inputList.get(i)+" ");
                        }
                    }
                    isTrue=false;
                    break;
                case "Odd":
                    for (int i = 0; i < inputList.size(); i++) {
                        if(inputList.get(i)%2!=0){
                            System.out.print(inputList.get(i)+" ");
                        }
                    }
                    isTrue=false;
                    break;
            }
        }
    }
}
