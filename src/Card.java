public class Card  {

    private String _name;
    private String _suit;
    private Integer _rank;

    /***
     * Creates Card object
     * @param name sets name of the Card object
     * @param suit sets suit of the Card object
     * @param rank sets rank of the Card object
     */
    public Card(String name, String suit, int rank) {
        _name = name;
        _suit = suit;
        _rank = rank;
    }

    /***
     * Getter for Name field of Card object
     * @return Name of the Card object
     */
    public String getName()
    {
        return _name;
    }
    /***
     * Getter for Suit field of Card object
     * @return suit of the Card object
     */
    public String getSuit()
    {
        return _suit;
    }
    /***
     * Getter for Rank field of Card object
     * @return rank of the Card object
     */
    public int getRank()
    {
        return _rank;
    }


}
