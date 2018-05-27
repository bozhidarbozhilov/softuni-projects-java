import java.util.*;

public class p08_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playersCards = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while(!"JOKER".equals(input)){
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            playersCards.putIfAbsent(name, new LinkedHashSet<>());
            Collections.addAll(playersCards.get(name),cards);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : playersCards.entrySet()) {
            int cardsSum = calcCards(entry.getValue());
            System.out.printf("%s: %d%n", entry.getKey(), cardsSum);
        }
    }

    private static int calcCards(Set<String> cards) {
        int sum = 0;
        int power = 0;
        int type = 0;
        for (String card : cards) {
            power = getPowerValue(card.charAt(0));
            if(card.length()==2){
                type = getTypeValue(card.charAt(1));
            }else{
                type = getTypeValue(card.charAt(2));
            }

            sum += power * type;
        }
        return sum;
    }

    private static int getTypeValue(char type) {
        switch (type){
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
            default:
                return 0;
        }
    }

    private static int getPowerValue(char power) {
        switch(power){
            case '1':
                return 10;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
            default:
                return 0;
        }
    }
}
