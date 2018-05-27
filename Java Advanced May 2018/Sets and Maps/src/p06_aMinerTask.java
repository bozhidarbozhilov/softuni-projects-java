import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p06_aMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();
        String resource = "";
        int quantity = 0;

        int counter = 1;
        String input = scanner.nextLine();
        while(!"stop".equals(input)){
            if(counter%2!=0){
                resource = input;
                resources.putIfAbsent(resource, 0);
            }else{
                quantity = Integer.parseInt(input);
                resources.put(resource, resources.get(resource)+quantity);
            }
            counter++;
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(),entry.getValue());
        }
    }
}
