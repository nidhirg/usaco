import java.io.*;
import java.util.*;

//2019 Open Silver 2

public class CowSteepleChaseWeird {
    static class Line implements Comparable<Line> {
        int orderNumber;
        int intersections = 0;
        long x1, y1;
        long x2, y2;
        long ymin, ymax;

        public Line(long a, long b, long c, long d, int z) {
            x1 = a;
            y1 = b;
            x2 = c;
            y2 = d;
            orderNumber = z;
            ymin = Math.min(y1, y2);
            ymax = Math.max(y1, y2);
        }

        public int compareTo(Line l) {
            return (int)(x1 - l.x1);
        }
    }

    //global variables
    static ArrayList<Line> lines = new ArrayList();

    //method
    static boolean intersect(Line a1, Line a2) {

        if (a2.ymax < a1.ymin) return false;
        else if (a2.ymin > a1.ymax) return false;
        else return true;

    }

    static boolean debug = false;
    public static void main(String[] args) throws IOException {

        //take input initialize data
        String inpath = "cowjump.in";
        if (debug) inpath = "";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        for (int z = 0; z < N; z++) {

            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), d = in.nextInt();
            if (a > c) {    //SWITCHES VARIABLES SUCH THAT POINT WITH LOWER X1 GOES FIRST
                int temp = a;
                a = c;
                c = temp;

                temp = b;
                b = d;
                d = temp;
            }

            lines.add(new Line(a,b,c,d,z+1));
        }
        Collections.sort(lines);
        boolean found = false;
        int num = -1;
        int min = Integer.MAX_VALUE;
        int maxInter = 0;
        for (int z = 0; z < N; z++) {

            Line temp1 = lines.get(z);
            for (int a = z+1; a < N; a++) {
                Line temp2 = lines.get(a);
                if (temp2.x1 > temp1.x2) break;
                else if (intersect(temp1, temp2)) {
                    temp1.intersections++;
                    if (temp1.intersections > 1) {
                        maxInter = Math.max(maxInter, temp1.intersections);
                    }
                    if (maxInter == temp1.intersections) {
                    }
                }



            }
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("cowjump.out"));

        if (found) {
            out.write(num+"");
            if (debug) System.out.println(num);
        }
        else {
            for (Line s: lines) {
                if (s.intersections > 0) {
                    out.write(s.orderNumber + "");
                    if (debug) System.out.println(num);
                    found = true;
                    break;
                }
            }
            if (!found) {
                out.write("-1");
                if (debug) System.out.println(num);
            }

        }
        out.close();
    }


}
