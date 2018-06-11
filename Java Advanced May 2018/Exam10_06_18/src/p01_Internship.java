import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p01_Internship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int problemsCount = Integer.parseInt(scanner.nextLine());
        int candidatesCount = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> problems = new ArrayDeque<>();
        ArrayDeque<String> candidates = new ArrayDeque<>();

        for (int i = 0; i < problemsCount; i++) {
            problems.push(scanner.nextLine());
        }
        for (int i = 0; i < candidatesCount; i++) {
            String candidate = scanner.nextLine();
            if(isValidName(candidate)){
                candidates.offer(candidate);
            }
        }
        while(candidates.size() != 1 && !problems.isEmpty()){
            String currentCandidate = candidates.poll();
            String currentProblem = problems.pop();

            int candidateASCII = calcASCII(currentCandidate);
            int problemASCII = calcASCII(currentProblem);
            if(candidateASCII > problemASCII){
                System.out.printf("%s solved %s.%n", currentCandidate, currentProblem);
                candidates.offer(currentCandidate);
            }else{
                System.out.printf("%s failed %s.%n", currentCandidate, currentProblem);
                problems.offerLast(currentProblem);
            }

        }
        if(candidates.size()==1){
            System.out.printf("%s gets the job!", candidates.poll());
        }else if(problems.isEmpty()){
            System.out.println(candidates.toString().replaceAll("[\\[\\]]",""));
        }
    }

    private static int calcASCII(String string) {
        char[] symbols = string.toCharArray();
        int sum = 0;
        for (int i = 0; i < symbols.length; i++) {
            if(symbols[i] != ' '){
                sum += (int) symbols[i];
            }
        }
        return sum;
    }

    private static boolean isValidName(String candidate) {
        Pattern name = Pattern.compile("[A-Z][a-z]+\\s[A-Z][a-z]+");
        Matcher matcher = name.matcher(candidate);
        return matcher.matches();
    }
}
