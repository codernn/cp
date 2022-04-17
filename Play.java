import java.util.Scanner;

public class Play {
   public static void main(String args[]){
   
      // Create the deck of cards
      Deck deck = new Deck();
      Card card = deck.dealCard();
      boolean win=true;
      int score=0;
      int prev=card.getValue();
      // System.out.println(prev);
      while(win){
         Card card1 = deck.dealCard();
         int val = card1.getValue();
         System.out.println("Predict the next card is high or low! Enter 1 for high and 0 for low");
         Scanner sc = new Scanner(System.in);
         int pred = sc.nextInt();
         if(score==52){
            System.out.println("Ran out of deck of cards");
         }
         if(pred==1){
            if(prev>val){
               win = false;
               System.out.println("You Lost!, your score is: "+ score);
            }
            else if(prev==val){
               System.out.println("The value is same, Keep playing!");
            }
            else{
               prev = val;
               score++;
            }
         }
         else{
            if(prev<val){
               win = false;
               System.out.println("You Lost!, your score is: "+ score);
            }
            else if(prev==val){
               System.out.println("The value is same, Keep playing!");
            }
            else{
               prev = val;
               score++;
            }
         }
      }   
   }
}