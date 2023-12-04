public class Inversion {
    public static int run(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) break;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) sum += 1;
            }
        }
        return sum;
    }
}
