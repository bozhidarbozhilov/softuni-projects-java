import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p09_LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,Integer> keyMaterials = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> junkMaterials = new LinkedHashMap<>();

        keyMaterials.putIfAbsent("shards", 0);
        keyMaterials.putIfAbsent("motes",0);
        keyMaterials.putIfAbsent("fragments",0);

        String line = "";


        while((line = reader.readLine())!=null){
            String[] tokens = line.toLowerCase().split("\\s+");
            for (int cnt = 1; cnt < tokens.length; cnt+=2) {
                int currentQuantity = Integer.valueOf(tokens[cnt-1]);
                if(tokens[cnt].equals("shards")) {
                    keyMaterials.put("shards", keyMaterials.get("shards") + currentQuantity);
                    if (keyMaterials.get("shards") >= 250) {
                        break;
                    }
                }else if(tokens[cnt].equals("motes")) {
                    keyMaterials.put("motes", keyMaterials.get("motes") + currentQuantity);
                    if (keyMaterials.get("motes") >= 250) {
                        break;
                    }
                }else if(tokens[cnt].equals("fragments")) {
                    keyMaterials.put("fragments", keyMaterials.get("fragments") + currentQuantity);
                    if (keyMaterials.get("fragments") >= 250) {
                        break;
                    }
                }else{
                    junkMaterials.putIfAbsent(tokens[cnt], 0);
                    junkMaterials.put(tokens[cnt], junkMaterials.get(tokens[cnt]) + currentQuantity);
                }
            }
            if(keyMaterials.get("shards")>=250) {
                keyMaterials.put("shards", keyMaterials.get("shards") - 250);
                System.out.println("Shadowmourne obtained!");
                keyMaterials.entrySet().stream().
                        sorted((a, b) ->{
                                int index = b.getValue().compareTo(a.getValue());
                                if (index == 0){
                                    index = a.getKey().compareTo(b.getKey());
                                }
                                return index;
                            }).
                        forEach(kM -> System.out.println(kM.getKey() + ": " + kM.getValue()));
                junkMaterials.entrySet().stream().
                        sorted(Comparator.comparing(Map.Entry::getKey)).
                        forEach(jM -> System.out.println(jM.getKey() + ": " + jM.getValue()));
                break;
            }else if(keyMaterials.get("motes")>=250){
                keyMaterials.put("motes",keyMaterials.get("motes")-250);
                System.out.println("Dragonwrath obtained!");
                keyMaterials.entrySet().stream().
                        sorted((a, b) ->{
                            int index = b.getValue().compareTo(a.getValue());
                            if (index == 0){
                                index = a.getKey().compareTo(b.getKey());
                            }
                            return index;
                        }).
                        forEach(kM-> System.out.println(kM.getKey()+": "+kM.getValue()));
                junkMaterials.entrySet().stream().
                        sorted(Comparator.comparing(Map.Entry::getKey)).
                        forEach(jM-> System.out.println(jM.getKey()+": "+jM.getValue()));
                break;
            }else if(keyMaterials.get("fragments")>=250){
                keyMaterials.put("fragments",keyMaterials.get("fragments")-250);
                System.out.println("Valanyr obtained!");
                keyMaterials.entrySet().stream().
                        sorted((a, b) ->{
                            int index = b.getValue().compareTo(a.getValue());
                            if (index == 0){
                                index = a.getKey().compareTo(b.getKey());
                            }
                            return index;
                        }).
                        forEach(kM-> System.out.println(kM.getKey()+": "+kM.getValue()));
                junkMaterials.entrySet().stream().
                        sorted(Comparator.comparing(Map.Entry::getKey)).
                        forEach(jM-> System.out.println(jM.getKey()+": "+jM.getValue()));
                break;
            }

        }

    }
}
