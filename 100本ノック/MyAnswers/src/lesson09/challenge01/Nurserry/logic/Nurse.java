package lesson09.challenge01.Nurserry.logic;
// * 入力された出席番号の園児が存在しないときArrayIndexOutOfBoundsException
// * をcatchして「その番号の園児は出席してません。」と表示する
// * public void takeAttendance(NurserySchoolChild[] childs, int num)メソッドを
// * 保育士クラスに作成してください。
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

    public void takeAttendance(NurserySchoolChild[] childs, int num) {

       //ここに適切な処理を記述
         try {
              System.out.println(childs[num - 1].getName() + "は来てます。");
         } catch (ArrayIndexOutOfBoundsException e) {
              System.out.println("その番号の園児は出席してません。");
         }


    }
}
