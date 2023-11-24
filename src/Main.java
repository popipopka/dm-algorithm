import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            insertionSort(arr);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void insertionSort(int[] arr) {
        int comparisons = 0;
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        try {
            PrintWriter writer = new PrintWriter(new File("output.txt"));
            for (int num : arr) {
                writer.print(num + " ");
            }
            writer.println();
            writer.println("Comparisons: " + comparisons);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}