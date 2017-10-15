import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

/*This class constructs the object Cards which contains a 
 value and a suit. Each value is correlacted with a certain name and each suit is correlated
 with a certain string as well*/
public class Cards{
   public final static int SPADES = 0;  
   public final static int HEARTS = 1;
   public final static int CLUBS = 2;
   public final static int DIAMONDS = 3;
   
   public final static int ACE = 1;     
   public final static int JACK = 11;    
   public final static int QUEEN = 12;   
   public final static int KING = 13;
   
   private final int suit;
   private final int value;
 
   //This method checks if the cards are legal and find the value and suit of the card so they can be passed to other 
   //methods 
    public Cards(int cardValue, int cardSuit) {
      if (cardSuit != SPADES && cardSuit != HEARTS && cardSuit != DIAMONDS && 
            cardSuit != CLUBS)
         throw new IllegalArgumentException("Invalid card suit");
      if (cardValue < 1 || cardValue > 13)
         throw new IllegalArgumentException("Invalid playing card value");
      value = cardValue;
      suit = cardSuit;
   }
    //This returns the value of the suit when called 
    public int getSuit(){
      return suit;
    }
    //This returns the value of the cards when called
    public int getValue(){
      return value;
    }
    //This allows the player to print the cards suit as strings 
    public String getSuitAsString() {
      switch ( suit ) {
      case SPADES:   return "Spades";
      case HEARTS:   return "Hearts";
      case CLUBS:    return "Clubs";
      default:       return "Diamonds";
      
      }
    }
    //This allows the player to bring the value as a string 
    public String getValueAsString() {
         switch ( value ) {
         case 1:   return "Ace";
         case 2:   return "2";
         case 3:   return "3";
         case 4:   return "4";
         case 5:   return "5";
         case 6:   return "6";
         case 7:   return "7";
         case 8:   return "8";
         case 9:   return "9";
         case 10:  return "10";
         case 11:  return "Jack";
         case 12:  return "Queen";
         default:  return "King";
         }
      }
    
    //This condenses the two functions togteher so cards are able to be in the format  " Two of Hearts"
    public String toString() {
         return getValueAsString() + " of " + getSuitAsString();
   } 
} 

