package Day03;

public class ForSample {
    public static void main(String[] args) {
        // This is a sample of how to use for loops in Java.
        // We will print the numbers from 1 to 10 using a for loop.

        for (int i = 1; i <= 5; i++) {
            System.out.println("第"+i+"回目の外部ループです。 ");
            System.out.println("i= "+ i);
            for (int j = 1; j <= 4; j++) {
                System.out.println("      第"+j+"回目の内部ループです。 ");
                System.out.println("      j= "+ j);
            }
        }
    }
}
