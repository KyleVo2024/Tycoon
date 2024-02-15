import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

class Deck {
    private List<Card> cards;
    private List<Card> shuffledDeck;

    /**
     * Deck constructor: Create an empty deck of cards
     */
    public Deck() {
        cards = new ArrayList<Card>();
    }

    public void initializeNewDeck() {
        String[] suits = { "Hearts", "Clubs", "Spades", "Diamonds" };
        int[] ranks = { 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        String[] faces = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        for (String suit : suits) {
            for (int idx = 0; idx < ranks.length; idx++) {
                Card c = new Card(ranks[idx], faces[idx], suit);
                this.cards.add(c);
            }
        }
    }

    /**
     * Get the number of cards in the deck
     * 
     * @returns Number of cards in the deck
     */
    public int getDeckSize() {
        return cards.size();
    }

    /**
     * Shuffles the cards in the deck
     */
    public void shuffle() {
        shuffledDeck = new ArrayList<Card>();
        int s = cards.size();
        int i = 0;
        while (i < s) {
            int r = (int) (Math.random() * s) + 1;
            shuffledDeck.add(cards.get(r - 1));
            cards.remove(r - 1);
            s--;
        }
        cards = shuffledDeck;
    }

    public Deck[] dealHands() {
        int deckNum = 4;
        int q = this.getDeckSize() / 4;
        Deck[] hands = new Deck[deckNum];
        for (int i = 0; i < deckNum; i++) {
            hands[i] = new Deck();
            for (int j = 0; j < q; j++) {
                hands[i].addCardToDeck(this.dealCardFromDeck());
            }
        }

        return hands;
    }

    public Card dealCardFromDeck() {
        if (this.getDeckSize() > 0) {
            Card c = new Card(this.cards.get(0).getRank(), this.cards.get(0).getFace(), this.cards.get(0).getSuit());
            cards.remove(0);
            return c;
        }
        return null;
    }

    public static void sortHand(Deck hand) {
        Card card;
        Card temp;
        int lowRank = 1000;
        int index = 0;
        for (int x = 0; x < hand.getDeckSize(); x++) {
            for (int i = 0; i < hand.getDeckSize(); i++) {
                card = hand.revealCardAtIndex(i);
                if (card.getRank() <= lowRank) {
                    lowRank = card.getRank();
                    index = i;
                }
            }
            card = hand.revealCardAtIndex(index);
            temp = hand.revealCardAtIndex(0);
            hand.addCardToDeckIndex(card,0);
            hand.addCardToDeckIndex(temp,index);
        }

    }

    public void addCardToDeck(Card cardToAdd) {
        cards.add(cardToAdd);
    }
    public void addCardToDeckIndex(Card cardToAdd, int index) {
        cards.add(index, cardToAdd);
    }

    public Card revealCardAtIndex(int i) {
        return this.cards.get(i);
    }
}
