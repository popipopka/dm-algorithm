public abstract class SearchEstimator {
    protected int[] data;
    protected int comparingCount;

    public SearchEstimator(int[] data) {
        this.data = data;
    }

    abstract void search(int elem);

    public int[] getData() {
        return data;
    }

    public int getComparingCount() {
        return comparingCount;
    }
}
