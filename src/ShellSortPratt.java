import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShellSortPratt extends Sort {
    List<Integer> pratt = new ArrayList<>();

    protected ShellSortPratt(int[] data) {
        super(data);
        //fillPratt();
    }

    @Override
    void run() {
        for (int gap : pratt) {
            for (int i = gap; i < data.length; i++) {
                int temp = data[i];
                int j = i;

                //boolean flag = true;
                while (j >= gap && data[j - gap] > temp) {
                    //flag = false;
                    data[j] = data[j - gap];
                    j -= gap;
                    comparingCount++;
                    System.out.println(Arrays.toString(data));
                    System.out.println(comparingCount);
                    if (j < gap) {
                        comparingCount--;
                        break;
                    }
                }
                comparingCount++;
                //if(flag) comparingCount++;

                data[j] = temp;
                System.out.println(Arrays.toString(data));
                System.out.println(comparingCount);
            }
        }
    }

    public void fillPratt() {
        int number;

        for (int i = 0; i < data.length / 2 + 1; i++) {
            for (int j = 0; j < data.length / 2 + 1; j++) {
                number = (int) ((int) Math.pow(2, i) * Math.pow(3, j));

                if (number >= data.length) continue;

                pratt.add(number);
            }
        }

        pratt.sort(Collections.reverseOrder());
    }

    public void fillLog() {
        int number = 1;

        for (int i = 0; i < Math.log(data.length) / Math.log(2); i++) {
            pratt.add(number);
            number = 2 * number + 1;
        }
        pratt.sort(Collections.reverseOrder());
    }
}
