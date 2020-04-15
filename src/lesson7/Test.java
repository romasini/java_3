package lesson7;

public class Test {

    public static void main(String[] args) {
        int[][] x = new int[5][4];
        int[][] y = new int[5][4];
        System.out.println(x[3]);
        System.out.println(y[3]);
        System.out.println(x[3][3]);

        System.arraycopy(x,0, y,0, x.length);
        x[3][3] = 56;
        System.out.println(x[3]);
        System.out.println(y[3]);
        System.out.println(y[3][3]);
        }
    

}
