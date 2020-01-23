import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_57 {

    public static int pow(int x){
        return x*x;
    }

    public static void main(String[] args) {

        int n = 0;
        double tempDist ;
        double minDist ;
        int[] x = null;
        int[] y = null;
        int priceC = 0;
        long sumP = 0;
        int xNet = 0, yNet = 0;
        boolean more_then_min = false;
        String result = null;

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            Scanner scan = new Scanner(in);
            n = scan.nextInt();
            priceC = scan.nextInt();
            sumP = scan.nextInt();
            x = new int[n];
            y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scan.nextInt();
                y[i] = scan.nextInt();
            }
            xNet = scan.nextInt();
            yNet = scan.nextInt();
        } catch (IOException e) {
            e.printStackTrace();
        }

        minDist = sumP / priceC;

        for (int i = 0; i < n; i++) {
            tempDist = 0;
            more_then_min = false;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    tempDist += Math.sqrt(pow(Math.abs(x[j] - x[i])) + pow(Math.abs(y[j] - y[i])));
                    if (tempDist > minDist) {
                        break;
                    }
                }
            }
            tempDist += Math.sqrt(pow(Math.abs(xNet - x[i])) + pow(Math.abs(yNet - y[i])));
            if (tempDist <= minDist) {
                more_then_min = true;
                break;
            }
        }

        result = more_then_min ? "YES" : "NO";

        try (FileWriter output = new FileWriter("output.txt")) {
            output.write(result);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
