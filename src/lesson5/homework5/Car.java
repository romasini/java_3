package lesson5.homework5;

public class Car implements Runnable{
    private static int CARS_COUNT;//количество машин
    private Race race; //трасса
    private int speed; //скорость
    private String name;

    public String getName(){
        return name;
    }

    public Car(Race race, int speed){
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник № "+ CARS_COUNT;
    }

    @Override
    public void run(){
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500+(int)(Math.random()*800));
            System.out.println(this.name + " готов");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i< race.getStages().size(); i++){
            race.getStages().get(i).go(this);
        }
    }

    public int getSpeed() {
        return speed;
    }
}