import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;
import java.util.Scanner;

public class Tycoon {
    public Tycoon() {
        Deck mainDeck = new Deck();
        mainDeck.initializeNewDeck();
        mainDeck.shuffle();
        Deck[] allDecks = mainDeck.dealHands();
        Deck pl1 = allDecks[0];
        Deck pl2 = allDecks[1];
        Deck pl3 = allDecks[2];
        Deck pl4 = allDecks[2];
        this.EventLoop(pl1,pl2,pl3,pl4);
    }

    public void EventLoop(Deck pl1, Deck pl2, Deck draw) {
        Scanner scan = new Scanner(System.in);
        
    }

    public static void main(String[] args) throws Exception {
        Tycoon game = new Tycoon();
    }
}
