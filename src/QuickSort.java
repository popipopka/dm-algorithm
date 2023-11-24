public class QuickSort extends Sort{

    protected QuickSort(int[] data) {
        super(data);
    }

    @Override
    void run() {
        sort(0, data.length - 1);
    }

    private void sort(int left, int right) {
        if (left < right && left >= 0) {
            int pivot = partition(left, right);
            sort(left, pivot - 1);
            sort(pivot + 1, right);
        }
    }

    private void swap(int indexA, int indexB) {
        int temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    private int partition(int leftBorder, int rightBorder) {
        int pivot = data[leftBorder];

        int i = leftBorder;
        int j = rightBorder;

        while (i < j){
            while (j >= leftBorder && data[j] >= pivot) {
                j--;
                comparingCount++;
                if (i >= j) {
                    comparingCount--;
                    break;
                }
            }
            comparingCount++;

            while (i <= rightBorder && data[i] <= pivot) {
                i++;
                comparingCount++;
                if (i >= j) {
                    comparingCount--;
                    break;
                }
            }
            comparingCount++;


            swap(i, j);
        }
        swap(i, j);
        swap(leftBorder, j);

        return j;
    }
}


