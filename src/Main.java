import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * Lab 3 P7.9
 * @author Sergei Chekhonin
 * This program simulates poker game
 */

public class Main {

   public static void main(String[] args) {

        //This block initialize printWriter and dateFormatter
        PrintWriter out = null;
        try {
            out = new PrintWriter("Lab3_P7.9output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        //Instantiate Deck, Frame, Random object, reference type Card, List of cards, Iterator
        Deck deck = new Deck();
        Card card = null;
        final JFrame frame = new JFrame();
        Random r = new Random();
        ArrayList<Card> cardsOnHands = new ArrayList<Card>();
        Iterator<Card> cardIterator = cardsOnHands.iterator();

        //Shuffle deck
       deck.ShuffleDeck();

       //print some messages
        out.println(dtf.format(now));
        out.println("Let's start poker game");
        JOptionPane.showMessageDialog(frame,
                "Let's start poker game",
                "The Poker Game",
                JOptionPane.PLAIN_MESSAGE);
        //give 5 cards to the player and show them to him
       out.println("You was given following cards from deck: ");
       System.out.println("You was given following cards from deck: ");
       for (int i=1; i<=5; i++){
           card = deck.withdrawCard();
           cardsOnHands.add(card);
           out.println(i+")"+card.getName()+ " "+ card.getSuit());
           System.out.println(i+")"+card.getName()+ " "+ card.getSuit());
       }
       JOptionPane.showMessageDialog(frame,
               "You was given following cards from deck: \n"
                       +cardsOnHands.get(0).getName()+" "+cardsOnHands.get(0).getSuit()+"\n"
                       +cardsOnHands.get(1).getName()+" "+cardsOnHands.get(1).getSuit()+"\n"
                       +cardsOnHands.get(2).getName()+" "+cardsOnHands.get(2).getSuit()+"\n"
                       +cardsOnHands.get(3).getName()+" "+cardsOnHands.get(3).getSuit()+"\n"
                       +cardsOnHands.get(4).getName()+" "+cardsOnHands.get(4).getSuit(),
               "The Poker Game",
               JOptionPane.PLAIN_MESSAGE);

       //user prompted to decide whether he wants to drops some cards
       out.println("Choose indexes of cards you want to replace: ");
       System.out.println("Choose indexes of cards you want to replace: ");
       /**
        * stores input indexes to drop as single string
        */
       String input = JOptionPane.showInputDialog(frame,"Choose indexes of cards you want to drop (enter using space) or push enter: ", "");
       System.out.println(input);
       /**
        * splits single string into String array
        */
       //check if user entered anything, else jump to define score
       if (!input.isEmpty() && !input.isBlank()){
       String[] strNums = input.split(" ");
       /**
        * stores input  Int indexes of card user decided to drop
        */
       List <Integer> intList=new ArrayList<>();


       if (strNums != null) {
           for (String strNum : strNums) {
               try {
                   //parse input to Int List
                   intList.add(Integer.parseInt(strNum.trim()));
               } catch (Exception e) {
                   System.out.println("Invalid or empty input");
                   break;
               }
           }
       }
           //print out what indexes was chosen
           for (int i = 0; i < intList.size(); i++) {
               out.printf("%d ", intList.get(i));
               System.out.printf("%d ", intList.get(i));
           }
           out.println("");
           System.out.println("");

           //remove chosen from hands
           for (int i = 0; i < intList.size(); i++) {
               cardsOnHands.remove(intList.get(i) - 1);
               for (int j = i + 1; j < intList.size(); j++) {
                   intList.set(j, intList.get(j) - 1);
               }

           }
           //replace cards with new from the deck
           for (int i = 0; i < intList.size(); i++) {
               card = deck.withdrawCard();
               cardsOnHands.add(card);
           }

           out.println("After replacement you have following cards on hands: ");
           System.out.println("After replacement you have following cards on hands: ");
           //print out cards on hands
           for (int i = 1; i < cardsOnHands.size() + 1; i++) {
               out.println(i + ")" + cardsOnHands.get(i - 1).getName() + " " + cardsOnHands.get(i - 1).getSuit());
               System.out.println(i + ")" + cardsOnHands.get(i - 1).getName() + " " + cardsOnHands.get(i - 1).getSuit());
           }
           JOptionPane.showMessageDialog(frame,
                   "After replacement you have following cards on hands: \n"
                           + cardsOnHands.get(0).getName() + " " + cardsOnHands.get(0).getSuit() + "\n"
                           + cardsOnHands.get(1).getName() + " " + cardsOnHands.get(1).getSuit() + "\n"
                           + cardsOnHands.get(2).getName() + " " + cardsOnHands.get(2).getSuit() + "\n"
                           + cardsOnHands.get(3).getName() + " " + cardsOnHands.get(3).getSuit() + "\n"
                           + cardsOnHands.get(4).getName() + " " + cardsOnHands.get(4).getSuit(),
                   "The Poker Game",
                   JOptionPane.PLAIN_MESSAGE);
       }
       //Test sets of cards

       ArrayList<Card> testCardsOnHandsTwo = new ArrayList<>(); //return 1 pair
       ArrayList<Card> testCardsOnHandsThree = new ArrayList<>(); //return three of a kind pairs
       ArrayList<Card> testCardsOnHandsFour = new ArrayList<>(); //return four of a kind pairs
       ArrayList<Card> testCardsOnHandsStraight = new ArrayList<>(); //return Straight
       ArrayList<Card> testCardsOnHandsTwoPlusThree1 = new ArrayList<>(); //return Full house
       ArrayList<Card> testCardsOnHandsTwoPlusThree2 = new ArrayList<>(); //return Full house
       ArrayList<Card> testCardsOnHandsFlush = new ArrayList<>(); //return Flush
       ArrayList<Card> testCardsOnHandsStraightFlush = new ArrayList<>();//return Straight Flush
       ArrayList<Card> testCardsOnHandsRoyalFlush = new ArrayList<>();//return Royal Flush


       {   testCardsOnHandsTwo.add(new Card("Two", "Any", 0));
           testCardsOnHandsTwo.add(new Card("Two", "Any", 0));
           testCardsOnHandsTwo.add(new Card("Five", "Suit1", 3));
           testCardsOnHandsTwo.add(new Card("Eight", "Suit2", 6));
           testCardsOnHandsTwo.add(new Card("Ace", "Other", 12));

           testCardsOnHandsThree.add(new Card("Two", "Any", 0));
           testCardsOnHandsThree.add(new Card("Two", "Any", 0));
           testCardsOnHandsThree.add(new Card("Two", "Any", 0));
           testCardsOnHandsThree.add(new Card("Five", "Any", 3));
           testCardsOnHandsThree.add(new Card("Ace", "Other", 12));

           testCardsOnHandsFour.add(new Card("Two", "Any", 0));
           testCardsOnHandsFour.add(new Card("Two", "Any", 0));
           testCardsOnHandsFour.add(new Card("Two", "Any", 0));
           testCardsOnHandsFour.add(new Card("Two", "Any", 0));
           testCardsOnHandsFour.add(new Card("Ace", "Other", 12));

           testCardsOnHandsStraight.add(new Card("Two", "Any", 0));
           testCardsOnHandsStraight.add(new Card("Three", "Any", 1));
           testCardsOnHandsStraight.add(new Card("Four", "Any", 2));
           testCardsOnHandsStraight.add(new Card("Five", "Any", 3));
           testCardsOnHandsStraight.add(new Card("Ace", "Other", 12));

           testCardsOnHandsTwoPlusThree1.add(new Card("Two", "Any", 0));
           testCardsOnHandsTwoPlusThree1.add(new Card("Two", "Any", 0));
           testCardsOnHandsTwoPlusThree1.add(new Card("Four", "Any", 2));
           testCardsOnHandsTwoPlusThree1.add(new Card("Four", "Any", 2));
           testCardsOnHandsTwoPlusThree1.add(new Card("Four", "Other", 2));

           testCardsOnHandsTwoPlusThree2.add(new Card("Two", "Any", 0));
           testCardsOnHandsTwoPlusThree2.add(new Card("Two", "Any", 0));
           testCardsOnHandsTwoPlusThree2.add(new Card("Two", "Any", 0));
           testCardsOnHandsTwoPlusThree2.add(new Card("Four", "Any", 2));
           testCardsOnHandsTwoPlusThree2.add(new Card("Four", "Other", 2));

           testCardsOnHandsFlush.add(new Card("Two", "Any", 0));
           testCardsOnHandsFlush.add(new Card("Four", "Any", 2));
           testCardsOnHandsFlush.add(new Card("Five", "Any", 3));
           testCardsOnHandsFlush.add(new Card("Seven", "Any", 5));
           testCardsOnHandsFlush.add(new Card("Ten", "Any", 8));

           testCardsOnHandsStraightFlush.add(new Card("Nine", "Any", 7));
           testCardsOnHandsStraightFlush.add(new Card("Ten", "Any", 8));
           testCardsOnHandsStraightFlush.add(new Card("Jack", "Any", 9));
           testCardsOnHandsStraightFlush.add(new Card("Queen", "Any", 10));
           testCardsOnHandsStraightFlush.add(new Card("King", "Any", 11));

           testCardsOnHandsRoyalFlush.add(new Card("Ten", "Any", 8));
           testCardsOnHandsRoyalFlush.add(new Card("Jack", "Any", 9));
           testCardsOnHandsRoyalFlush.add(new Card("Queen", "Any", 10));
           testCardsOnHandsRoyalFlush.add(new Card("King", "Any", 11));
           testCardsOnHandsRoyalFlush.add(new Card("Ace", "Any", 12));
       }
       //check what kind of score on hands

       String payout ="";
       switch (compareCards(cardsOnHands)){
       //switch (compareCards(testCardsOnHandsRoyalFlush)){
           case 0 : payout = "You have No pair on hand. Payout is 0";break;
           case 1 : payout = "You have One pair on hand. Payout is 1";break; // one pair `two queens`
           case 2 : payout = "You have Two pairs on hand. Payout is 2";break; // two pairs `two queens + two six`
           case 3 : payout = "You have Three of a kind on hand. Payout is 3";break; // `three queens`
           case 4 : payout = "You have Straight on hand. Payout is 4";break; // `Ace, 2,3,4,5`
           case 5 : payout = "You have Flush on hand. Payout is 5"; break;// 5 cards same suit
           case 6 : payout = "You have Full House on hand. Payout is 6"; break;// `three queens + two six`
           case 7 : payout = "You have Four of a Kind on hand. Payout is 25"; break;// `four queens`
           case 8 : payout = "You have Straight Flush on hand. Payout is 50";break; // same suit `Ace, 2,3,4,5`
           case 9 : payout = "You have Royal Flush on hand. Payout is 250"; break;// same suit `ten, jack, queen, king, Ace`
       }

       out.println(payout);
       System.out.println(payout);
       JOptionPane.showMessageDialog(frame,
               payout,
               "The Poker Game",
               JOptionPane.PLAIN_MESSAGE);

       out.close();
       System.exit(0);
    }

    /***
     * Compare if cards on hands matches
     * @param cards ArrayList of objects Card
     * @return integer that define certain match
     */
    public static int compareCards(ArrayList<Card> cards){
        cards = sortCards(cards);

        System.out.println("After replacement you have following cards on hands: ");
        //print out cards on hands
        for (int i = 1; i < cards.size() + 1; i++) {
            System.out.println(i + ")" + cards.get(i - 1).getName() + " " + cards.get(i - 1).getSuit());
        }
        boolean foundStraight = false;
        int[] matchedRanks = new int[3];
        int rankMatches = 0;
        int suitMatches =0;
        int straightMatch = 0;
        //loop to iterate through Cards in a list
        for (int i=0; i<cards.size()-1; i++){
            //compare cards ranks: if they coincide so it is match of 2,3 or 4 cards
            if (cards.get(i).getRank() == cards.get(i+1).getRank()){
                rankMatches++;
                //store ranks of cards in array to determine 2,3 or 4 cards match
                matchedRanks[rankMatches-1] = cards.get(i).getRank();
            }
            //compare card ranks: if they coincide so it is match of 2,3 or 4 cards
            if (cards.get(i).getSuit() == cards.get(i+1).getSuit()){
                suitMatches++;
            }
            //if for every card is true that rank of i+1 card subtract rank of i card equal to 1
            if (cards.get(i+1).getRank()-cards.get(i).getRank()==1){
                straightMatch++;
            }
        }
        for (int i=0; i<cards.size()-2; i++){
            if (cards.get(i+1).getRank()-cards.get(i).getRank()==1
                    && cards.get(cards.size()-1).getRank() - cards.get(0).getRank() == 12){
                straightMatch++;
            }
        }
        if (straightMatch ==4) foundStraight=true;

        //Check all possible states of cards on hands
        if (rankMatches == 1) return 1;
        else if (rankMatches == 2 && matchedRanks[0]!=matchedRanks[1] ) return 2;
        else if (rankMatches == 2 && matchedRanks[0]==matchedRanks[1] ) return 3;
        else if (rankMatches == 3 && (matchedRanks[0]!=matchedRanks[1]
                && matchedRanks[1]==matchedRanks[2]
                || matchedRanks[0]==matchedRanks[1]&& matchedRanks[1]!=matchedRanks[2])) return 6;
        else if (rankMatches == 3 && matchedRanks[0]==matchedRanks[1]
                && matchedRanks[1]==matchedRanks[2] ) return 7;
        else if (suitMatches ==4 && foundStraight && cards.get(0).getName() =="Ten") return 9;
        else if (suitMatches ==4 && foundStraight) return 8;
        else if (suitMatches == 4) return 5;

        else if(foundStraight) return 4;
        else return 0;

    }

    /***
     * Sort cards on hands according to rank
     */
    public static ArrayList<Card> sortCards(ArrayList<Card> cards) {
        Card tempCard;
        for (int i =0; i<cards.size()-1;i++)
        {
            if(cards.get(i).getRank() > cards.get(i+1).getRank())
            {
                tempCard = cards.get(i);
                cards.set(i,cards.get(i+1));
                cards.set(i+1,tempCard);
            }
        }
        return cards;
     }
}
