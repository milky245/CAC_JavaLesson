package model;

public class Player {
    protected Card hand; // player's hand card
    protected int score; // player's victory score

//    //initialize the hand and score
//    public Player(Card hand) {
//        this.hand = hand;
//        this.score = 0;
//    }

    //initial drawn card
    public void drawInitial(Deck deck) {
        this.hand = deck.draw();
    }

    //player choose if he wants to redraw the card (max 2 times)
    public void redraw(Deck deck, DiscardPile discardPile) {
        int redrawCount = 0;
        while (redrawCount < 2) {
            System.out.println("あなたの手札を交換しますか？(残" + (2 - redrawCount) + "回)");
            String input = new java.util.Scanner(System.in).nextLine();
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
                discardPile.add(hand); // add the current hand to the discard pile
                hand = deck.draw(); // draw a new card
                redrawCount++;
                System.out.println("新しい手札をもらった ");
            } else {
                break; // stop redrawing if the player chooses not to redraw
            }
        }
        if (redrawCount == 2) {
            System.out.println("もう交換できません。");
        }
    }

    //get hand
    public Card getHand() {
        return hand;
    }

    //get score
    public int getScore() {
        return score;
    }

    //add score
    public void addScore() {
        score++;
    }

}
