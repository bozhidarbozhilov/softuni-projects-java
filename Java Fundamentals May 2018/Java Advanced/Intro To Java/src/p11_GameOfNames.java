import java.util.Scanner;

public class p11_GameOfNames {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int cnt = Integer.parseInt(scanner.nextLine());

        long initialPoints = 0L;
        long maxPoints = Long.MIN_VALUE;
        String name = "";
        String winner = "";

        for (int i = 1; i <= 2*cnt; i++) {
            if(i%2!=0){
                name = scanner.nextLine();
            }else{
                initialPoints = Long.parseLong(scanner.nextLine());
            }
            if(!name.isEmpty() && i%2==0){
                long totalPoints = calcPoints(name, initialPoints);
                if(totalPoints>maxPoints){
                    maxPoints = totalPoints;
                    winner = name;
                }
            }

        }
        System.out.printf("The winner is %s - %d points", winner, maxPoints);
    }

    private static long calcPoints(String name, long initPoints) {
        long sum = initPoints;
        for (int i = 0; i < name.length(); i++) {
            int asciiCode = name.charAt(i);
            if(asciiCode%2==0){
                sum += asciiCode;
            }else{
                sum -= asciiCode;
            }
        }
        return sum;
    }
}
