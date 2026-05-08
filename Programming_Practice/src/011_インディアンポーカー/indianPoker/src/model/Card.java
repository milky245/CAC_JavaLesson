package model;

import util.CardUtil;

public class Card {
    private String suit; // スート
    private int rank; // ランク (2-14, where 11=J, 12=Q, 13=K, 14=A)

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    //getter

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        //return suit + numberToRank(rank);
        return suit + " " + CardUtil.numberToRank(rank);
    }


}
