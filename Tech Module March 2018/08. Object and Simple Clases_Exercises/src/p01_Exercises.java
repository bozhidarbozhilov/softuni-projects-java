import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_Exercises {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        ArrayList<Exercise> exercises = new ArrayList<>();

        while(!inputStr.equals("go go go")){
            exercises.add(Exercise.parseExercise(inputStr));
            inputStr = scanner.nextLine();
        }


        exercises.stream()
                .forEach(e->{
                    System.out.println("Exercises: "+e.getTopic());
                    System.out.println("Problems for exercises and homework for the \""+e.getCourseName()+"\" course @ SoftUni.");
                    System.out.println("Check your solutions here: "+e.getLink());
                    int[] numbering = {1};
                    e.getProblems().stream()
                            .forEach(p->{
                                System.out.printf("%d. %s%n", numbering[0],p);
                                numbering[0]++;
                            });
                });

    }
}
class Exercise{
    private String topic;
    private String courseName;
    private String judgeContestLink;
    private ArrayList<String> problems;

    public Exercise(String topicIn,String courseNameIn,String judgeContestLinkIn, ArrayList<String> problemsIn){
        this.topic = topicIn;
        this.courseName = courseNameIn;
        this.judgeContestLink = judgeContestLinkIn;
        this.problems = problemsIn;
    }

    public static Exercise parseExercise(String inputStr){
        String[] inputTokens = inputStr.split(" -> ");
        String topicIn = inputTokens[0];
        String courseName = inputTokens[1];
        String link = inputTokens[2];
        ArrayList<String> problemsIn = Arrays.stream(inputTokens[3].split(", "))
                .collect(Collectors.toCollection(ArrayList::new));

        return new Exercise(topicIn,courseName,link,problemsIn);
    }

    public String getTopic(){return topic;}
    public String getCourseName(){return courseName;}
    public String getLink(){return judgeContestLink;}
    public ArrayList<String> getProblems(){return problems;}

}
