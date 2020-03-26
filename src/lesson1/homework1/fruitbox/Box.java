package lesson1.homework1.fruitbox;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    private ArrayList<T> fruitList = new ArrayList<>();
    private static final double MAX_WEIGHT = 50f;

    public void addFruit(T fruit){
        if(getWeight() + fruit.getFruitWeight() > MAX_WEIGHT) {
            System.out.println("Превышен вес коробки");
            return;
        }
        fruitList.add(fruit);
    }

    private void addAllFruits(ArrayList<T> fruitAL){
        this.fruitList.addAll(fruitAL);
    }

    public double getWeight(){
        if (fruitList.size()==0) {
            return 0;
        }else {
            return  fruitList.get(0).getFruitWeight() * fruitList.size();//исходим из того, что вес фрукта постоянный, иначе - forech
        }
    }

    public boolean compare(Box anotherBox) {
        double diff = this.getWeight() - anotherBox.getWeight();
        return (Math.abs(diff)<0.0001) ? true : false;
    }

    public void transferToBox(Box<T> anotherBox){

        if (this.getWeight() + anotherBox.getWeight() > MAX_WEIGHT){
            System.out.println("Нельзя пересыпать фрукты в другую коробку. Превышен максимальный вес");
            return;
        }
        anotherBox.addAllFruits(this.fruitList);
        this.fruitList.clear();
    }




}
