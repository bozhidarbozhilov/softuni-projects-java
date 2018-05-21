import java.util.Arrays;
import java.util.Scanner;

public class p04_MaximalSum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] matrixSizes = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixSizes[0]);
        int cols = Integer.parseInt(matrixSizes[1]);
        int[][] matrix = new int[rows][cols];

        for (int[] ints : matrix) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            System.arraycopy(currentRow, 0, ints, 0, cols);
        }

        int maxSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col+1] + matrix[row][col+2] +
                                matrix[row+1][col] + matrix[row+1][col+1] + matrix[row+1][col+2] +
                                matrix[row+2][col] + matrix[row+2][col+1] + matrix[row+2][col+2];
                if(currentSum>maxSum){
                    maxSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.printf("Sum = %d%n", maxSum);

        for (int row = bestRow; row < bestRow+3; row++) {
            for (int col = bestCol; col < bestCol+3; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
        String debug = "";
    }
}
