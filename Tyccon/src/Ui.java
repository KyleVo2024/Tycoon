public class Ui {
    public static void printHand(Deck pl1){
        Card hand1;
        for(int i=0;i<pl1.getDeckSize();i++){
            hand1= pl1.revealCardAtIndex(i);
            System.out.println(hand1.getFace() +" of "+ hand1.getSuit());
        }
    }
    public void printTopCard(){

    }
}
