package lesson7;

/**
 * @author alekseenkoyuri1989@gmail.com
 * Created on 11.04.2019
 */

public class TestReflectImpl
{
    public TestReflectImpl()
    {
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private int number;
    private String name = "default";

    public TestReflectImpl(int number, String name)
    {
        this.number = number;
        this.name = name;
    }

    private void printData(){
        System.out.println(number + name);
    }

}

