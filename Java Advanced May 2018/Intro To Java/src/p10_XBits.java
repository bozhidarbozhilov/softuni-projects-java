import java.util.Scanner;

public class p10_XBits {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        char[][] binNumbers = new char[8][32];
        int counter = 0;

        for (int i = 0; i < 8; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            String temp = Integer.toBinaryString(num);
            String binString = String.format("%32s",temp).replace(" ", "0");
            for (int j = 0; j < binString.length(); j++) {
                binNumbers[i][j] = binString.charAt(j);
            }
        }
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < binNumbers[row].length-2; col++) {
                if (binNumbers[row][col] == '1' && binNumbers[row][col+1]=='0' && binNumbers[row][col+2]=='1' &&
                    binNumbers[row+1][col] == '0' && binNumbers[row+1][col+1]=='1' && binNumbers[row+1][col+2]=='0' &&
                    binNumbers[row+2][col] == '1' && binNumbers[row+2][col+1]=='0'&& binNumbers[row+2][col+2]=='1') {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
