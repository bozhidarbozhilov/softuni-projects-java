import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class p16_PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int plantCount = Integer.parseInt(reader.readLine());

        ArrayList<String> plants = new ArrayList<>();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        String[] tokens = reader.readLine().split("\\s+");
        Collections.addAll(plants, tokens);

        int dayCounter = 0;
        boolean isDied = true;
        while(isDied){
            for (int i = 1; i < plants.size(); i++) {
                if(Integer.valueOf(plants.get(i-1)) < Integer.valueOf(plants.get(i))){
                    indexes.offer(i);
                }
            }
            if(indexes.isEmpty()){
                isDied = false;
            }else{
                int cnt = 0;
                dayCounter++;
                while(!indexes.isEmpty()){
                    int index = indexes.poll();
                    plants.remove(index-cnt);
                    cnt++;
                }
            }

        }

        System.out.print(dayCounter);
    }
}