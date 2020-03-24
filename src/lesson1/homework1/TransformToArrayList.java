package lesson1.homework1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Задача:
 * Написать метод, который преобразует массив в ArrayList
 */

public class TransformToArrayList {

    public static void main(String[] args) {
        String[] arr_1 = {"aa","bb","cc"};
        System.out.println(toArrayList(arr_1));

        Integer[] arr_2 = {1,2,3};
        System.out.println(toArrayList(arr_2));
    }

    private static <T> ArrayList<T> toArrayList(T[] arr){
        ArrayList<T> newAL = new ArrayList<>(arr.length);

        //Collections.addAll(newAL, arr);//простой вариант

        for (int i = 0; i < arr.length; i++) {
            newAL.add(arr[i]);
        }

        return newAL;
    }
}
