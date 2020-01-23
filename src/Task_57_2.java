import java.awt.geom.Point2D;
import java.util.Scanner;
import java.util.Stack;
public class Task_57_2 {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int pigs = sc.nextInt() + 1, cost = sc.nextInt(), money = sc.nextInt();
            Stack<Point2D> points = new Stack<>();
            while (pigs != 0) {
                points.add(new Point2D.Double(sc.nextInt(), sc.nextInt()));
                pigs--;
            }
            Point2D prov = points.pop();
            System.out.println(points);
            System.out.println(prov);
            double smin = money + 1;
            for (Point2D fpoint : points) {
                double stmp = 0;
                for (Point2D spoint : points) {
                    stmp += fpoint.distance(spoint);
                    if (stmp > smin) break;
                }
                stmp += fpoint.distance(prov);
                smin = Math.min(stmp, smin);
            }
            if (smin * cost <= money) System.out.print("YES");
            else System.out.print("NO");
}
}
