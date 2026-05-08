/*
output example
* ***MEMBER DATA***
Sato Kensuke is a non-member
*****************
***MEMBER DATA***
id:1
password:Passw0rd
name:Miura Manabu
age:28
rank:2
*****************
---BUY ITEM---
Sato Kensuke purchased the item at a fixed price
Miura Manabu purchased the item at 50% off */
package q01_basic.question05;

public class SystemMain05 {

	public static void main(String[] args) {

		AbstMember[] members = new AbstMember[2];
		//TODO ここから実装する
		members[0] = new NonMember("Sato Kensuke");
		members[1] = new Member(1, "Passw0rd", "Miura Manabu", 28, 2);

		System.out.println("---SHOW ALL MEMBERS---");
		members[0].showMember();
		members[1].showMember();
		System.out.println("---BUY ITEM---");
		for (AbstMember member : members) {
			member.buyItem();
		}

	}

}
