import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p07_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> inputList = Arrays.stream(Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf)
                .toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));

        int[] numAndPower = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        int bombNumber = numAndPower[0];
        int power = numAndPower[1];

        for (int leftBomb = 0; leftBomb < inputList.size();leftBomb++) {
            if(inputList.get(leftBomb)==bombNumber){
                if(leftBomb-power<=0){
                    inputList.subList(0,leftBomb).clear();
                }
                else{
                    inputList.subList(leftBomb-power,leftBomb).clear();
                }

            }

        }
        for (int rightBomb = 0; rightBomb < inputList.size(); rightBomb++) {
            if(inputList.get(rightBomb)==bombNumber){
                if(rightBomb+power>=inputList.size()-1){
                    inputList.subList(rightBomb,inputList.size()).clear();
                }
                else{
                    inputList.subList(rightBomb,rightBomb+power+1).clear();
                }
            }

        }
        System.out.println(inputList.stream().mapToInt(e -> e).sum());
    }
}
