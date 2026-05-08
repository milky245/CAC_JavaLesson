package Day0427;

import java.util.ArrayList;
import java.util.List;

public class Sample2601 {
    public static void main(String[] args) {
        // ArrayListの生成
//        List<Integer> list = new ArrayList<>();
//
//        // 要素の追加
//        list.add(1);
//        list.add(3);
//        list.add(5);
//
//        // 要素の取得
//        System.out.println("数値は" + list.get(0) + "です。");

        List<Phone2601> phone2601s = getPhones();

        for (Phone2601 phone2601 : phone2601s) {
            System.out.println("出力：");
            System.out.println(phone2601.getFee());
            System.out.println(phone2601.getData());
        }

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(1);

        System.out.println(list.get(1));
    }
    public static List<Phone2601> getPhones() {

        List<Phone2601> phone2601s = new ArrayList<>();

        phone2601s.add(new Phone2601(1000, 20.3));
        phone2601s.add(new Phone2601(2000, 50.9));
        phone2601s.add(new Phone2601(3000, 60.1));

        return phone2601s;

    }
}
