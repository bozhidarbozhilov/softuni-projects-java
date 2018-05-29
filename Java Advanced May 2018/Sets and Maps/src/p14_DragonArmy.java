import java.util.*;

public class p14_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dragonsCount = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, int[]>> dragons = new LinkedHashMap<>();
        Map<String, double[]> averageStats = new LinkedHashMap<>();

        for (int i = 0; i < dragonsCount; i++) {
            int damage = 45;
            int health = 250;
            int armor = 10;
            String[] tokens = scanner.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            if(!"null".equals(tokens[2])){
                damage = Integer.parseInt(tokens[2]);
            }
            if(!"null".equals(tokens[3])){
                health = Integer.parseInt(tokens[3]);
            }
            if(!"null".equals(tokens[4])){
                armor = Integer.parseInt(tokens[4]);
            }

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).putIfAbsent(name, new int[3]);

            dragons.get(type).get(name)[0] = damage;
            dragons.get(type).get(name)[1] = health;
            dragons.get(type).get(name)[2] = armor;

            averageStats.putIfAbsent(type, new double[3]);

        }
        for (Map.Entry<String, Map<String, int[]>> dragon : dragons.entrySet()) {
            String currentDragon = dragon.getKey();
            double averageDamage = dragons.get(currentDragon).values().stream()
                    .mapToDouble(p->p[0]).average().getAsDouble();
            double averageHealth = dragons.get(currentDragon).values().stream()
                    .mapToDouble(p->p[1]).average().getAsDouble();
            double averageArmor = dragons.get(currentDragon).values().stream()
                    .mapToDouble(p->p[2]).average().getAsDouble();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", currentDragon, averageDamage, averageHealth,averageArmor);
            dragons.get(currentDragon).entrySet().forEach(d->
                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                            d.getKey(),d.getValue()[0],d.getValue()[1],d.getValue()[2]));
        }
    }

}
