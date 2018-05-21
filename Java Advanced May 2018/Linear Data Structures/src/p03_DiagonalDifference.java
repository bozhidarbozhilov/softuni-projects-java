import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixRows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixRows][];
        for (int i = 0; i < matrixRows; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = new int[currentRow.length];
            System.arraycopy(currentRow, 0, matrix[i], 0, currentRow.length);
        }
        int primaryDiagonalSum = 0;
        for (int row = 0; row < matrixRows; row++) {
            primaryDiagonalSum += matrix[row][row];
        }
        int secondaryDiagonalSum = 0;
        for (int row = 0; row < matrixRows ; row++) {
            secondaryDiagonalSum += matrix[row][matrixRows-1-row];
        }
        int diagonalDifference = Math.abs(primaryDiagonalSum-secondaryDiagonalSum);

        System.out.println(diagonalDifference);
    }
}
