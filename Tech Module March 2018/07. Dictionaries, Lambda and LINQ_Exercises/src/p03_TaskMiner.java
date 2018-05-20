import java.util.LinkedHashMap;
import java.util.Scanner;

public class p03_TaskMiner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String,Integer> preciousMetal = new LinkedHashMap<>();

        String inputStr = scanner.nextLine();
        String metal = "";
        int counter = 1;

        while(!inputStr.equals("stop")){
            if(counter%2!=0){
                metal = inputStr;
                preciousMetal.putIfAbsent(metal,0);
            }else{
                Integer quantity = Integer.valueOf(inputStr);
                preciousMetal.put(metal,preciousMetal.get(metal)+quantity);
            }
            inputStr = scanner.nextLine();
            counter++;
        }

        preciousMetal.entrySet().stream().forEach(m-> System.out.println(m.getKey() + " -> " + m.getValue()));
    }
}
