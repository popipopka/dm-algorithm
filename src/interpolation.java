package org.example;

public class interpolation
{
    public static int interpolationSearch(int[] arr, int x, int countComparisons) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && x >= arr[low] && x <= arr[high]) {
            // Используем формулу для интерполяции
            int pos = low + ((x - arr[low]) * (high - low) / (arr[high] - arr[low]));

            if (arr[pos] == x) {
                countComparisons++;
                System.out.println("Число сравнений: " + countComparisons);
                return pos;
            }

            if (arr[pos] < x) {
                countComparisons++;
                low = pos + 1;
            } else {
                countComparisons++;
                high = pos - 1;
            }
        }

        System.out.println("Число сравнений: " + countComparisons);
        return -1; // Элемент не найден
    }

    public static void main( String[] args )
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 6;

        int result = interpolationSearch(arr, x, 0);

        if (result != -1) {
            System.out.println("Элемент " + x + " найден по индексу " + result);
        } else {
            System.out.println("Элемент " + x + " не найден в массиве");
        }
    }
}
