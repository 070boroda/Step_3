import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_175 {

    public static void main(String[] args) {

        int h;
        int m;
        StringBuilder str = new StringBuilder();
        int result;
        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            while (scan.hasNext()) {
                str.append(scan.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        h = Integer.parseInt(str.substring(0, 2));
        m = Integer.parseInt(str.substring(3, 5));

        if (h < 10) {
            result = 20;
        } else if (h < 17) {
            result = 24;
        } else if (h < 20) {
            result = 24 + 5;
        } else {
            result = 24 + 10;
        }
        result = result * 60 - (h * 60 + m);

        try (FileWriter output = new FileWriter("output.txt")) {
            output.write(Integer.toString(result));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
