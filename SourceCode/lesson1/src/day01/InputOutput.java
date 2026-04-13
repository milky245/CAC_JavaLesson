package day01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputOutput {
    //Scanner demo
        public static void main(String[] args) {
            //Scanner is a class in java.util package that is used to get user input, and it is found in the java.util package
            //To use Scanner, you need to import it first
            //import java.util.Scanner;
            //Then you can create an instance of Scanner and use its methods to get user input

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Hello, " + name + "!");

            //You can also get other types of input, such as int, double, etc.
            System.out.print("Enter your height: ");
            double height = scanner.nextDouble();
            System.out.println("Your height is " + height + " cm.");

            //Here is example of using hasNext() method
            System.out.print("Enter your student number: ");
            if (scanner.hasNextInt()) {
                int studentNumber = scanner.nextInt();
                System.out.println("Your student number is " + studentNumber + ".");
            } else {
                System.out.println("That's not a valid student number.");
            }

            //You can also use BufferedReader for input, but it is less commonly used than Scanner
            //BufferedReader example:
            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
            System.out.print("Enter your age: ");
            try {
                int age = Integer.parseInt(reader.readLine());
                System.out.println("You are " + age + " years old.");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }

            //Here we can use more simple way to get input
            System.out.print("Enter your favorite color: ");
            BufferedReader reader2=new BufferedReader(new InputStreamReader(System.in));
            try {
                String color = reader2.readLine();
                System.out.println("You like " + color + " the best.");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }


            //You can use hasNextxxx() to check if the next input is the type you want before actually getting the input
            Scanner scan = new Scanner(System.in);
            int i = 0;
            float f = 0.0f;
            System.out.print("输入整数：");
            if (scan.hasNextInt()) {
                // 判断输入的是否是整数
                i = scan.nextInt();
                // 接收整数
                System.out.println("整数数据：" + i);
            } else {
                // 输入错误的信息
                System.out.println("输入的不是整数！");
            }
            //Show the difference between Scanner and BufferedReader
            //Scanner is easier to use and has more methods for getting different types of input,
            // but it can be slower than BufferedReader for large inputs.
            // BufferedReader is faster for reading large inputs, but
            // it requires more code to get different types of input and does not have as many methods as Scanner.

            //finally, here is an example of using Scanner and BufferedReader to get the average of multiple double values from the user
            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Enter the number of values you want to average: ");
            double sum = 0.0;
            int count = 0;
            while (scanner2.hasNextDouble()) {
                double value = scanner2.nextDouble();
                sum += value;
                count++;
            }
            System.out.println("The average is: " + (sum / count));

        }
}
