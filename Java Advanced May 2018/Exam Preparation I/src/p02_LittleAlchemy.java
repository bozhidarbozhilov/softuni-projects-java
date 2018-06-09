import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p02_LittleAlchemy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputStones = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> table = new ArrayDeque<>();
        int storage = 0;

        for (int inputStone : inputStones) {
            table.offer(inputStone);
        }

        String line = scanner.nextLine();

        while(!"Revision".equals(line)){
            String[] tokens = line.split("\\s+");
            if("Apply".equals(tokens[0])){
                int stoneCount = Integer.parseInt(tokens[2]);
                while(--stoneCount>=0){
                    if(!table.isEmpty()){
                        int currentStone = table.poll();
                        currentStone -= 1;
                        if(currentStone == 0){
                            storage++;
                        }else{
                            table.offer(currentStone);
                        }
                    }
                }
            }else{
                int oxidedStone = Integer.parseInt(tokens[2]);
                if(storage !=0){
                    table.offer(oxidedStone);
                    storage--;
                }

            }
            line = scanner.nextLine();
        }
        System.out.println(table.toString().replaceAll("[\\[\\],]",""));
        System.out.println(storage);
    }
}
