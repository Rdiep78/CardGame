import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

/*This is my created card game. It deals each player three cards and the player with the bigger hand wins. 
 However if the player who has 3 face cards they automatically win. How your score is calcualted is by adding up the 
 value of the three cards and the Mod 10 of the total. The greater value wins. */
public class playgame{
  public static void main(String[] args){
    int p1Score = 0; //keeps track of player score 
    int p2Score = 0;
    boolean playAgain;
    
    Scanner user_input = new Scanner(System.in);
    String p1Name; // Stores the user name input via a scanner 
    String p2Name;
    try{ // Forces player to enter a name and cannot leave it null
      System.out.print("Player 1 enter your name: ");
      p1Name = user_input.next();
    }
    catch(NullPointerException e)
    { System.out.print("Cannot enter blank name./n");
      System.out.print("Player 1 enter your name again: ");
      p1Name = user_input.next();
    }
    try{
      System.out.print("Player 2 enter your name: ");
      p2Name = user_input.next();
    }
    catch(NullPointerException e)
    { System.out.print("Cannot enter blank name./n");
      System.out.print("Player 2 enter your name again: ");
      p2Name = user_input.next();
    }
    while (p1Score < 5 && p2Score <5){ // This function continues the game until a player hits 5 points 
      System.out.print(p1Name + " Score: " + Integer.toString(p1Score) + "\n");
      System.out.print(p2Name + " Score: " + Integer.toString(p2Score)+ "\n");
      int winner = playgame();
      switch (winner){
        case 1: 
          p1Score++;
          System.out.print(p1Name + " wins the round" + "\n");
          break;
        case 2:
          p2Score++;
          System.out.print(p2Name + " wins the round"+ "\n");
          break;
        default:
          System.out.println("DRAW" + "\n");
          break;
      }
    System.out.println(p1Name + " Score: " + Integer.toString(p1Score));
    System.out.println(p2Name + " Score: " + Integer.toString(p2Score));
    System.out.println("Press Enter to continue...");
      Scanner scanner = new Scanner(System.in);
      scanner.nextLine();
    }
    //Prints the winners of the game 
    if (p1Score > p2Score)
      System.out.println(p1Name + " wins the game!");
    else 
      System.out.println(p2Name + " wins the game!");
    
  }
  /*Thisis the main game method */
  private static int playgame(){
    Deck deck = new Deck(); //Constructs a new deck
    deck.shuffle();
    Hand p1hand = new Hand()  ; // constructs a new hand
    Hand p2hand = new Hand() ;
    
    //Add cards to the hand 
    for (int i =0; i<3; i++){
      p1hand.addCard(deck.deal());
      p2hand.addCard(deck.deal());  
    }
    //DISPLAY HAND 
    System.out.print("Player 1 Hand: "+ p1hand.printHand()+ "\n");
    System.out.print("Player 2 Hand: " + p2hand.printHand()+ "\n");
    
    //Calculate the value of the hand 
    int p1Val = p1hand.handValue();
    int p2Val = p2hand.handValue();
    p1hand.clearhand();
    p2hand.clearhand();//clear the hand after the round is over
    //This is the core of the game and the method on how it fucntions 
    if (p1Val > 30 && p2Val > 30){
      return 0;
    }
    else if (p1Val > 30)

      return 1; 
    else if (p2Val > 30)
      return 2; 
      else {
        p1Val = p1Val%10;
        p2Val = p2Val%10;
        System.out.print("Player 1 hand value: " + Integer.toString(p1Val)+"\n");
        System.out.print("Player 2 hand value: " + Integer.toString(p2Val)+"\n");
        if (p1Val > p2Val)// reutns the winner 
          return 1;
        else 
          return 2;
      }  
  }
}