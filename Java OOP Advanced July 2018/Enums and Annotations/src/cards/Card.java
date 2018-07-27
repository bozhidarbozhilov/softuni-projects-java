package cards;

public class Card implements Comparable<Card>{
    private CardSuit cardSuit;
    private CardRank cardRank;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public CardSuit getCardSuit() {
        return this.cardSuit;
    }

    public CardRank getCardRank(){
        return this.cardRank;
    }

    public int getCardPower(){
        return this.getCardRank().getRankPower() + this.getCardSuit().getSuitPower();
    }

    @Override
    public String toString() {
        return String.format("%s of %s",
                this.getCardRank(), this.getCardSuit());
    }

    @Override
    public int compareTo(Card o) {
        return this.getCardPower() - o.getCardPower();
    }

    public boolean isEqualCards(Card card) {

        return this.getCardPower() == card.getCardPower();
    }
}
