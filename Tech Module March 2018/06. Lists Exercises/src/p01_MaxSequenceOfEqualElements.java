import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_MaxSequenceOfEqualElements {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> inputList = Arrays.stream(Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::valueOf).toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));

        int bestLen = 0;
        int startLen = 1;
        int num =0;
        int bestNum = 0;

        for (int cnt = 1; cnt < inputList.size(); cnt++) {
            if(inputList.get(cnt) == inputList.get(cnt-1)){
                startLen++;
            }else{

                startLen = 1;
            }
            if(startLen > bestLen){
                bestLen = startLen;
                bestNum = inputList.get(cnt-1);
            }

        }
        for (int i = 0; i < bestLen; i++) {
            System.out.print(bestNum+" ");
        }
    }
}
