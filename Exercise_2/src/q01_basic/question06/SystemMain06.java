/*
* output example
* *---CREATE MEMBER DATA---
input id>>1
input password>>testPass
---SHOW MEMBER---
***MEMBER DATA***
id:1
password:testPass
name:Miura Manabu
age:28
rank:2
*****************
* *
* *output example (NumberFormatException)
* *---CREATE MEMBER DATA---
input id>>s
error!
java.lang.NumberFormatException: For input string: "s"
 at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
 at java.base/java.lang.Integer.parseInt(Integer.java:668)
 at java.base/java.lang.Integer.parseInt(Integer.java:786)
 at q01_basic.question06.ConsoleReader.inputNumber(ConsoleReader.java:34)
 at q01_basic.question06.SystemMain06.main(SystemMain06.java:45)


* **/
package q01_basic.question06;

import java.io.IOException;

public class SystemMain06 {

    public static void main(String[] args) {

        ConsoleReader cr = new ConsoleReader();
        int inputId = 0;
        String inputPassword = null;
        String name = "Miura Manabu";
        int age = 28;
        int rank = 2;

        System.out.println("---CREATE MEMBER DATA---");
        //TODO ここから実装する

        try {
            System.out.print("input id>>");
            inputId = cr.inputNumber();

            System.out.print("input password>>");
            inputPassword = cr.inputString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("error!");
            e.printStackTrace();
            return;
        }

        Member member = new Member(inputId, inputPassword, name, age, rank);
        System.out.println("---SHOW MEMBER---");
        member.showMember();

    }

}
