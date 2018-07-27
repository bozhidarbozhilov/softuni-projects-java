package cards;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String category = scanner.nextLine();

/*        if("Rank".equals(category)){
            CardAnnotation cardAnnotation = CardRank.class.getAnnotation(CardAnnotation.class);
            System.out.printf("Type = %s, Description = %s", cardAnnotation.type(), cardAnnotation.description());
        }else if("Suit".equals(category)){
            CardAnnotation suitAnnotation = CardSuit.class.getAnnotation(CardAnnotation.class);
            System.out.printf("Type = %s, Description = %s", suitAnnotation.type(), suitAnnotation.description());
        }*/
/*        String input = scanner.nextLine();
        if("Card Deck".equals(input)){
            Class suitClass = CardSuit.class;
            Class rankClass = CardRank.class;

            Object[] suits = suitClass.getEnumConstants();
            Object[] ranks = rankClass.getEnumConstants();

            for (int i = 0; i < suits.length; i++) {
                for (int j = 0; j < ranks.length; j++) {
                    System.out.printf("%s of %s%n", ranks[j], suits[i]);
                }

            }
        }*/

        Deck deck = new Deck();

        deck.loadDeck();

        String firstPlayer = scanner.nextLine();
        String secondPlayer = scanner.nextLine();

        List<Card> firstPlayerCards = new ArrayList<>();
        List<Card> secondPlayerCards = new ArrayList<>();


        while(true) {
            String input = scanner.nextLine();
            if(input.matches("^[A-Z]+ of [A-Z]+$")){
                try{
                    String[] tokens = input.split("\\s+");
                    CardRank rank = CardRank.valueOf(tokens[0]);
                    CardSuit suit = CardSuit.valueOf(tokens[2]);
                    Card card = new Card(rank, suit);
                    if(deck.isCardInDeck(card)){
                        if(firstPlayerCards.size()< 5){
                            firstPlayerCards.add(card);
                            deck.removeCard(card);
                        }else if(secondPlayerCards.size() < 5 && firstPlayerCards.size() == 5){
                            secondPlayerCards.add(card);
                            deck.removeCard(card);
                            if(secondPlayerCards.size() == 5){
                                break;
                            }
                        }
                    }else {
                        System.out.println("Card is not in the deck.");
                    }
                }catch (Exception e){
                    System.out.println("No such card exists.");
                }

            }else{
                System.out.println("No such card exists.");
            }
        }
        Card firstPlayerMaxCard = firstPlayerCards.stream().max(Comparator.comparingInt(Card::getCardPower)).get();
        Card secondPlayerMaxCard = secondPlayerCards.stream().max(Comparator.comparingInt(Card::getCardPower)).get();

        if(firstPlayerMaxCard.compareTo(secondPlayerMaxCard)>0){
            System.out.printf("%s wins with %s.%n", firstPlayer, firstPlayerMaxCard.toString());
        }else{
            System.out.printf("%s wins with %s.%n", secondPlayer, secondPlayerMaxCard.toString());
        }
    }
}
