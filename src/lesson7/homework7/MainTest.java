package lesson7.homework7;

import lesson7.homework7.myJUnit.MyJUnit;
import lesson7.homework7.test.MyCalcTest;

import java.lang.reflect.InvocationTargetException;

public class MainTest {
    public static void main(String[] args) {
        try {
            MyJUnit.start(MyCalcTest.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }
}
