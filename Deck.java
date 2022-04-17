import java.util.Random;

public class Deck {
   private Card[] deck ;  //An array to hold 52 Cards 
   private int cardsUsed=0;          // Indicates the number of cards that have been dealt
   private static final int capacity = 52;
   private static Random random = new Random();
   public Deck()
   {
      deck = new Card[capacity];
      cardsUsed = 0;
   }
   // creates a deck of 52 cards with 4 suits number 1-4, and 13 cards number 1-13. 
   public void fillDeck() {
      Card card;
      for (int suit = 1; suit <= 4; suit++) {
         for (int value = 1; value <= 13; value++) {
            card = new Card(value,suit);
            this.insertCard(card);
         }
      }
      shuffle();
   }
   
   // Shuffle the remaining cards in the deck
   public void shuffle() {
      for (int i = 51; i > cardsUsed; i--) {
         int rand = (int)(Math.random()*(i-cardsUsed)+cardsUsed);
         Card tmp = deck[i];
         deck[i] = deck[rand];
         deck[rand] = tmp;
      }
   }
   
   // Deal the next card. Null is returned if all cards are used. 
   public Card dealCard() {
      if (cardsUsed == 52)
         return null;
      Card nextCard = deck[cardsUsed];
      cardsUsed++;
      return nextCard;
   }
   
   // Returns the number of cards that have been used.  
   public int getCardsUsed() {
      return cardsUsed;
   }
   
   // See a specific card in the deck.  
   public Card viewCard(int cardNum) {
      return deck[cardNum];
   }
   
   // Reset to a full deck.
   public void resetDeck() {
      cardsUsed = 0;
      shuffle();
   }

   //Delete random card from the deck, used to populate hands in the game
   public Card deleteRandomCard(){
      if(cardsUsed == 0){
         return null;
      }
      int rand = random.nextInt(cardsUsed);
      Card temp = deck[rand];
      if(rand != cardsUsed-1){
         deck[rand] = deck[cardsUsed-1];
         cardsUsed--;
      }
      else{
         deck[cardsUsed-1] = null;
         cardsUsed--;
      }
      return temp;
   }

   //Delete selected value
   public Card deleteValue(int value)
   {
      Card temp,deleted;
      for(int i = 0; i<cardsUsed; i++)
      {
         temp = deck[i];
         if(temp.getValue() == value)
         {
            deleted = temp;
            deck[i] = deck[cardsUsed-1];
            cardsUsed--;
            return deleted;
         }
      }   
      return null;      
   }

   public void insertCard(Card card)
   {
      if(cardsUsed == deck.length)
      {
         Card[] temp = new Card[cardsUsed + capacity];
         for(int i = 0; i < deck.length; i++)
         {
            temp[i] = deck[i];
         }
         deck = temp;
      } 
      deck[cardsUsed] = card;
      cardsUsed++;
   }
   public int checkOpeningDeal() 
   {
      for(int i = 0; i<4 ; i++)
      {
         if(deck[i]!=null){
            if(getCount(deck[i].getValue()) == 4)
            {
               return deck[i].getValue();
            }
         }
      }
      return 0;
   }
   public int getCount(int value)
   {
      int count = 0;
      for(int i = 0; i<cardsUsed;i++)
      {
         if(deck[i]!= null && deck[i].getValue() == value)
         {
            count++;
         }
      }
      return count;
   }
}