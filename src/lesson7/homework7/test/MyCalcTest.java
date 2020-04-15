package lesson7.homework7.test;

import lesson7.homework7.MyCalc;
import lesson7.homework7.myJUnit.*;

public class MyCalcTest {

    private static MyCalc calc;

    @BeforeSuite
    public void init(){
        calc = new MyCalc();
        System.out.println("before");
    }

    @Test(priority = 2)
    public void testAdd(){
        MyJUnit.assertEquals(3, calc.add(1,2));
    }

    @Test(priority = 4)
    public void testSub(){
        MyJUnit.assertEquals(3, calc.sub(5,2));
    }

    @Test
    public void testMul(){
        MyJUnit.assertEquals(10, calc.mul(5,2));
    }

    @Test(priority = 9)
    public void testDiv(){
        MyJUnit.assertEquals(5, calc.div(10,2));
    }

    @AfterSuite
    public void after(){
        calc = null;
        System.out.println("after");
    }

}
