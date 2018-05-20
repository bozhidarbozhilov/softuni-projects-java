import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p05_CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split("\\s+");
        String[] secondArr = scanner.nextLine().split("\\s+");
        boolean isFirst = false;
        boolean isSecond = false;

        if(firstArr.length>secondArr.length){
            isSecond = true;
        }else if(firstArr.length==secondArr.length){
            for (int cnt = 0; cnt < firstArr.length; cnt++) {
                if(firstArr[cnt].charAt(0)>secondArr[cnt].charAt(0)){
                    isSecond = true;
                    break;
                }else{
                    isFirst = true;
                    break;
                }
            }
        }else{
            isFirst = true;
        }
        if(isFirst){
            System.out.println(Arrays.stream(firstArr).collect(Collectors.joining("")));
            System.out.println(Arrays.stream(secondArr).collect(Collectors.joining("")));
        }else if(isSecond){
            System.out.println(Arrays.stream(secondArr).collect(Collectors.joining("")));
            System.out.println(Arrays.stream(firstArr).collect(Collectors.joining("")));
        }

    }
}
