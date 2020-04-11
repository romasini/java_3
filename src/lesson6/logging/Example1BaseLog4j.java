package lesson6.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Example1BaseLog4j {
    // Levels:
    // OFF
    // SEVERE
    // WARNING
    // INFO
    // CONFIG
    // FINE
    // FINER
    // FINEST
    // ALL

    private static final Logger LOGGER = LogManager.getLogger(Example1BaseLog4j.class);

    public static void main(String[] args) {
        Example1BaseLog4j ex1 = new Example1BaseLog4j();
        ex1.tryToDivBy0();
    }

    public void tryToDivBy0() {
        try{
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            LOGGER.error("Ошибка деления на ноль", e);
        }
    }
}
