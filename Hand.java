import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

/*This class is used to create an array of cards called Hand */
public class Hand{
   private ArrayList<Cards> hand; 
   
  public Hand(){
    hand = new ArrayList<Cards>();
  }
  
  //This calls the preset fucntion to empty the hand 
  public void clearhand(){
    hand.clear();
  }
  
  //This allows a card x to be added to the hand 
  public void addCard(Cards x){
    if (x==null)
     throw new NullPointerException("Can't add a null card to a hand.");
    hand.add(x);
  }
  
  //This fucntion is able to count the number of cards in the hand 
  public int getCardCount() {
     return hand.size();
    }
  
  //This function finds the value of the hand to compare 
  public int handValue(){
    int handVal=0;
    if (hand.size() > 0){
      for (int i=0; i<hand.size(); i++){
       Cards c = hand.get(i);
       handVal = c.getValue() + handVal;
      }
    }
    return handVal;
  }
  //This fucntion prints out the list of cards within your hand 
  public String printHand(){
    Cards c1;
    Cards c2;
    Cards c3;
    if (hand.size() > 0){
      c1 = hand.get(0);
      c2 = hand.get(1);
      c3 = hand.get(2);
      return c1.getValueAsString() + " of " + c1.getSuitAsString() + "\t\t" + c2.getValueAsString() + " of " + c2.getSuitAsString()
        + "\t\t" + c3.getValueAsString() + " of " + c3.getSuitAsString();
    }
    return "Hand is Invalid!\n";
  }
}
    
