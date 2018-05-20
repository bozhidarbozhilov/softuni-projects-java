import java.util.Scanner;

public class p01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int matrixSize = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[matrixSize][matrixSize];

        if("A".equals(pattern)){
            fillPatternA(matrix);
        }else if("B".equals(pattern)){
            fillPatternB(matrix);
        }

        printMatrix(matrix);
        String debug = "";
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }

    private static void fillPatternB(int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row =matrix.length-1; row >=0; row--) {
                if(col%2 != 0){
                    matrix[row][col] += (col*matrix.length)+(matrix.length-row);
                }else{
                    matrix[row][col] += (col*matrix.length)+row+1;
                }

            }
        }
    }

    private static void fillPatternA(int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] += (col*matrix.length)+row+1;
            }
        }
    }
}
