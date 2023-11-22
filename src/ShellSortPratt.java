import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShellSortPratt extends Sort {
    List<Integer> pratt = new ArrayList<>();

    protected ShellSortPratt(int[] data) {
        super(data);
        fillPratt();
    }

    @Override
    void run() {
        for (int gap : pratt) {
            for (int i = gap; i < data.length; i++) {
                int temp = data[i];
                int j = i;

                if(j >= gap && data[j - gap] > temp) {
                    while (j >= gap && data[j - gap] > temp) {
                        data[j] = data[j - gap];
                        j -= gap;
                        comparingCount++;
                    }
                } else comparingCount++;

                data[j] = temp;
            }
        }
    }

    private void fillPratt() {
        int number;

        for (int i = 0; i < data.length / 2 + 1; i++) {
            for (int j = 0; j < data.length / 2 + 1; j++) {
                number = (int) ((int) Math.pow(2, i) * Math.pow(3, j));

                if(number >= data.length) continue;

                pratt.add(number);
            }
        }

        pratt.sort(Collections.reverseOrder());
    }
}
