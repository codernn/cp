import java.util.Scanner;

public class GoFish{
    
   public static Scanner input = new Scanner(System.in);
   private Deck homDeck;
   private Deck user;
   private Deck computer;
   private boolean win;
   private int userBooks, computerBooks;
   
   public GoFish()
   {
      homDeck = new Deck();
      homDeck.fillDeck();
      user = new Deck();
      computer = new Deck();
      win = false;
      userBooks = computerBooks = 0;
   }

   public void playGoFish()
   {
      initialize();
      checkStartingDeal();
      
      do
      {
         userTurn();
         checkGameOver();
         
         computerTurn();
         checkGameOver();
         
      }while(!win);
      
      System.out.println("Game Over!");
      displayWinner();
   }
   public void initialize()
   {
      for(int i = 0; i<7; i++)
      {
         user.insertCard(homDeck.deleteRandomCard());
         computer.insertCard(homDeck.deleteRandomCard());
      }
   }
   
   public void checkStartingDeal()
   {
      int userStartDeal = user.checkOpeningDeal();
      if(userStartDeal != 0)
      {
         System.out.println("You got lucky and got 1 book already" + userStartDeal + "\n");
         waitFish();
         userBooks++;
      }

      int computerStartDeal = computer.checkOpeningDeal();
      if(computerStartDeal != 0)
      {
         System.out.println("Computer got lucky and got 1 book already"+ computerStartDeal + "\n");
         waitFish();
         computerBooks++;
      }
   }
   
   public void userTurn()
   {
      boolean userTurn = false;
      do
      {  
         userTurn = false;
         if(!win)
         {
            Card drawnCard = null;
            System.out.println("Which value would you like to ask for?");
            int value = input.nextInt();
            while(user.getCount(value) == 0)
            {
               System.out.println("That Value isnt already contained in your deck, Please enter another value\n");
               value = input.nextInt();
            }
            int hits = computer.getCount(value);
            if(hits == 0)
            {
               System.out.println("Go Fish!");
               drawnCard = homDeck.deleteRandomCard();
               if(drawnCard.getValue() == value)
               {
                  user.insertCard(drawnCard);
                  userTurn = true;
                  System.out.println("Drawn Card: " + drawnCard);
                  System.out.println("Lucky Draw! Go again.");
                  waitFish();
               }else
               {
                 System.out.println("Drawn Card: " + drawnCard);
                 user.insertCard(drawnCard);
                 waitFish();
               }
               int countAfterGoFish = user.getCount(drawnCard.getValue());
               if(countAfterGoFish == 4)
               {
                  userBooks++;
                  System.out.println("With that Go Fish draw you've just completed a Book" +
                                     " with the value " + drawnCard.getValue() + "\n" +
                                     "You now have : " + userBooks + " Books\n" +
                                     "And the computer has : " + computerBooks + " Books");
                  waitFish();
                  for(int i = 0; i<4; i++)
                  {
                      user.deleteValue(drawnCard.getValue());
                  }
               }
               if(userTurn)
               {
                  checkGameOver();
               } 
            }else if(!userTurn && hits >= 1)
            {
               for(int i = 0; i < hits; i++)
               {
                  user.insertCard(computer.deleteValue(value));
               }
               System.out.println("The Computer had " + hits + " of those cards");
               userTurn = false;
               waitFish();
               int countAfterSteal = user.getCount(value);
               if(countAfterSteal == 4)
               {
                  userBooks++;
                  System.out.println("You just got a book from stealing the computer's card(s)" +
                                     " with the value " + value + "\n" +
                                     "You now have : " + userBooks + " Books\n" +
                                     "The computer currently has : " + computerBooks + " Books");
                  waitFish();
                  for(int i = 0; i<4; i++)
                  {
                     user.deleteValue(value);
                  }
               }
   
            }
         }
      }while(userTurn);
   }
   
   public void computerTurn()
   {
      boolean computerTurn = false;
      do
      {
         computerTurn = false;
         if(!win)
         {
            Card drawnCardCp = null;
            Card random = computer.deleteRandomCard(); 
            computer.insertCard(random);
            int Value = random.getValue();
            int computerHits = user.getCount(Value);
            if(computerHits == 0) 
            {
               drawnCardCp = homDeck.deleteRandomCard();
               if(drawnCardCp.getValue() == Value)
               {
                  computer.insertCard(drawnCardCp);
                  computerTurn = true;
                  System.out.println("Lucky draw for the computer! They go again.");
                  waitFish();
               }else
               {
                  System.out.println("The computer guessed Wrong..\n" +
                                     "Your turn.");
                  computer.insertCard(drawnCardCp); 
                  waitFish();       
               }                                                             
               int cpCountAfterGoFish = computer.getCount(drawnCardCp.getValue());
               if(cpCountAfterGoFish == 4) 
               {
                  computerBooks++;
                  System.out.println("The computer just got a book off a Go Fish draw" +
                                     " with the value " + drawnCardCp.getValue() + "\n" +
                                     "The computer now has : " + computerBooks + " Books\n" +
                                     "You currently have : " + userBooks + " Books");
                  waitFish();
                  for(int i = 0; i<4; i++)
                  {
                      computer.deleteValue(drawnCardCp.getValue());
                  }
               }
               if(computerTurn)
               {
                  checkGameOver();
               } 
            }else if(!computerTurn && computerHits >= 1)
            {
               for(int i = 0; i < computerHits; i++)
               {
                  computer.insertCard(user.deleteValue(Value));
               }
               System.out.println("The computer took " + computerHits + " of your cards!");
               computerTurn = false;
               waitFish();
               int cpCountAfterSteal = computer.getCount(Value);
               if(cpCountAfterSteal == 4)
               {
                  computerBooks++;
                  System.out.println("The computer just got a book from stealing your card(s)" +
                                     " with the value " + Value + "\n" +
                                     "The computer now has : " + computerBooks + " Books\n" +
                                     "You currently have : " + userBooks + " Books");
                  waitFish();
                  for(int i = 0; i<4; i++)
                  {
                      computer.deleteValue(Value);
                  }
                }
            }
         }
      }while(computerTurn);
   }
   
   public void checkGameOver()
   {
      win = (homDeck.getCardsUsed() == 0 || user.getCardsUsed() == 0
                        || computer.getCardsUsed() == 0);
   }
   
   public void displayWinner()
   {
      if(computerBooks > userBooks)
      {
         System.out.println("Better luck next time! The computer Won!\n" +
                            "Computer Books : " + computerBooks +
                            "\nUser Books : " + userBooks);
      }else if(userBooks > computerBooks)
      {
         System.out.println("Congrats!!! YOU Won!\n" +
                            "User Books : " + userBooks +
                            "\nComputer Books : " + computerBooks);
      }else if(userBooks == computerBooks)
      {
         System.out.println("The game was a tie!\n" +
                            "You both had " + userBooks + " books.");
      }
   }
   
   public static Scanner waitScanner = new Scanner(System.in);
   public void waitFish()
   {
      System.out.println("Press Enter to continue..");
         waitScanner.nextLine();
   }
  
   public static void main(String[] args) {
      System.out.println("Welcome to Go Fish Game! \n GET READY! \n");
      GoFish gFish = new GoFish();
      gFish.playGoFish();
   }
}