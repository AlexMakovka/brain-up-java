import java.util.Arrays;

class Main {
    // Generate an array of 100 random integers between 0 and 99 and print it
    public static void main(String[] args) {
        int n = 100;
        int[] array = new int[n];
        // Fill the array with random integers
        for (int i=0; i < n; i++) {
            array[i] = (int) (Math.random() * 100);

        }
        // Print the array
        System.out.println(Arrays.toString(array));

        int min = array[0];
        int max = array[0];
        double avg = 0;
        double sum = 0;
        // Find the minimum and maximum values in the array
        for (int i = 0; i < n; i++){
            if (max < array[i])
                max = array[i];
            if (min > array[i])
                min = array[i];
            sum += array[i];
        }
        avg = sum / n;

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);  
        System.out.println("Avg: " + avg);

    }
}
