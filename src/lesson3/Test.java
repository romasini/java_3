package lesson3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) throws IOException {
        File ff  = new File("123.txt");
        BufferedReader reader = new BufferedReader(new FileReader(ff));
        reader.readLine();

        DataInputStream dd = new DataInputStream(new FileInputStream(ff));
        dd.mark(10);
    }
}
