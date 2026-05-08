package util;

import model.Card;

public class CardUtil {
    //utility class for card related operations

     //compare two cards and return the winner
     public static int compareCards(Card card1, Card card2) {
         if (card1.getRank() > card2.getRank()) {
             return 1; // card1 wins
         } else if (card1.getRank() < card2.getRank()) {
             return -1; // card2 wins
         } else {
             return 0; // tie
         }
     }


     // 11->J, 12->Q, 13->K, 14->A
    public static String numberToRank(int rank) {
        switch (rank) {
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            case 14: return "A";
            default: return String.valueOf(rank);
        }
    }

}
