import java.util.Scanner;

public class p05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSizes = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixSizes[0]);
        int cols = Integer.parseInt(matrixSizes[1]);
        String[][] matrix = new String[rows][cols];

        for (String[] strings : matrix) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            System.arraycopy(currentRow,0,strings,0, cols);
        }

        String line = "";
        while(!"END".equals(line = scanner.nextLine())){
            try{
                String[] tokens = line.split("\\s+");
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;
                for (String[] strings : matrix) {
                    for (String string : strings) {
                        System.out.print(string + " ");
                    }
                    System.out.println();
                }
            }catch(Exception e){
                System.out.println("Invalid input!");
            }
        }
    }
}
