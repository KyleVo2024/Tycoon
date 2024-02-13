import java.lang.Math;
import java.util.*;

public class Tycoon {
    public Tycoon() {
        Deck mainDeck = new Deck();
        mainDeck.initializeNewDeck();
        mainDeck.shuffle();
        Deck[] allDecks = mainDeck.dealHands();
        Deck pl1 = allDecks[0];
        Deck pl2 = allDecks[1];
        Deck pl3 = allDecks[2];
        Deck pl4 = allDecks[3];
        Deck field = new Deck();
        this.EventLoop(pl1, pl2, pl3, pl4, field);
    }

    public void EventLoop(Deck pl1, Deck pl2, Deck pl3, Deck pl4, Deck field) {
        Scanner scan = new Scanner(System.in);
        boolean done = true;
        boolean playerTurn = true;
        String nextMove;
        int Move;
        Ui.printHand(pl1);
        while (done) {
            while (playerTurn) {
                try {
                    nextMove = scan.nextLine();
                    Move = Integer.parseInt(nextMove);
                    playCard(pl1, field, Move);
                    Ui.printField(field);
                    

                } catch (InputMismatchException ie) {
                    System.out.println("Can't play that!");
                }
            }
        }

    }
    public void playCard(Deck deck, Deck field, int index){
        Card card = deck.revealCardAtIndex(index);
        field.addCardToDeck(card);
    }
    public void checkMove(int Move){
        
    }


    public static void main(String[] args) throws Exception {
        Tycoon game = new Tycoon();
    }
}
