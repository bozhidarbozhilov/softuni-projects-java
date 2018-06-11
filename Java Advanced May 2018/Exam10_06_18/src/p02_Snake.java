import java.util.*;

public class p02_Snake {
    public static String[][] matrix;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int screenSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        ArrayDeque<String> commandsQueue = new ArrayDeque<>();

        for (String command : commands) {
            commandsQueue.offer(command);
        }
        int snakeLength = 1;

        matrix = new String[screenSize][screenSize];
        for (int row = 0; row < screenSize; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int col = 0; col < screenSize; col++) {
                matrix[row][col] = currentRow[col];
            }
        }

        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col].equals("s")){
                    startRow = row;
                    startCol = col;
                }
            }
        }
        int foodCount = countFood();
        while(true){

            if(commandsQueue.isEmpty()){
                System.out.println("You lose! There is still "+foodCount+" food to be eaten.");
                return;
            }
            String currentCommand = commandsQueue.poll();

            switch (currentCommand){
                case "up":
                    if(hitUp(startRow-1)){
                        startRow = matrix.length-1;
                    }else{
                        startRow = startRow - 1;
                    }
                    break;
                case "down":
                    if(hitBottom(startRow+1)) {
                        startRow = 0;
                    }else{
                        startRow = startRow + 1;
                    }
                    break;
                case "left":
                    if(hitLeft(startCol-1)){
                        startCol = matrix.length-1;
                    }else{
                        startCol = startCol - 1;
                    }
                    break;
                case "right":
                    if(hitRight(startCol + 1 )){
                        startCol = 0;
                    }else{
                        startCol = startCol + 1;
                    }
                    break;
                default:
                    break;
            }
            if(matrix[startRow][startCol].equals("f")){
                matrix[startRow][startCol] = "*";
                foodCount--;
                snakeLength++;
            }
            if(matrix[startRow][startCol].equals("e")){
                System.out.println("You lose! Killed by an enemy!");
                break;
            }else if(foodCount==0){
                System.out.println("You win! Final snake length is "+snakeLength);
                break;
            }
        }
        System.out.println();
    }

    private static int countFood() {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col].equals("f")){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean hitRight(int i) {
        return i > matrix.length-1;
    }

    private static boolean hitLeft(int i) {
        return i < 0;
    }

    private static boolean hitUp(int i) {
        return i < 0;
    }

    private static boolean hitBottom(int num) {
        return num > matrix.length-1;
    }
}
