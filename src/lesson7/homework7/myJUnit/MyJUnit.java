package lesson7.homework7.myJUnit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyJUnit {

    public static void start(Class testClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = testClass.getDeclaredMethods();
        int countBefore = 0;
        int countAfter = 0;
        Method methodBefore = null;
        Method methodAfter = null;
        List<Method> testMethods= new ArrayList<>();
        for (Method method:methods) {
            if(method.isAnnotationPresent(BeforeSuite.class)) {
                countBefore++;
                methodBefore = method;
            }
            if(method.isAnnotationPresent(AfterSuite.class)) {
                countAfter++;
                methodAfter = method;
            }
            if(method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }
        if (countBefore>1) throw new RuntimeException("Слишком много BeforeSuite");
        if (countAfter>1) throw new RuntimeException("Слишком много AfterSuite");
        if (testMethods.size() <1) throw new RuntimeException("Нет тестов");
        
        testMethods = testMethods.stream().sorted(Comparator.comparingInt(method -> method.getAnnotation(Test.class).priority())).collect(Collectors.toList());
        Object testObj = testClass.newInstance();

        if (countBefore>0) methodBefore.invoke(testObj);

        for (Method testMethod: testMethods) {
            System.out.print("Тест " + testMethod.getName()+" приоритет " + testMethod.getAnnotation(Test.class).priority()+ " :");
            testMethod.invoke(testObj);
            System.out.println();
        }

        if (countAfter>0) methodAfter.invoke(testObj);
    }

    public static void assertEquals(long exp, long calc){
        if (exp == calc){
            System.out.print("Тест пройден");
        }else {
            System.out.print("Тест не пройден");
        }
    }

}
