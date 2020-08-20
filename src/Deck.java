import java.util.*;
import java.util.function.Supplier;

public class Deck {
    /**
     * Deck of cards
     */
    private ArrayList<Card> _cards = new ArrayList<Card>();
    private List<String> names = Arrays.asList("Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Lady","King","Ace");
    private List<String> suits = Arrays.asList("Diamonds","Spades","Clubs","Hearts");

    /***
     * Creates deck of cards
     */
    public Deck() {
        Card card = null;
        for (int j = 0; j < suits.size(); j++)
        {
            for (int i = 0; i < names.size(); i++)
            {
                    card = new Card(names.get(i), suits.get(j), i);
                    _cards.add(card);
            }

        }
    }

    /***
     * To withdraw card from Deck
     * @return Card on the Top of deck
     */
    public Card withdrawCard() {
        Card card = _cards.get(0);
        _cards.remove(0);
        return card;
    }

    /***
     * Shuffles cards in deck
     */
    public void ShuffleDeck() {
        Random rnd = new Random();
        int n = _cards.size();
        while (n > 1)
        {
            n--;
            int k = rnd.nextInt(n);
            Card value = _cards.get(k);
            _cards.set(k,_cards.get(n));
            _cards.set(n,value);
        }

        System.out.println("Deck was shuffled");
        System.out.println("There are "+ _cards.size() + "cards");
        for (int i=0;i < _cards.size(); i++ )
        System.out.println(_cards.get(i).getName() + " " + _cards.get(i).getSuit());


    }




}
