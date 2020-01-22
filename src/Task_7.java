import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_7 {

    public static void main(String[] args) {

        String first = null;
        String second = null;
        String third = null;

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            first = scan.next();
            second = scan.next();
            third = scan.next();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        try (FileWriter output = new FileWriter("output.txt")) {
            output.write(findMax(first, findMax(second, third)));
        } catch (IOException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }

    public static String findMax(String one, String two) {

        if (one.length() > two.length()) {
            return one;
        } else if (one.length() < two.length()) {
            return two;
        }
        for (int i = 0; i < one.length(); ++i) {
            if (one.charAt(i) > two.charAt(i))
                return one;
            if (one.charAt(i) < two.charAt(i))
                return two;
        }
        return one;
    }
}
