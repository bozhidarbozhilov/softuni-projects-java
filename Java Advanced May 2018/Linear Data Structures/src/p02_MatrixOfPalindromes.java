import java.util.Scanner;

public class p02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        String[][] result = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.printf("%c%c%c ",'a'+row, 'a'+row+col, 'a'+row);
            }
            System.out.println();
        }
    }

}
