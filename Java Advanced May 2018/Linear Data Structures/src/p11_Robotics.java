import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class p11_Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputRobots = scanner.nextLine().split(";");
        String[] robots = new String[inputRobots.length];
        int[] processingTime = new int[inputRobots.length];
        int[] workingRobot = new int[inputRobots.length];
        for (int i = 0; i < inputRobots.length; i++) {
            String[] tokens = inputRobots[i].split("-");
            robots[i] = tokens[0];
            processingTime[i] = Integer.parseInt(tokens[1]);
        }

        String[] startTime = scanner.nextLine().split(":");
        long hours = Integer.parseInt(startTime[0])*60*60;
        long minutes = Integer.parseInt(startTime[1])*60;
        long seconds = Integer.parseInt(startTime[2]);
        long totalTime = hours + minutes + seconds;

        ArrayDeque<String> productLine = new ArrayDeque<>();
        String productIn = scanner.nextLine();
        while(!"End".equals(productIn)){
            productLine.offer(productIn);
            productIn = scanner.nextLine();
        }


        while(!productLine.isEmpty()){
            totalTime++;
            for (int i = 0; i < workingRobot.length; i++) {
                if(workingRobot[i]>0){
                    workingRobot[i]--;
                }
            }
            String currentProduct = productLine.poll();
            boolean isProductTaken = false;
            for (int i = 0; i < robots.length; i++) {
                if(workingRobot[i] == 0){
                    workingRobot[i] = processingTime[i];
                    isProductTaken = true;
                    System.out.printf("%s - %s [%s]%n", robots[i], currentProduct, formatTime(totalTime));
                    break;
                }
            }
            if(!isProductTaken){
                productLine.offer(currentProduct);

            }
        }
    }

    private static String formatTime(long totalTime) {
        long hours = (totalTime / 3600)%24;
        long minutes = (totalTime/60)%60;
        long seconds = totalTime%60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}