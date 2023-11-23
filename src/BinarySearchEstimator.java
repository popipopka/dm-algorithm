public class BinarySearchEstimator extends SearchEstimator {
    public BinarySearchEstimator(int[] data) {
        super(data);
    }

    @Override
        //Не поддерживает поиска отсутствующих элементов
    void search(int elem) {
        binarySearchRecursion(data, 0, data.length - 1, elem);
    }

    //Рекурсивная вспомогательная функция
    void binarySearchRecursion(int[] data, int startIndex, int endIndex, int elem) {
        int pivot = (startIndex + endIndex) / 2;

        //Перед сравнением (на самом деле, сравнение одно,
        // а не два, т.к. реализация жабы не дает сделать так, как хочет Попов)
        comparingCount++;
        if (elem > data[pivot]) {
            binarySearchRecursion(data, pivot + 1, endIndex, elem);
        } else if (elem < data[pivot]) {
            binarySearchRecursion(data, startIndex, pivot - 1, elem);
        }
        // Элемент успешно найден, поиск окончен
    }
}
