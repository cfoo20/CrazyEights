import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class CrazyEightDriver
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner (System.in);
        // Create a deck of cards
        ArrayList<Card> deck = new ArrayList<Card>();
        // card[] deck = new card[52];
        for (int i = 0; i < 4; i++)
        {
            String suit = "";
            String number = "";
            if (i == 0)
            {
                suit = "clubs";
            }
            if (i == 1)
            {
                suit = "spades";
            }
            if (i == 2)
            {
                suit = "hearts";
            }
            if (i == 3)
            {
                suit = "diamonds";
            }
            for (int j = 1; j < 14; j++)
            {
                if (j > 1 && j < 11)
                {
                    number = Integer.toString(j);
                }
                if (j == 1)
                {
                    number = "ace";
                }
                if (j == 11)
                {
                    number = "jack";
                }
                if (j == 12)
                {
                    number = "queen";
                }
                if (j == 13)
                {
                    number = "king";
                }
                Card card = new Card(suit, number);
                deck.add(card);
            }
        }
        // Shuffle deck
        Collections.shuffle(deck);
        // print out pile
        /*for (int i = 0; i < deck.size(); i++)
        {
            Card cards = deck.get(i);
            System.out.println(cards.displayNumber() + " of " + cards.displaySuit());
        }*/
        // Create players (default 2)
        ArrayList<Card> p1 = new ArrayList<Card>();
        for (int i = 0; i < 8; i++)
        {
            p1.add(deck.get(i));
            deck.remove(i);
        }
        ArrayList<Card> p2 = new ArrayList<Card>();
        for (int i = 0; i < 8; i++)
        {
            p2.add(deck.get(i));
            deck.remove(i);
        }
        // show first card of game
        // Create a played cards pile
        ArrayList<Card> cardsPlayed = new ArrayList<Card>();
        cardsPlayed.add(deck.get(0));
        deck.remove(0);
        Card cards = cardsPlayed.get(0);
        Card lastCard = cards;
        System.out.println("First card: " + cards.displayNumber() + " of " + cards.displaySuit());

        boolean checkWin = false;
        while (!checkWin)
        {
            boolean isFound1 = false;
            boolean isFound2 = false;
            // PLayer 1 turn
            System.out.println("Card played: " + lastCard.displayNumber() + " of " + lastCard.displaySuit());
            // display player 1's cards
            System.out.println("Player 1's turn");
            for (int i = 0; i < p1.size(); i++)
            {
                cards = p1.get(i);
                System.out.println(cards.displayNumber() + " of " + cards.displaySuit());
            }
            // pick card to play
            while (!isFound1)
            {
                System.out.println("What card would you like to play?");
                String played = kb.nextLine();
                // play eight
                if (played.contains("8"))
                {
                    for (int i = 0; i < p1.size(); i++)
                    {
                        cards = p1.get(i);
                        isFound1 = played.contains("8") && played.contains(cards.displaySuit());
                        if (isFound1)
                        {
                            System.out.println("Player 1 played " + played);
                            cardsPlayed.add(cards);
                            lastCard = cards;
                            p1.remove(i);
                            break;
                        }
                    }
                    // ask for suit
                    System.out.print("What suit do you want to change it to?");
                    String newSuit = kb.next();
                    lastCard = new Card(newSuit, "8");
                }
                // pick up one card
                if (played.equals("pick up"))
                {
                    p1.add(deck.get(0));
                    deck.remove(0);
                    // move cards from played pile to deck
                    if (deck.isEmpty())
                    {
                        int size = cardsPlayed.size();
                        for (int i = 0; i < size - 1; i++)
                        {
                            deck.add(cardsPlayed.get(0));
                            cardsPlayed.remove(0);
                        }
                        // Shuffle deck
                        Collections.shuffle(deck);
                    }
                }
                System.out.println(played.contains(lastCard.displaySuit()));
                if (played.contains(lastCard.displaySuit()) || played.contains(lastCard.displayNumber()))
                {
                    for (int i = 0; i < p1.size(); i++)
                    {
                        cards = p1.get(i);
                        isFound1 = played.contains(cards.displayNumber()) && played.contains(cards.displaySuit());
                        if (isFound1)
                        {
                            System.out.println("Player 1 played " + played);                                cardsPlayed.add(cards);
                            lastCard = cards;
                            p1.remove(i);
                            break;

                        }
                    }
                }
                if (!isFound1)
                {
                    System.out.println("The card could not be found. Please input another card.");
                }
            }
            if (p1.isEmpty())
            {
                checkWin = true;
                System.out.println("Player 1 wins!");
                break;
            }
            // Player 2 turn
            System.out.println("Card played: " + lastCard.displayNumber() + " of " + lastCard.displaySuit());
            // display player 2's cards
            System.out.println("Player 2's turn");
            for (int i = 0; i < p2.size(); i++)
            {
                cards = p2.get(i);
                System.out.println(cards.displayNumber() + " of " + cards.displaySuit());
            }
            // pick card to play
            while (!isFound2)
            {
                System.out.println("What card would you like to play?");
                String played = kb.nextLine();
                // play eight
                if (played.contains("8"))
                {
                    for (int i = 0; i < p2.size(); i++)
                    {
                        cards = p2.get(i);
                        isFound2 = played.contains("8") && played.contains(cards.displaySuit());
                        if (isFound2)
                        {
                            System.out.println("Player 2 played " + played);
                            cardsPlayed.add(cards);
                            lastCard = cards;
                            p2.remove(i);
                            break;
                        }
                    }
                    // ask for suit
                    System.out.print("What suit do you want to change it to?");
                    String newSuit = kb.next();
                    lastCard = new Card(newSuit, "8");
                }
                // pick up one card
                if (played.equals("pick up"))
                {
                    p1.add(deck.get(0));
                    deck.remove(0);
                    // move cards from played pile to deck
                    if (deck.isEmpty())
                    {
                        int size = cardsPlayed.size();
                        for (int i = 0; i < size - 1; i++)
                        {
                            deck.add(cardsPlayed.get(0));
                            cardsPlayed.remove(0);
                        }
                        // Shuffle deck
                        Collections.shuffle(deck);
                    }
                }
                else
                {
                    if (played.contains(lastCard.displaySuit()) || played.contains(lastCard.displayNumber()))
                    {
                        for (int i = 0; i < p2.size(); i++)
                        {
                            cards = p2.get(i);
                            isFound2 = played.contains(cards.displayNumber()) && played.contains(cards.displaySuit());
                            if (isFound2)
                            {
                                System.out.println("Player 2 played " + played);
                                cardsPlayed.add(cards);
                                lastCard = cards;
                                p2.remove(i);
                                break;
                            }
                        }
                    }
                }
                if (!isFound2)
                {
                    System.out.println("The card could not be found. Please input another card.");
                }
            }
            if (p2.isEmpty())
            {
                checkWin = true;
                System.out.println("Player 2 wins!");
            }
        }
    }
}