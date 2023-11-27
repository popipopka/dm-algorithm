public class InteroplationSearchEstimator extends SearchEstimator {
    public InteroplationSearchEstimator(int[] data) {
        super(data);
    }

    @Override
    void search(int elem) {
        int low = 0;
        int high = data.length - 1;

        while (low <= high && elem >= data[low] && elem <= data[high]) {
            // Используем формулу для интерполяции
            int pos = low + ((elem - data[low]) * (high - low) / (data[high] - data[low]));

            if (data[pos] == elem) {
                comparingCount++;
                System.out.println("Число сравнений: " + comparingCount);
                return;
            }

            if (data[pos] < elem) {
                comparingCount++;
                low = pos + 1;
            } else {
                comparingCount++;
                high = pos - 1;
            }
        }


        //Redudant:
        //System.out.println("Число сравнений: " + comparingCount);
        // Элемент не найден
    }
}
