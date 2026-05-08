package game;

import model.*;

public class GameManager {
    //core logic of the game,
    // including the main game loop,
    // handling user input,
    // and managing the flow of the game

    private Deck deck;
    private DiscardPile discardPile;
    private Player player;
    private ComputerPlayer computerPlayer;

    //start the game
    //initialize objects, shuffle the deck
    //start the game for 3 rounds
    public void startGame() {
        deck = new Deck();
        discardPile = new DiscardPile();
        player = new Player();
        computerPlayer = new ComputerPlayer();
        deck.shuffle();
        for (int round = 1; round <= 3; round++) {
            System.out.println("★" + round + "回戦");
            playRound();
        }
        System.out.println("ゲーム終了！");
        //display the final score and the winner
        if (player.getScore() > computerPlayer.getScore()) {
            System.out.println("あなたの勝ち！");
        } else if (player.getScore() < computerPlayer.getScore()) {
            System.out.println("コンピュータの勝ち！");
        } else {
            System.out.println("引き分け！");
        }
    }

    //do the process of each round
    // 1. 双方抽牌
    // 2. 玩家选择是否重抽
    // 3. 比较大小
    // 4. 更新分数
    // 5. 显示目前双方累计胜利分数+弃牌堆列表（弃牌堆按花色分类，每个花色内从小到大排序显示）

    private void playRound() {
        //1. 双方抽牌
        player.drawInitial(deck);
        computerPlayer.drawInitial(deck);

        //显示电脑抽牌结果
        System.out.println("相手の手札："+computerPlayer.getHand().toString());

        //2. 玩家选择是否重抽
        player.redraw(deck, discardPile);
        //3. 比较大小
        displayRoundResult();
        showScore();
    }

    //compare the hand of player and computer,
    //judge the winner(win lose or duel) of the round, and add score to the winner
    private void judge() {
            int playerRank = player.getHand().getRank();
            int computerRank = computerPlayer.getHand().getRank();
            if (playerRank > computerRank) {
                System.out.println("あなたの勝ちです！");
                player.addScore();
            } else if (playerRank < computerRank) {
                System.out.println("コンピュータの勝ちです！");
                computerPlayer.addScore();
            } else {
                System.out.println("引き分けです！");
            }

    }

    //display the hand of player and computer
    //display the result of the round
    private void displayRoundResult() {
        System.out.println("あなたの手札："+player.getHand().toString());
        System.out.println("相手の手札："+computerPlayer.getHand().toString());

        judge();
    }

    //display the current score of player and computer
    //display the discard pile sorted by suit and rank
    private void showScore() {
        System.out.println("勝利点 あなた"+player.getScore()+"：相手"+computerPlayer.getScore());
        System.out.println("今の捨札：");
        discardPile.display();
    }
}
