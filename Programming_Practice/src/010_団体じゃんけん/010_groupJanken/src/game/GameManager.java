package game;
import model.PCTeam;
import model.PlayerTeam;
import model.RoundRecord;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private PlayerTeam playerTeam;
    private PCTeam pcTeam;
    private List<RoundRecord> records;

    public GameManager() {
        // 初始化双方队伍
        // 初始化比赛记录
        playerTeam = new PlayerTeam();
        pcTeam = new PCTeam();
        records = new ArrayList<>();
    }

    public void startGame() {
        // 显示开始信息
        // 循环进行比赛
        // 判断胜负
        // 显示最终结果
        // 显示比赛记录
        System.out.println("【じゃんけん開始】");
        while (!isGameOver()) {
            playRound();
        }
        showWinner();
        showRecords();
    }

    private void playRound() {
        // 进行一局猜拳
        // 获取双方出拳
        // 判断胜负
        // 平局则重赛（不记录）
        // 非平局：
        //   保存记录
        //   失败方换人

    }

    private boolean isGameOver() {
        // 判断是否击败对方大将
    }

    private void showWinner() {
        // 显示最终胜利队伍
    }

    private void showRecords() {
        // 按表格形式输出比赛记录
    }
}
