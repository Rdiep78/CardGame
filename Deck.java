import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

/*This class constructs a deck of cards */
public class Deck{
  private Cards[] deck; // creates an arraylist of cards called Deck
  private int cardsUsed; // Keeps track of the number of cards used 
  
  
  public Deck() {
        deck(false);  // Just call the constructor to create a deck
    }

  
   /*This creates the Cards in the format Cards (int value, int suit). It creates 13 values for each suit (4)*/
  public void deck(boolean joker){ 
      if (joker)
            deck = new Cards[54];
      else{
    deck =new Cards[52];
    int cardCounter = 0;
    for (int suit = 0; suit <=3; suit++){
      for (int value = 1; value <=13; value ++){
        deck[cardCounter] = new Cards(value, suit);
        cardCounter++;
      }
    }
  }
    cardsUsed = 0;
  }
  
  //This function shuffles the cards in the deck in a random order 
  public void shuffle(){
    for (int i = deck.length-1; i > 0; i--){
      int shuff = (int)(Math.random()*(i+1));
      Cards holder = deck[i];
      deck[i] = deck[shuff];
      deck[shuff] = holder;
    }
    cardsUsed = 0;
  }
  
  //This method allows the deck to know how many cards are left 
   public int cardsLeft() {
        return deck.length - cardsUsed;
    }
   
   //This method deals the top card from the deck after shuffled 
   public Cards deal(){
     if(cardsUsed == deck.length)
       throw new IllegalStateException("No Cards are left in the deck, need to reshuffle");
     cardsUsed++;
     return deck [cardsUsed -1];
   }
}