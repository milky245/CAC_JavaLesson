package q02_advanced.question01;
/*
* output example
* *===会員情報を表示します===
Member [id=1, password=Passw0rd, name=Miura Manabu, age=28, rank=2, coupons=[Coupon [id=1, dis
countRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特
典]]]
******************
Member [id=2, password=aaaAAA, name=Sato Kensuke, age=43, rank=1, coupons=[Coupon [id=1, disco
untRate=0.5, description=最初の特典], Coupon [id=2, discountRate=0.25, description=今月の特典]]]
******************
* **/
public class SystemMain01 {

	public static void main(String[] args) {

		System.out.println("===会員情報を表示します===");
		//TODO ここから実装する
		Member member1 = new Member(1, "Passw0rd", "Miura Manabu", 28, 2);
		member1.showMember();
		//System.out.println("******************");
		Member member2 = new Member(2, "aaaAAA", "Sato Kensuke", 43, 1);
		member2.showMember();
		//System.out.println("******************");

	}

}
