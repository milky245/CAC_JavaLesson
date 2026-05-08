package model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    //initialize 52 cards without Joker
    public Deck() {
        this.cards = new ArrayList<>();
        String[] suits = {"ハート", "ダイヤ", "クラブ", "スペード"};
        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    //shuffle
    public void shuffle() {
        java.util.Collections.shuffle(cards);
    }

    //draw a card (remove from the deck and return it)
    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.removeLast();
    }

    //judge if the deck is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
