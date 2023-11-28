import java.util.Arrays;

public class ShakerSort {
    public static final String SWAP_COLOR = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    static private void printArray(int[] arr) {
        printArray(arr, -1, -1);
    }

    static private void printArray(int[] arr, int num1, int num2) {
        System.out.print("[");
        String color;
        for (int i = 0; i < arr.length; i++) {
            if (i == num1 || i == num2)
                color = SWAP_COLOR;
            else
                color = ANSI_RESET;
            System.out.print(color + arr[i] + " " + ANSI_RESET);
        }
        System.out.println("]");

    }

    static public int shakerSort(int[] arr) {
        int comparisons = 0;
        int left = 0;
        int right = arr.length - 1;
        int temp;
        printArray(arr);
        while (left < right) {
            boolean isChanged = false;
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    isChanged = true;
                    comparisons++;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    System.out.println(Arrays.toString(arr));
                    System.out.println(comparisons);
                    //printArray(arr, i, i + 1);
                } else {
                    comparisons++;
                    //System.out.println(Arrays.toString(arr));
                    System.out.println(comparisons);
                }
            }
            if (!isChanged) {
                break;
            }
            isChanged = false;
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i - 1] > arr[i]) {
                    isChanged = true;
                    comparisons++;
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    System.out.println(Arrays.toString(arr));
                    System.out.println(comparisons);
                    //printArray(arr, i - 1, i);
                } else {
                    comparisons++;
                    //System.out.println(Arrays.toString(arr));
                    System.out.println(comparisons);
                }
            }
            if (!isChanged) {
                break;
            }
            left++;
        }
        //printArray(arr);
        return comparisons;
    }
}
