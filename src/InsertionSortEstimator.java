public class InsertionSortEstimator extends Sort {
    protected InsertionSortEstimator(int[] data) {
        super(data);
    }

    @Override
    void run() {
        int comparisons = 0;
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                comparisons++;
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }
}
