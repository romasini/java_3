package lesson1.homework1;

/**
 * Задача:
 * a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
 *      поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
 * d. Сделать метод getWeight() который высчитывает вес коробки, зная
 *      количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
 *      которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае
 *      (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
 *      коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
 *      соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
 * g. Не забываем про метод добавления фрукта в коробку.
 */

import lesson1.homework1.fruitbox.Apple;
import lesson1.homework1.fruitbox.Box;
import lesson1.homework1.fruitbox.Orange;

public class FruitBoxTest {
    public static void main(String[] args) {

        Box<Apple> box_1 = new Box<>();
        box_1.addFruit(new Apple());
        box_1.addFruit(new Apple());
        box_1.addFruit(new Apple());
        box_1.addFruit(new Apple());

        System.out.println(String.format("В коробке box_1 %.1f кг яблок",box_1.getWeight()));

        Box<Apple> box_2 = new Box<>();
        box_2.addFruit(new Apple());
        box_2.addFruit(new Apple());
        box_2.addFruit(new Apple());
        box_2.addFruit(new Apple());

        System.out.println(String.format("В коробке box_2 %.1f кг яблок",box_2.getWeight()));

        Box<Orange> box_3 = new Box<>();
        box_3.addFruit(new Orange());
        box_3.addFruit(new Orange());
        box_3.addFruit(new Orange());
        box_3.addFruit(new Orange());

        System.out.println(String.format("В коробке box_3 %.1f кг апельсинов",box_3.getWeight()));

        if(box_1.compare(box_2)){
            System.out.println("Коробки box_1 и box_2 равны по весу");
        }else{
            System.out.println("Коробки box_1 и box_2 не равны по весу");
        }

        if(box_1.compare(box_3)){
            System.out.println("Коробки box_1 и box_3 равны по весу");
        }else{
            System.out.println("Коробки box_1 и box_3 не равны по весу");
        }

        System.out.println("Переместим яблоки из box_2 в box_1");
        box_2.transferToBox(box_1);
        System.out.println(String.format("В коробке box_1 %.1f кг яблок",box_1.getWeight()));
        System.out.println(String.format("В коробке box_2 %.1f кг яблок",box_2.getWeight()));

    }
}
