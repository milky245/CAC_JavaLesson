package model;

import java.util.*;

public class DiscardPile {
    private List<Card> discardedCards;

    public DiscardPile() {
        this.discardedCards = new ArrayList<>();
    }
    //add a card to the discard pile
    public void add(Card card) {
        discardedCards.add(card);
    }

    //display with the suit + rank of the card
    public void display() {
        //DiscardPile排序
        //先按 suit 分组
        //每组按 rank 升序
        // 1. 按花色分组
        Map<String, List<Card>> map = new HashMap<>();

        for (Card c : discardedCards) {
            map.putIfAbsent(c.getSuit(), new ArrayList<>());
            map.get(c.getSuit()).add(c);
        }

        // 2. 指定花色顺序（很重要，不然HashMap是乱的）
        String[] suitsOrder = {"ハート", "ダイヤ", "クラブ", "スペード"};

        // 3. 遍历每个花色
        for (String suit : suitsOrder) {
            List<Card> list = map.get(suit);
            if (list == null) continue;

            // 4. 按 rank 排序
            list.sort(Comparator.comparingInt(Card::getRank));

            // 5. 输出
            System.out.print(suit + ": ");
            for (Card c : list) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
