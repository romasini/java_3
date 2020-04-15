package lesson7;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ClassIsTrue {
    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);
        Field modifierField = Field.class.getDeclaredField("modifiers");
        modifierField.setAccessible(true);
        modifierField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }

    public static void main(String[] args) throws Exception {
        setFinalStatic(Boolean.class.getField("FALSE"),true);
        System.out.format("ВСЕ у нас %s", 2==5);
        System.out.println();
        System.out.format("ВСЕ у нас %s", 5==5);

    }
}
