package extra;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer {
    private List<Integer> history = new ArrayList<>();
    private Random rand = new Random();

    //calculate the most frequently played hand by the player
    public int play(List<Integer> playerHistory){
        int computerHand;

        if (!playerHistory.isEmpty() && rand.nextDouble() < 0.6) {
            int mostHand = getMostHand(playerHistory);
            computerHand = counterHand(mostHand);
        }else{
            computerHand = rand.nextInt(3); // 0～2のランダムな値を返す
        }

        //no same hands in 3 rounds
        if (history.size() >= 3) {
            int lastHand = history.get(history.size() - 1);
            if (history.get(history.size() - 2) == lastHand &&
                    history.get(history.size() - 3) == lastHand){
                do{
                    computerHand = rand.nextInt(3);
                }while (computerHand == lastHand);

            }
        }

        history.add(computerHand);
        return computerHand;

    }

    //counter the most frequently played hand by the player

    private int getMostHand(List<Integer> playerHistory){
        int[] count = new int[3];
        for (int hand : playerHistory) {
            count[hand]++;
        }
        int mostHand = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > count[mostHand]) {
                mostHand = i;
            }
        }
        return mostHand;
    }

    //get counter hand
    private int counterHand(int hand){
        return (hand + 2) % 3; // グー(0)に対してチョキ(1)、チョキ(1)に対してパー(2)、パー(2)に対してグー(0)
    }

    //display each bot's hand for debugging
    public List<Integer> getBotHand(){
        return history;
    }
}
