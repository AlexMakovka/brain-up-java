import java.util.Arrays;

class Main {
    // Generate an array of 100 random integers between 0 and 99 and print it
    public static void main(String[] args) {
        
        // Create an array of 100 integers
        int n = 100;
        int[] array = new int[n];

        // Fill the array with random integers
        for (int i=0; i < n; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        // Print the array
        System.out.println("Original array:");
        System.out.println(Arrays.toString(array));
        
        // Initialize min, max, sum
        int min = array[0];
        int max = array[0];
        double avg = 0;
        double sum = 0;
        
        // Calculate min, max, avg
        for (int i = 0; i < n; i++){
            if (max < array[i])
                max = array[i];
            if (min > array[i])
                min = array[i];
            sum += array[i];
        }
        avg = sum / n;

        // Print results
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);  
        System.out.println("Avg: " + avg);

        // List to store results
        java.util.List<String[]> results = new java.util.ArrayList<>();

        // --------------------------------------------Bubble sort implementation--------------------------------------------
        // The principle: we repeatedly go through the array, the largest element "pops up".
        // Difficulty: O(n²) time complexity in the average and worst case.
        // Advantage: simple to implement, stable sort.
        // Disadvantage: inefficient on large lists.

        // Copy original array for sorting
        int[] originalArray = Arrays.copyOf(array, array.length);
        
        // Measure time taken to sort the array
        long start = System.nanoTime();

        // Bubble sort
        for (int i = 0; i < n; i++) {
            // Track if a swap was made
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++){
                // Swap if the element found is greater than the next element
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        } 
        
        // End time measurement
        long end = System.nanoTime(); 
        double duration = (end - start) / 1_000_000.0; 
        
        // Print sorted array and time
        System.out.println("\n Bubble sort. Sorted array:");
        System.out.println(Arrays.toString(array));
        System.out.println("Bubble sort time: " + duration + " ms");
        // Store result
        results.add(new String[]{"Bubble Sort", duration + " ms", "O(n²)"});

// --------------------------------------------Selection sort implementation--------------------------------------------
// The principle: we repeatedly find the minimum element from the unsorted part and put it at the beginning.
// Difficulty: O(n²) time complexity in the average and worst case.
// Advantage: simple to implement, fewer swaps than Bubble Sort.
// Disadvantage: inefficient on large lists, not stable.

        // Copy original array for sorting
        array = Arrays.copyOf(originalArray, originalArray.length);

        // Measure time taken to sort the array
        start = System.nanoTime();
        
        // Selection sort
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        // End time measurement
        end = System.nanoTime(); 
        duration = (end - start) / 1_000_000.0; 

        // Print sorted array and time
        System.out.println("\n Selection sort. Sorted array:");
        System.out.println(Arrays.toString(array));
        System.out.println("Selection sort time: " + duration + " ms");
        // Store result 
        results.add(new String[]{"Selection Sort", duration + " ms", "O(n²)"});

// --------------------------------------------Insertion sort implementation--------------------------------------------
// The principle: builds the sorted array one element at a time by taking the next element 
// and inserting it into its correct position in the already sorted part of the array.
// Difficulty: O(n²) time complexity in the average and worst case.
// Advantage: simple to implement, efficient for small or partially sorted arrays, stable.
// Disadvantage: inefficient on large, unsorted lists.

        // Copy original array for sorting
        array = Arrays.copyOf(originalArray, originalArray.length);

        // Measure time taken to sort the array
        start = System.nanoTime();
        
        // Insertion sort
        for (int i = 1; i < n; i++) {
            int key = array [i]; // Current element to be inserted
            int j = i - 1; // Index of the last element in the sorted part
            
            // Move elements of the sorted part that are greater than key
            while (j >= 0 && array[j] > key ) {
                array[j + 1] = array[j];
                j--; //j = j - 1;
            }
            array[j + 1] = key; // Insert the key at its correct position
        }

        // End time measurement
        end = System.nanoTime(); 
        duration = (end - start) / 1_000_000.0; 

        // Print sorted array and time
        System.out.println("\n Insertion sort. Sorted array:");
        System.out.println(Arrays.toString(array));
        System.out.println("Insertion sort time: " + duration + " ms");
        // Store result
        results.add(new String[]{"Insertion Sort", duration + " ms", "O(n²)"});

// --------------------------------------------Quick sort implementation--------------------------------------------
// The principle: we select a pivot element, partition the array into two parts — elements less than the pivot
// and elements greater than or equal to it — and then recursively sort each part.
// Difficulty: O(n log n) on average, O(n²) in the worst case (when pivot is chosen poorly).
// Advantage: very fast in practice, often the default sorting method in many libraries.
// Disadvantage: not stable, worst-case performance can be bad without good pivot selection.

        // Copy original array for sorting
        array = Arrays.copyOf(originalArray, originalArray.length);

        // Measure time taken to sort the array
        start = System.nanoTime();

        // Quick sort
        int[] stackStart = new int[array.length];
        int[] stackEnd = new int[array.length];
        int top = -1;

        // Initial values
        stackStart[++top] = 0;
        stackEnd[top] = n - 1;

        while (top >= 0) {
            int endIndex = stackEnd[top];
            int startIndex = stackStart[top--];

            int pivot = array[startIndex + (endIndex - startIndex) / 2];
            int i = startIndex;
            int j = endIndex;

            while (i <= j) {
                while (array[i] < pivot) {
                    i++;
                }
                while (array[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    // Swap
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }

            // Push subarrays onto stack
            if (startIndex < j) {
                stackStart[++top] = startIndex;
                stackEnd[top] = j;
            }
            if (i < endIndex) {
                stackStart[++top] = i;
                stackEnd[top] = endIndex;
            }
        }

        // End time measurement
        end = System.nanoTime(); 
        duration = (end - start) / 1_000_000.0; 

        // Print sorted array and time
        System.out.println("\n Quick sort. Sorted array:");
        System.out.println(Arrays.toString(array));
        System.out.println("Quick sort time: " + duration + " ms");
        // Store result
        results.add(new String[]{"Quick Sort", duration + " ms", "O(n log n)"});

// --------------------------------------------Bucket sort implementation--------------------------------------------
// The principle: we divide the range of input values into several "buckets" (intervals) and 
// distribute the elements into these buckets according to their value. 
// Each bucket is then sorted individually (often using Insertion Sort or another simple algorithm), 
// and finally, all buckets are concatenated back together in order.
// Difficulty: O(n + k) on average (where k is the number of buckets), 
// but can degrade to O(n²) in the worst case (if all elements fall into one bucket).
// Advantage: very efficient for uniformly distributed data and integers in a limited range, 
// can be faster than O(n log n) sorting algorithms.
// Disadvantage: requires additional memory for buckets and may perform poorly if data is not evenly distributed or the range is too large.

        // Copy original array for sorting
        array = Arrays.copyOf(originalArray, originalArray.length);

        // Measure time taken to sort the array
        start = System.nanoTime();

        // Bucket sort
        int numberOfBuckets = 10;
        int[][] buckets = new int[numberOfBuckets][n];
        int[] bucketSizes = new int[numberOfBuckets];

        // Distribute input array values into buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = array[i] / 10; // Assuming values are between 0 and 99
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = array[i];
        }

        // Sort each bucket and concatenate
        int index = 0;
        for (int i = 0; i < numberOfBuckets; i++) {
            // Simple insertion sort for each bucket
            for (int j = 1; j < bucketSizes[i]; j++) {
                int key = buckets[i][j];
                int k = j - 1;
                while (k >= 0 && buckets[i][k] > key) {
                    buckets[i][k + 1] = buckets[i][k];
                    k--;
                }
                buckets[i][k + 1] = key;
            }
            // Concatenate sorted buckets back into the original array
            for (int j = 0; j < bucketSizes[i]; j++) {
                array[index++] = buckets[i][j];
            }
        }

        // End time measurement
        end = System.nanoTime(); 
        duration = (end - start) / 1_000_000.0; 

        // Print sorted array and time
        System.out.println("\n Bucket sort. Sorted array:");
        System.out.println(Arrays.toString(array));
        System.out.println("Bucket sort time: " + duration + " ms");
        // Store result
        results.add(new String[]{"Bucket Sort", duration + " ms", "O(n + k)"});

    
        // Table of results
        System.out.println("\nSorting Algorithm Performance:");
        System.out.printf("%-15s %-15s %-15s%n", "Algorithm", "Time", "Complexity");
        for (String[] result : results) {
            System.out.printf("%-15s %-15s %-15s%n", result[0], result[1], result[2]);
        }   
    }

}
