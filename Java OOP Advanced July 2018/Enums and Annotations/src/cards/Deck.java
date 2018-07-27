package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }


    public void addCard(CardRank rank, CardSuit cardSuit){
        this.cards.add(new Card(rank, cardSuit));
    }

    public void removeCard(Card card){
        this.cards.removeIf(card1 -> card1.isEqualCards(card));
    }

    public boolean isCardInDeck(Card card){
        for (Card card1 : cards) {
            if(card1.isEqualCards(card)){
                return true;
            }
        }
        return false;
    }

    public Iterable<Card> cards(){
        return Collections.unmodifiableList(this.cards);

    }

    public void loadDeck(){
        Class suitClass = CardSuit.class;
        Class rankClass = CardRank.class;

        Object[] suits = suitClass.getEnumConstants();
        Object[] ranks = rankClass.getEnumConstants();

        for (Object suit : suits) {
            for (Object rank : ranks) {
                this.cards.add(new Card((CardRank) rank, (CardSuit) suit));
            }
        }
    }

}
