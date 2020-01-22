import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Task_57 {

    public static void main(String[] args) {

        int n = 0;
        double tempDist = 0.0;
        double minDist = 0.0;
        int[] x = null;
        int[] y = null;
        int priceC = 0;
        int summP = 0;
        int xNet = 0, yNet = 0;
        boolean more_then_min = false;
        String result = null;

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            n = scan.nextInt();
            priceC = scan.nextInt();
            summP = scan.nextInt();
            x = new int[n];
            y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scan.nextInt();
                y[i] = scan.nextInt();
            }
            xNet = scan.nextInt();
            yNet = scan.nextInt();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        minDist = summP / priceC;

        for (int i = 0; i < n; i++) {
            tempDist = 0;
            more_then_min = false;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    tempDist += Math.sqrt(Math.pow(Math.abs(x[j] - x[i]), 2) + Math.pow(Math.abs(y[j] - y[i]), 2));
                    if (tempDist > minDist) {
                        //more_then_min = true;
                        break;
                    }
                }
            }
            tempDist += Math.sqrt(Math.pow(Math.abs(xNet - x[i]), 2) + Math.pow(Math.abs(yNet - y[i]), 2));
            if (tempDist <= minDist) {
                more_then_min = true;
                break;
            }
        }

        result = more_then_min ? "YES" : "NO";

        try (FileWriter output = new FileWriter("output.txt")) {
            output.write(result);
        } catch (IOException | NumberFormatException e1) {
            e1.printStackTrace();
        }
    }
}
