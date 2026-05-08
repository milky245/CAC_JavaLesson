package model;

public class ComputerPlayer {
    //no need to redraw

    protected Card hand; // computer player's hand card
    protected int score; // computer player's victory score

    //draw an initial card
    public void drawInitial(Deck deck) {
        //computer player just draw a card and keep it, no need to redraw
        this.hand = deck.draw();
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
