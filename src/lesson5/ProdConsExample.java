package lesson5;

import java.util.concurrent.ArrayBlockingQueue;

public class ProdConsExample {
    static class Producer {
        private ArrayBlockingQueue<String> a;

        public Producer(ArrayBlockingQueue<String> a) {
            this.a = a;
        }

        public void put(String x) {
            try {
                System.out.println("producer add: " + x);
                a.put(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer {
        private ArrayBlockingQueue<String> a;
        int i = 0;
        public Consumer(ArrayBlockingQueue<String> a) {

            this.a = a;
        }

        public String get() {
            try {
                String str = a.take();
                System.out.println("consumer get: " + str);
                return str;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        public int getSize(){
            this.i++;
            System.out.println(i);
            return a.size();
        }
    }

    public static void main(String[] args) {
        final ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10);
        new Thread(() -> {
            Producer p = new Producer(abq);
            for (int i = 0; i < 10; i++) {
                try {
                    p.put("Producer 1:" + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            Producer p = new Producer(abq);
            for (int i = 0; i < 10; i++) {
                try {
                    p.put("Producer 2: " + i);
                    p.put("Producer 2: " + (i+1000));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            Consumer c = new Consumer(abq);
            for (int i = 0; i < 100; i++) {
                try {
                    c.getSize();
                    c.get();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
