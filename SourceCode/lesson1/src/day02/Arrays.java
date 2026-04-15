package day02;

public class Arrays {
    //This is a sample of how to use arrays in Java.
    public static void main(String[] args) {
        // Declare and initialize an array of integers with 5 elements
        int[] numbers = new int[10];
        // Assign values to the array
        //here we give random values to the array using for loop
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100); // Assign a random number between 0 and 99
        }

        // Print the elements of the array
        System.out.println("The numbers in the array are:");
        for (int value : numbers) {
            System.out.print(value + " ");
        }

        // Declare and initialize an array of strings with 3 elements
        String[] names = {"Alice", "Bob", "Charlie"};

        // Print the elements of the string array
        System.out.println("\nThe names in the array are:");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i]+" ");
        }

        //use length property to get the length of the array
        System.out.println("\nThe length of the numbers array is: " + numbers.length);
        System.out.println("The length of the names array is: " + names.length);

        //now here is example of using methods to manipulate arrays
        //1- for each method
        System.out.println("\nUsing for-each loop to print numbers:");
        for (int number : numbers) {
            number=number+5; // This will not change the original array
            System.out.print(number+" ");
        }
        System.out.println(" ");
        System.out.println("The numbers in the array are:");
        for (int j : numbers) {
            System.out.print(j + " ");
        }

         //2- using Arrays class from java.util package
        System.out.println("\nUsing Arrays class to sort numbers:");
        java.util.Arrays.sort(numbers);
        for (int number : numbers) {
            System.out.print(number+" ");
        }

        //3- using Arrays class to convert array to string
        System.out.println("\nUsing Arrays class to convert array to string:");
        String numbersString = java.util.Arrays.toString(numbers);
        System.out.println(numbersString);

        //Then we show multidimensional arrays
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("\nUsing multi-dimensional array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //more than 2d array
        int[][][] cube = {
            {{1, 2}, {3, 4}},
            {{5, 6}, {7, 8}}
        };

        System.out.println("\nUsing 3D array:");
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    System.out.print(cube[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        //finally we show different methods in Arrays class
        //1-fill method
        System.out.println("\nUsing Arrays.fill method to fill an array with a specific value:");
        int[] filledArray = new int[5];
        java.util.Arrays.fill(filledArray, 42);
        for (int number : filledArray) {
            System.out.print(number + " ");
        }
        //2- binarySearch method
        System.out.println("\nUsing Arrays.binarySearch method to find the index of a specific value:");
        int index = java.util.Arrays.binarySearch(numbers, 30);
        if (index >= 0) {
            System.out.println("The index of 30 in the sorted array is: " + index);
        } else {
            System.out.println("30 is not found in the array.");
        }

        //3- equals method
        System.out.println("\nUsing Arrays.equals method to compare two arrays:(return true or false)");
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {4, 5, 6};
        System.out.println("array1 and array2 are equal: " + java.util.Arrays.equals(array1, array2));
        System.out.println("array1 and array3 are equal: " + java.util.Arrays.equals(array1, array3));



    }
}
