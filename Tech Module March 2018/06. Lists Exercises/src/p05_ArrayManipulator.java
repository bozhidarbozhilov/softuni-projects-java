import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p05_ArrayManipulator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] tempArr = scanner.nextLine().split("\\s+");
        ArrayList<Integer> inputList = new ArrayList<>();
        for (String num : tempArr) {
            inputList.add(Integer.valueOf(num));
        }
/*        ArrayList<Integer> inputList = Arrays.stream(Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf)
                .toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));*/

        String[] commands = scanner.nextLine().split("\\s+");
        while(!commands[0].equals("print")){
            switch (commands[0]){
                case "add":
                    int addIndex = Integer.parseInt(commands[1]);
                    int elementToAdd = Integer.parseInt(commands[2]);
                    inputList.add(addIndex, elementToAdd);
                    break;
                case "addMany":
                    int index = Integer.parseInt(commands[1]);

                    for (int i = 2; i < commands.length; i++) {
                        inputList.add(index+i-2,Integer.valueOf(commands[i]));
                    }
                    break;
                case "contains":
                    //int elementToSearch = ;
                    System.out.println(inputList.indexOf(Integer.parseInt(commands[1])));
                    break;
                case "remove":
                    int elementToRemove = Integer.parseInt(commands[1]);
                    inputList.remove(elementToRemove);
                    break;
                case "shift":
                    int shiftPosition = Integer.parseInt(commands[1]);
                    ArrayList<Integer> tempList = new ArrayList<>(inputList);
                    for (int i = 0; i < inputList.size(); i++) {
                        inputList.set(i,tempList.get((i+shiftPosition)%tempList.size()));
                    }
                    break;
                case "sumPairs":
                    if(inputList.size()%2==0){
                        for (int i = 0; i <inputList.size(); i++) {
                            inputList.set(i,inputList.get(i)+inputList.get(i+1));
                            inputList.subList(i+1,i+2).clear();
                        }
                    }else{
                        for (int i = 0; i < inputList.size()-1; i++) {
                            inputList.set(i,inputList.get(i)+inputList.get(i+1));
                            inputList.subList(i+1,i+2).clear();
                        }
                    }
                    break;
                default:
                    break;

            }
            commands = scanner.nextLine().split("\\s+");
        }
        System.out.println(inputList.toString());
    }
}
