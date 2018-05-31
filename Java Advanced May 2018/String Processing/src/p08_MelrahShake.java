import java.util.Scanner;

public class p08_MelrahShake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        StringBuilder pattern = new StringBuilder(scanner.nextLine());

        while(true){
            boolean firstRemoved = false;
            boolean secondRemoved = false;
            int firstOccurence = text.indexOf(pattern.toString());
            if(firstOccurence!=-1){
                text.delete(firstOccurence, firstOccurence+pattern.length());
                firstRemoved = true;
            }
            int lastOccurence = text.lastIndexOf(pattern.toString());
            if(lastOccurence!=-1){
                text.delete(lastOccurence, lastOccurence+pattern.length());
                secondRemoved = true;
            }
            if(firstRemoved && secondRemoved && !pattern.toString().isEmpty()){
                System.out.println("Shaked it.");
                pattern.deleteCharAt(pattern.length()/2);
            }else{
                System.out.println("No shake.");
                break;
            }

        }
        System.out.println(text.toString());

    }
}
