package day01;

public class Operators {
        public static void main(String[] args) {
            int a = 23;
            int b = 7;
            int c = a + b; //加算
            int d = a - b; //減算
            int e = a * b; //乗算
            int f = a / b; //除算
            int g = a % b; //剰余

            System.out.println("a + b = " + c);
            System.out.println("a - b = " + d);
            System.out.println("a * b = " + e);
            System.out.println("a / b = " + f);
            System.out.println("a % b = " + g);

            //example of num++ and ++num
            int num = 5;
            System.out.println("now number is " + num); //5
            System.out.println("num++ is " + num++); //5, but num becomes 6 after this line
            System.out.println("now number is " + num); //6
            System.out.println("++num is " + ++num); //7, num becomes 7 before this line

            //example of num1+num2, num1-num2, num1*num2, num1/num2, num1%num2 in println
            int num1 = 15;
            int num2 = 4;
            System.out.println("num1 is " + num1+", and num2 is " + num2); //15
            System.out.println("num1 + num2 = " + (num1 + num2)); //19
            System.out.println("num1 - num2 = " + (num1 - num2)); //11
            System.out.println("num1 * num2 = " + (num1 * num2)); //60
            System.out.println("num1 / num2 = " + (num1 / num2)); //3, because it's integer division
            System.out.println("num1 % num2 = " + (num1 % num2)); //3

        }
}
