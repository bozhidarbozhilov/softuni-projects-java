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
            for (int col = 0; col < cols; col++) {
                theMatrix[i][col] = currentRowNumbers[col];
            }
        }
        int[] blurCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int blurRow = blurCoordinates[0];
        int blurCol = blurCoordinates[1];


        if(rows==1 || cols==1){
            if(rows==1 && cols==1){
                theMatrix[blurRow][blurCol] += blurAmount;
            }else if(rows==1){
                if(blurCol == cols -1){
                    theMatrix[0][blurCol-1]+=blurAmount;
                    theMatrix[0][blurCol]+=blurAmount;
                }else{
                    theMatrix[0][blurCol-1]+=blurAmount;
                    theMatrix[0][blurCol]+=blurAmount;
                    theMatrix[0][blurCol+1]+=blurAmount;
                }
            }else {
                if(blurRow == rows - 1){
                    theMatrix[blurRow-1][blurCol] += blurAmount;
                    theMatrix[blurRow][blurCol] += blurAmount;
                }else{
                    theMatrix[blurRow-1][blurCol] += blurAmount;
                    theMatrix[blurRow][blurCol] += blurAmount;
                    theMatrix[blurRow+1][blurCol] += blurAmount;
                }
            }
        }else if(blurRow==0 || blurCol==0 || blurCol == cols-1 || blurRow == rows-1){
            if(blurCol==0 && blurRow==0){
                theMatrix[blurRow][blurCol] += blurAmount;
                theMatrix[blurRow][blurCol+1] += blurAmount;
                theMatrix[blurRow+1][blurCol] += blurAmount;
                theMatrix[blurRow+1][blurCol+1] += blurAmount;

            }else if(blurRow==0 && blurCol == cols-1){
                theMatrix[blurRow][blurCol-1] +=blurAmount;
                theMatrix[blurRow][blurCol] +=blurAmount;
                theMatrix[blurRow+1][blurCol-1] +=blurAmount;
                theMatrix[blurRow+1][blurCol] +=blurAmount;

            }else if(blurRow == rows-1 && blurCol == 0){
                theMatrix[blurRow-1][blurCol] +=blurAmount;
                theMatrix[blurRow-1][blurCol+1] +=blurAmount;
                theMatrix[blurRow][blurCol] +=blurAmount;
                theMatrix[blurRow][blurCol+1] +=blurAmount;

            }else if(blurRow == rows-1 && blurCol == cols-1){
                theMatrix[blurRow-1][blurCol] += blurAmount;
                theMatrix[blurRow-1][blurCol-1] += blurAmount;
                theMatrix[blurRow][blurCol] += blurAmount;
                theMatrix[blurRow][blurCol-1] += blurAmount;

            }else if(blurRow==0){
                theMatrix[blurRow][blurCol-1] += blurAmount;
                theMatrix[blurRow][blurCol] += blurAmount;
                theMatrix[blurRow][blurCol+1] += blurAmount;
                theMatrix[blurRow+1][blurCol-1] += blurAmount;
                theMatrix[blurRow+1][blurCol] += blurAmount;
                theMatrix[blurRow+1][blurCol+1] += blurAmount;

            }else if(blurCol==0){
                theMatrix[blurRow-1][blurCol] += blurAmount;
                theMatrix[blurRow-1][blurCol+1] += blurAmount;
                theMatrix[blurRow][blurCol] += blurAmount;
                theMatrix[blurRow][blurCol+1] += blurAmount;
                theMatrix[blurRow+1][blurCol] += blurAmount;
                theMatrix[blurRow+1][blurCol+1] += blurAmount;
            }else if(blurRow == rows-1){
                theMatrix[blurRow-1][blurCol-1] += blurAmount;
                theMatrix[blurRow-1][blurCol] += blurAmount;
                theMatrix[blurRow-1][blurCol+1] += blurAmount;
                theMatrix[blurRow][blurCol-1] += blurAmount;
                theMatrix[blurRow][blurCol] += blurAmount;
                theMatrix[blurRow][blurCol+1] += blurAmount;
            }else if(blurCol == cols-1){
                theMatrix[blurRow-1][blurCol-1] += blurAmount;
                theMatrix[blurRow-1][blurCol] += blurAmount;
                theMatrix[blurRow][blurCol-1] += blurAmount;
                theMatrix[blurRow][blurCol] += blurAmount;
                theMatrix[blurRow+1][blurCol-1] += blurAmount;
                theMatrix[blurRow+1][blurCol] += blurAmount;
            }
        }else{
            theMatrix[blurRow-1][blurCol-1] +=blurAmount;
            theMatrix[blurRow-1][blurCol] +=blurAmount;
            theMatrix[blurRow-1][blurCol+1] +=blurAmount;
            theMatrix[blurRow][blurCol-1] +=blurAmount;
            theMatrix[blurRow][blurCol] +=blurAmount;
            theMatrix[blurRow][blurCol+1] +=blurAmount;
            theMatrix[blurRow+1][blurCol-1] +=blurAmount;
            theMatrix[blurRow+1][blurCol] +=blurAmount;
            theMatrix[blurRow+1][blurCol+1] +=blurAmount;
        }
        for (long[] matrix : theMatrix) {
            for (long l : matrix) {
                System.out.print(l+" ");
            }
            System.out.println();
        }
    }

}
