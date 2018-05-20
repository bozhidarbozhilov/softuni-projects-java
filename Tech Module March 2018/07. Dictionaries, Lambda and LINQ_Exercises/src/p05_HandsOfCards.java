import java.util.*;

public class p05_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String,ArrayList<String>> playersCards = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> playersPoints = new LinkedHashMap<>();

        String[] inputStr = scanner.nextLine().split(": ");


        while(!inputStr[0].equals("JOKER")){
            String player = inputStr[0];
            String[] cards = inputStr[1].split(", ");
            playersCards.putIfAbsent(player,new ArrayList<>());
            Arrays.stream(cards).forEach(c->{
                if(!playersCards.get(player).contains(c)){
                    playersCards.get(player).add(c);
                }
            });


            inputStr = scanner.nextLine().split(": ");
        }
        for (Map.Entry<String, ArrayList<String>> cards : playersCards.entrySet()) {
            int sumCards = calcHand(playersCards.get(cards.getKey()));
            playersPoints.putIfAbsent(cards.getKey(),0);
            playersPoints.put(cards.getKey(),playersPoints.get(cards.getKey())+sumCards);
        }


        playersPoints.entrySet().stream().forEach(p-> System.out.println(p.getKey()+": "+p.getValue()));
    }

    private static int calcHand(ArrayList<String> cards) {
        int sum = 0;
        int type = 0;
        int power = 0;

        for (String card : cards) {
            char cardType = card.charAt(card.length()-1);
            String cardPower = card.substring(0,card.length()-1);

            switch(cardPower){
                case "2":
                    power = 2;
                    break;
                case "3":
                    power = 3;
                    break;
                case "4":
                    power = 4;
                    break;
                case "5":
                    power = 5;
                    break;
                case "6":
                    power = 6;
                    break;
                case "7":
                    power = 7;
                    break;
                case "8":
                    power = 8;
                    break;
                case "9":
                    power = 9;
                    break;
                case "10":
                    power = 10;
                    break;
                case "J":
                    power = 11;
                    break;
                case "Q":
                    power = 12;
                    break;
                case "K":
                    power = 13;
                    break;
                case "A":
                    power = 14;
                    break;
                default:
                    break;
            }
            switch(cardType){
                case 'S':
                    type = 4;
                    break;
                case 'H':
                    type = 3;
                    break;
                case 'D':
                    type = 2;
                    break;
                case 'C':
                    type = 1;
                    break;
                default:
                    break;
            }
            sum+=type*power;
        }
        return sum;
    }
}
