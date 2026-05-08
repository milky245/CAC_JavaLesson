/*
* ---SHOW ALL MEMBERS---
***MEMBER DATA***
id:1
password:Passw0rd
name:Miura Manabu
age:28
rank:2
*****************
***MEMBER DATA***
id:2
password:aaaAAA
name:Sato Kensuke
age:43
rank:1
*****************
**/
package q01_basic.question04;

public class SystemMain04 {

	public static void main(String[] args) {

		Member[] members = new Member[2];
		//TODO ここから実装する
		System.out.println("---SHOW ALL MEMBERS---");
		members[0] = new Member(1, "Passw0rd", "Miura Manabu", 28, 2);
		members[1] = new Member(2, "aaaAAA", "Sato Kensuke", 43, 1);
		MemberManager.showAllMembers(members);

	}

}
