package model;

public abstract class Team {

    protected String teamName;
    protected String[] positions;
    protected int currentIndex;

    public Team(String teamName) {
        // 初始化队名
        // 初始化 position
        // currentIndex = 0
        this.teamName = teamName;
        this.positions = new String[]{"先锋", "次锋", "中坚", "副将", "大将"};
        this.currentIndex = 0;
    }

    public String getCurrentPosition() {
        // 返回当前上场位置
        return positions[currentIndex];
    }

    public boolean moveNext() {
        // 切换到下一位成员
        // 如果已是大将则返回 false
        if (currentIndex < positions.length - 1) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public boolean isTaisho() {
        // 当前是否是大将
        return currentIndex == positions.length - 1;
    }

    public String getTeamName() {
        // 返回队名
        return teamName;
    }
}
