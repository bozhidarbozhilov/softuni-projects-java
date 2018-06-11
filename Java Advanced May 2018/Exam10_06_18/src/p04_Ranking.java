import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class p04_Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> contests = new LinkedHashMap<>();

        String line = reader.readLine();

        while(!"end of contests".equals(line)){
            String[] tokens = line.split("[:>=\\-]+");
            String contest = tokens[0];
            String password = tokens[1];
            contests.put(contest, password);
            line = reader.readLine();
        }
        Map<String, Map<String, Integer>> students = new LinkedHashMap<>();

        Map<String, Integer> sumPoints = new LinkedHashMap<>();

        line = reader.readLine();
        while(!"end of submissions".equals(line)){
            String[] tokens = line.split("=>");

            String contest = tokens[0];
            String password = tokens[1];
            String studentName = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if(contests.containsKey(contest) && contests.get(contest).equals(password)){
                students.putIfAbsent(studentName, new LinkedHashMap<>());
                students.get(studentName).putIfAbsent(contest,0);
                sumPoints.putIfAbsent(studentName, 0);
                if(students.get(studentName).get(contest) < points){
                    students.get(studentName).put(contest, points);
                    sumPoints.put(studentName, sumPoints.get(studentName) + points);
                }
            }
            line = reader.readLine();
        }


        students.entrySet().stream()
                .sorted((s1,s2)->s2.getValue().values().stream().reduce((x, y)->x+y).get().
                        compareTo(s1.getValue().values().stream().reduce((x, y)->x+y).get()))
                .limit(1)
                .forEach(s-> System.out.printf("Best candidate is %s with total %d points.%n",
                        s.getKey(), s.getValue().values().stream().reduce((x, y)->x+y).get()));
        ;
/*        sumPoints.entrySet().stream()
                .sorted((u1, u2)-> u2.getValue().compareTo(u1.getValue()))
                .limit(1)
                .forEach(s-> System.out.printf("Best candidate is %s with total %d points.%n", s.getKey(), s.getValue()));*/

        System.out.println("Ranking:");
        students.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(u->{
                    System.out.println(u.getKey());
                    students.get(u.getKey()).entrySet().stream()
                    .sorted((p1,p2)->p2.getValue().compareTo(p1.getValue()))
                    .forEach(e-> System.out.printf("#  %s -> %d%n", e.getKey(),e.getValue()));
                });
    }
}
