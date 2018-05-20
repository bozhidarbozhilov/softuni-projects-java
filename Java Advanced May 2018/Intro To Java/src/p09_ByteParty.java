import java.util.Scanner;

public class p09_ByteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCnt = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[numberCnt];
        for (int i = 0; i < numberCnt; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        while(true){
            String input = scanner.nextLine();
            if(!input.equals("party over")){
                String command = input.split("\\s+")[0];
                int position = Integer.parseInt(input.split("\\s+")[1]);

                switch (command){
                    case "-1":
                        int mask = 1<<position;
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] ^= mask;
                        }

                        break;
                    case "1":
                        mask = 1<<position;
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] = numbers[i] | mask;
                        }
                        break;
                    case "0":
                        mask = ~(1<<position);
                        for (int i = 0; i < numbers.length; i++) {
                            numbers[i] = numbers[i] & mask;
                        }
                        break;
                    default:
                        break;
                }
            }else{
                for (int number : numbers) {
                    System.out.println(number);

                }
                break;
            }
        }
    }
}
