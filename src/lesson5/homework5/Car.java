package lesson5.homework5;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable{
    private static int CARS_COUNT = 0;//количество машин
    private Race race; //трасса
    private int speed; //скорость
    private String name;
    private CountDownLatch prepareCDL;
    private CountDownLatch finishCDL;

    public String getName(){
        return name;
    }

    public Car(Race race, int speed, CountDownLatch prepareCDL, CountDownLatch finishCDL){
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник № "+ CARS_COUNT;
        this.finishCDL = finishCDL;
        this.prepareCDL = prepareCDL;
    }

    @Override
    public void run(){
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500+(int)(Math.random()*800));
            System.out.println(this.name + " готов");
            prepareCDL.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            prepareCDL.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i< race.getStages().size(); i++){
            race.getStages().get(i).go(this);
        }

        finishCDL.countDown();

    }

    public int getSpeed() {
        return speed;
    }
}
