package Example;
public class Counter {
    int count=0;
    public Counter() {
    }
    public int getCount() {
        count++;
        return this.count;
    }
    public void setCount(int counter) {
        this.count = count;
    }
}