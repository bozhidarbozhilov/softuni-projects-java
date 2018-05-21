import java.util.ArrayList;
import java.util.Scanner;

public class p06_StringMatrixRotation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] rotationInput = scanner.nextLine().split("[\\(\\)]");
        int rotationDegrees = Integer.parseInt(rotationInput[1]);
        int rotationCount = rotationDegrees/90;
        ArrayList<String> words = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;

        while(true){
            String word = scanner.nextLine();
            if("END".equals(word)){
                break;
            }else{
                if(word.length()>maxLength){
                    maxLength = word.length();
                }
                words.add(word);
            }
        }
        char[][] matrix = new char[words.size()][maxLength];
        fillMatrix(words, matrix, maxLength);
        for (int i = 0; i < rotationCount; i++) {
            matrix = rotateMatrix(matrix, matrix[0].length);
        }
        printMatrix(matrix);
    }

    private static char[][] rotateMatrix(char[][] matrix, int length) {
        char[][] temp = new char[length][matrix.length];
        for (int row = 0; row < length ; row++) {
            for(int col = 0; col < matrix.length; col++){
                temp[row][col] = matrix[matrix.length-1-col][row];
            }
        }
        return temp;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(ArrayList<String> words, char[][] matrix, int maxLength) {
        for (int i = 0; i < words.size(); i++) {
            String padded = String.format("%-"+maxLength+"s", words.get(i));
            char[] currentWord = padded.toCharArray();
            System.arraycopy(currentWord,0, matrix[i],0, currentWord.length);
        }
    }

}
