import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p15_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\b([a-zA-Z][\\w]{2,24})\\b");
        Matcher matcher = pattern.matcher(input);
        ArrayDeque<String> userNames = new ArrayDeque<>();

        while(matcher.find()){
            userNames.offer(matcher.group());
        }

        int maxSum = Integer.MIN_VALUE;
        String firstBest = "";
        String secondBest = "";
        String firstString = userNames.poll();
        while(userNames.size()>0){
            String secondString = userNames.poll();

            int sum = firstString.length() + secondString.length();
            if(sum > maxSum){
                maxSum = sum;
                firstBest = firstString;
                secondBest = secondString;
            }
            firstString = secondString;
        }
        System.out.println(firstBest);
        System.out.println(secondBest);
    }
}
