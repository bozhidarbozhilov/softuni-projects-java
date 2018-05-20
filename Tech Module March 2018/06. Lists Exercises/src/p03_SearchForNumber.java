import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_SearchForNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> inputList = Arrays.stream(Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf)
                .toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));
        int[] conditionNums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int cnt = conditionNums[1]; cnt < conditionNums[0] ; cnt++) {
            resultList.add(inputList.get(cnt));
        }

        if(resultList.contains(conditionNums[2])){
            System.out.println("YES!");
        }else{
            System.out.println("NO!");
        }
    }
}
