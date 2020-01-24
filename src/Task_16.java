import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_16 {

    public static void main(String[] args) {

        int n =0;

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            n = scan.nextInt();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        try (FileWriter output = new FileWriter("output.txt")) {
            output.write(Integer.toString(get_count(n+1,n)));
        } catch (IOException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }

    public static int get_count(int prev_level, int n) {
        if (0 == n)
            return 1;

        int count = 0;
        for (int level = 1; level < prev_level; ++level) {
            if ((n - level) < 0)
                break;
            count += get_count(level, n - level);
        }
        return count;
    }
}
