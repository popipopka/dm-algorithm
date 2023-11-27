public class InsertionSortEstimator extends Sort {
    protected InsertionSortEstimator(int[] data) {
        super(data);
    }

    @Override
    void run() {
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                comparingCount++;
                data[j + 1] = data[j];
                j--;
                if (j >= 0) {
                    comparingCount--;
                    break;
                }
            }
            comparingCount++;
            data[j + 1] = key;
        }
    }
}
