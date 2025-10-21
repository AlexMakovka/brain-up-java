import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for number of rows and columns
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();           

        // Initialize a 2D array with the specified dimensions
        int[][] array = new int[rows][cols];

        // Fill the array with random integers 
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                array[i][j] = (int)(Math.random() * 31);
            }
        }

        // Print the original array
        System.out.println("Original Array:");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Enter any number from 0 to 30: ");
        int n = scanner.nextInt();

        // Remove all occurrences of n from the array
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (array[i][j] != n){
                    list.add(array[i][j]);
                }
            }
        }

        // Convert the list back to a 2D array
        int newSize = list.size();
        int[][] newArray = new int[newSize / cols + (newSize % cols == 0 ? 0 : 1)][cols];
        for (int i = 0; i < newSize; i++){
            newArray[i / cols][i % cols] = list.get(i);
        }
        // Print the modified array
        System.out.println("Modified Array:");
        for (int i = 0; i < newArray.length; i++){
            for (int j = 0; j < cols; j++){
                if (i * cols + j < newSize) {
                    System.out.print(newArray[i][j] + " ");
                } else {
                    System.out.print("  "); // Print spaces for empty cells
                }
            }
            System.out.println();
        }

        scanner.close();

    }
}
