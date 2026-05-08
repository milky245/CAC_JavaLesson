package model;

public class RoundRecord {

    private String playerPosition;
    private String pcPosition;
    private Hand playerHand;
    private Hand pcHand;
    private boolean playerWin;

    public RoundRecord(
            String playerPosition,
            String pcPosition,
            Hand playerHand,
            Hand pcHand,
            boolean playerWin
    ) {
        // 初始化记录
    }

    public String getPlayerPosition() {
        // 返回玩家位置（带*）
    }

    public String getPcPosition() {
        // 返回电脑位置（带*）
    }

    public Hand getPlayerHand() {
        // 返回玩家手势
    }

    public Hand getPcHand() {
        // 返回电脑手势
    }

    public boolean isPlayerWin() {
        // 玩家是否胜利
    }

    @Override
    public String toString() {
        // 返回表格一行数据
    }
}
