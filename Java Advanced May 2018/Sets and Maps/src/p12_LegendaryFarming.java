import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p12_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("motes", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("shards", 0);
        Map<String,Integer> otherMaterials = new TreeMap<>();

        while(scanner.hasNext()){
            int quantity = scanner.nextInt();
            String material = scanner.next().toLowerCase();

            if(isKeyMaterial(material)){
                keyMaterials.put(material, keyMaterials.get(material)+quantity);
                if(keyMaterials.get(material)>=250){
                    keyMaterials.put(material, keyMaterials.get(material)-250);
                    printWinner(material);
                    break;
                }
            }else{
                otherMaterials.putIfAbsent(material, 0);
                otherMaterials.put(material, otherMaterials.get(material)+quantity);
            }
        }
        scanner.close();
        String debug = "";
        keyMaterials.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .forEach(km-> System.out.printf("%s: %d%n", km.getKey(), km.getValue()));
        for (Map.Entry<String, Integer> material : otherMaterials.entrySet()) {
            System.out.printf("%s: %d%n", material.getKey(), material.getValue());
        }
    }

    private static void printWinner(String material) {
        switch (material){
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
            default:
                break;
        }
    }

    private static boolean isKeyMaterial(String material) {
        return "shards".equals(material) ||
                "fragments".equals(material) ||
                "motes".equals(material);
    }
}
