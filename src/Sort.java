public abstract class Sort {
    protected int[] data;
    protected int comparingCount = 0;

    protected Sort(int[] data) {
        this.data = data;
    }

    abstract void run();

    public int getComparingCount() {
        return comparingCount;
    }

    public int[] getData() {
        return data;
    }
}
