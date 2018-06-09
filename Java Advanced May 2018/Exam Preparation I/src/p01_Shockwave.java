import java.util.Arrays;
import java.util.Scanner;

public class p01_Shockwave {
    public static int[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = sizes[0];
        int cols = sizes[1];
        matrix = new int[rows][cols];

        fillMatrix(rows, cols);

        String input = scanner.nextLine();
        while(!"Here We Go".equals(input)){
            int[] coordinates = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int x1 = coordinates[0];
            int y1 = coordinates[1];
            int x2 = coordinates[2];
            int y2 = coordinates[3];

            hitThePlates(x1, y1, x2, y2);
            input = scanner.nextLine();
        }
        printMatrix();
    }

    private static void printMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    private static void hitThePlates(int x1, int y1, int x2, int y2) {
        for (int row = x1; row <=x2 ; row++) {
            for (int col = y1; col <= y2; col++) {
                matrix[row][col]++;
            }
        }
    }

    private static void fillMatrix(int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = 0;
            }
        }
    }

}
