package lesson7;

import java.lang.reflect.Field;

public class PrivateClass {
    public String getmPrivateString() {
        return mPrivateString;
    }

    public void setmPrivateString(String mPrivateString) {
        this.mPrivateString = mPrivateString;
    }

    private String mPrivateString = null;
    private int anInt = 5;

    public PrivateClass(String mPrivateString) throws NoSuchFieldException {
        this.mPrivateString=mPrivateString;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        PrivateClass privateClass = new PrivateClass("security");

        Field privateStringField = PrivateClass.class.getDeclaredField("mPrivateString");
        privateStringField.setAccessible(true);
        String getSecurity = privateClass.getmPrivateString();
        String fieldValue = (String) privateStringField.get(privateClass);

        //
        Field privateIntField = PrivateClass.class.getDeclaredField("anInt");
        privateStringField.setAccessible(true);
        int seven = (Integer) privateIntField.get(privateClass) + 2;
        System.out.println(seven);
    }

}
