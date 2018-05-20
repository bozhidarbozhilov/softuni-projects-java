import java.util.Arrays;
import java.util.Scanner;

public class p13_BlurFilter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        long blurAmount = Long.parseLong(scanner.nextLine());
        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixSize[0];
        int cols = matrixSize[1];
        long[][] theMatrix = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            long[] currentRowNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToLong(Long::parseLong).toArray();
            System.arraycopy(currentRowNumbers, 0, theMatrix[i], 0, cols);
        }
        int[] blurCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int blurRow = blurCoordinates[0];
        int blurCol = blurCoordinates[1];

        int startRow = blurRow - 1 < 0 ? blurRow : blurRow -1;
        int endRow = blurRow + 1 >= rows ? blurRow : blurRow + 1;
        int startCol = blurCol - 1 < 0 ? blurCol : blurCol-1;
        int endCol = blurCol + 1 >= cols ? blurCol : blurCol + 1;

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                theMatrix[i][j] += blurAmount;
            }
        }

        for (long[] matrix : theMatrix) {
            for (long l : matrix) {
                System.out.print(l+" ");
            }
            System.out.println();
        }
    }

}
