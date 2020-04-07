package lesson4.p11_interesting_things;

public class ThreadTerminatedTest {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
            }
        });
        t.start();
        Thread.State newState = t.getState();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.State newState2 = t.getState();
            System.out.println(t.getState());
            t.join();
            Thread.State newState3 = t.getState();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
