import java.io.*;
import java.util.*;

//2019 Open Silver 2

public class CowSteepleChase {
	public static class Line implements Comparable<Line>{
		int index;
		long x1, x2, y1, y2,y3;
		int intersections = 0;
		
		public Line(long x1, long y1, long x2, long y2, int index) {
			this.index = index;
			if(x1 < x2) {
				this.x1 = x1;
				this.y1 = y1;
				this.x2 = x2;
				this.y2 = y2;
			}else {
				this.x1 = x2;
				this.y1 = y2;
				this.x2 = x1;
				this.y2 = y1;
			}
		}
		
		public int compareTo(Line l) {
            return (int)(x1 - l.x1);
        }
		
		public boolean intersects(Line l) {
			double m1 = (y2-y1+0.0)/(x2-x1);
			double m2 = (l.y2-l.y1+0.0)/(l.x2-l.x1);
			double intersectionX = (l.y1 + m1*x1 - m2*l.x1 - y1)/(m1-m2);
			if(x1 <= intersectionX && intersectionX <= x2 && l.x1 < intersectionX && intersectionX <= l.x2) {
				return true;
			}
			return false;
		}
	}
	public static void main(String[] args) throws IOException{
		String inpath = "cowjump.in";
		String outpath = "cowjump.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st;
				
		int N = Integer.parseInt(f.readLine());
		Line[] lines = new Line[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			lines[i] = new Line(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), i);
		}
		Arrays.sort(lines);
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		boolean confirmed = false;
		for(int i1 = 0; i1 < N; i1++) {
			Line line1 = lines[i1];
			for(int i2 = i1 + 1; i2 < N; i2++) {
				Line line2 = lines[i2];
				
				if(line2.x1 > line1.x2) {
					break;
				}
				
				if(line1.intersects(line2)) {
					line1.intersections++;
					line2.intersections++;
				}
				if(line1.intersections == 1) {
					indices.add(line1.index);
				}
				if(line2.intersections == 1) {
					indices.add(line2.index);
				}
				if(line1.intersections > 1) {
					confirmed = true;
					out.println(line1.index + 1 + "");
					out.close();
					f.close();
					break;
				}
				if(line2.intersections > 1) {
					confirmed = true;
					out.println(line2.index + 1 + "");
					out.close();
					f.close();
					break;
				}
			}
			if(confirmed) {
				break;
			}
		}
		
		if(!confirmed) {
			Collections.sort(indices);
			out.println(indices.get(0) + 1 + "");
			out.close();
			f.close();
		}
	}
}
