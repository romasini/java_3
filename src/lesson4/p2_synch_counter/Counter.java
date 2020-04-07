package lesson4.p2_synch_counter;

public class Counter {
    int c;

    public int value() {
        return c;
    }

    public Counter() {
        c = 0;
    }

    public void inc() {
        c++;
    }

    public void dec() { // ACC_synchronized
        c--;
    }

}
