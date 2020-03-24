package lesson1.homework1;

import java.util.Arrays;

/**
 * Задача:
 * Написать метод, который меняет два элемента массива местами.
 * (массив может быть любого ссылочного типа);
 */

public class ChangeArray {

    public static void main(String[] args) {
        String[] arr_1 = {"1c","2c","3c","4c"};
        System.out.println("Массив строк " + Arrays.toString(arr_1));
        changeElements(arr_1, 0, 3);
        System.out.println("Массив строк " + Arrays.toString(arr_1));

        Integer[] arr_2 = {1,2,3,4};
        System.out.println("Массив строк " + Arrays.toString(arr_2));
        changeElements(arr_2, 1, 2);
        System.out.println("Массив строк " + Arrays.toString(arr_2));
    }

    private static <T> void changeElements(T[] arr, int index1, int index2){
        if (index1==index2 ||
                index1 >= arr.length ||
                index2 >= arr.length ||
                index1<0||
                index2<0) return;

        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
