package lesson09.challenge03.Nurserry.logic;

public class Nurse {
    private String name;

    public Nurse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void divide(int cakes, int childs) {


        //ここに適切な処理を記述
        //問題6 finallyブロック
        //問題5で作成したdivideを改変し、園児がいてもいなくても
        //必ず最後に「ケーキの分配が終わりました。」と表示する
        //ようにしてください。
        try {
            if (childs == 0) {
                System.out.println("\nケーキを食べる園児がいません。");
            } else {
                int cakesPerChild = cakes / childs;
                System.out.println("\n1人あたりのケーキの数は" + cakesPerChild + "個です。");
            }
        } finally {
            System.out.println("\nケーキの分配が終わりました。");
        }



    }
}
