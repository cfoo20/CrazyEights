import.java.util.Scanner;
import java.util.Collections;

public class CrazyEightDriver
{
    Scanner kb = new Scanner (System.in);
    // Create a deck of cards
    ArrayList<String> deck = new ArrayList<String>(card());
    // card[] deck = new card[52];
    for (int i = 0; i < deck.length; i++)
    {
        if (0 >= i && i < 13)
        {
            suit = 'clubs';
        }
        if (i >= 13 && i < 26)
        {
            suit = 'spades';
        }
        if (i >= 26 && i < 39)
        {
            suit = 'hearts';
        }
        else
        {
            suit = 'diamonds';
        }
        for (int j = 1; j < 14; j++)
        {
            if (j > 1 && j < 11)
            {
                number = Integer.toString(j);
            }
            if (j = 1)
            {
                number = 'ace';
            }
            if (j = 11)
            {
                number = 'jack';
            }
            if (j = 12)
            {
                number = 'queen';
            }
            if (j = 13)
            {
                number = 'king';
            }
            deck.add(suit, number);
        }
    }
    // Shuffle deck
    Collections.shuffle(deck, new Random());
    // Create players (default 3)
    ArrayList<String> p1 = new ArrayList<String>(card());
    for (int i = 0; i < 8; i++)
    {
        p1.add(deck[i]);
        deck.remove(i);
    }
    ArrayList<String> p2 = new ArrayList<String>(card());
    for (int i = 0; i < 8; i++)
    {
        p1.add(deck[i]);
        deck.remove(i);
    }
    ArrayList<String> p3 = new ArrayList<String>(card());
    for (int i = 0; i < 8; i++)
    {
        p1.add(deck[i]);
        deck.remove(i);
    }
    // show first card
    System.out.println("First card: " + deck[0]);
    // PLayer 1 turn
    // display player 1's cards
    System.out.println("Player 1's turn");
    for (int j = 0; j < p1.size(); j++)
    {
        System.out.print(p1.number(j) + "of" + p1.suit(j));
    }
    // pick card to play
    do
    {
        String played = kb.next();
        for (int j = 0; j < p1.size(); j++)
        {
            boolean isFound = played.contains(p1.number(j)) && played.contains(p1.suit(j));
            if (isFound)
            {
                System.out.println("Player 1 played " + played);
                p1.remove(j);
                break;
            }
        }
        if (!isFound)
        {
            System.out.println("The card could not be found. Please input another card.");
        }
    } while (!isFound)
    for (int)
    if (card.suit(0) == card.suit)
}