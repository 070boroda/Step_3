import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_17 {

    public static void main(String[] args) {

        int n = 0;
        int[] x = null;
        int result = 0;
        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            n = scan.nextInt();
            x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scan.nextInt();
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= n - 1; i++) {
            if ((n - 1) % i == 0) {
                boolean good = true;
                for (int j = i; j < n - 1; j++) {
                    if (x[j] != x[j - i]) {
                        good = false;
                        break;
                    }
                }
                if (good) {
                    result = i;
                    break;
                }
            }
        }

        try (FileWriter output = new FileWriter("output.txt")) {
            output.write(Integer.toString(result));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
