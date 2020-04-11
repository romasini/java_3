package lesson5.homework5;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args){
        CountDownLatch prepareCDL = new CountDownLatch(CARS_COUNT);//потоки машин + main поток
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        //prepareCDL.countDown();

        Race race = new Race(
                new Road(60),
                new Tunnel((int)CARS_COUNT/2),
                new Road(40)
        );
        CountDownLatch finishCDL = new CountDownLatch(CARS_COUNT);
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random()*10), prepareCDL, finishCDL);
        }
        for (int i = 0; i < cars.length; i++){
            new Thread(cars[i]).start();
        }

        try {
            prepareCDL.await();//ждем подготовку
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            finishCDL.await();//ждем, когда все прибудут на финиш
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
