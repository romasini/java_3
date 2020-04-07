package lesson4.p7_volatile;

public class Example_1 {
    static volatile int x = 0;//наличие volatile означает, что расчет переменной не очуществляется в КЭШ процессора

    public static void main(String[] args) {
        //x = x + 1;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 400; i++) {
                //x++;//не атомарные операция, volatile не поможет
                x += 1;
                System.out.println("write: " + x);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 400; i++) {
                //x--;
                x -= 1;
                System.out.println("read: " + x);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main: " + x);
    }

}
