package usaco.practice;
import java.io.*;
import java.util.*;

//2018 January Bronze 1

public class BlockedBillboardII {
	
	public static class Billboard{
		public int[] topRight = new int[2];
		public int[] topLeft = new int[2];
		public int[] bottomRight = new int[2];
		public int[] bottomLeft = new int[2];
		public int area;
		public Billboard(int x1, int y1, int x2, int y2) {
			bottomLeft[0] = x1;
			bottomLeft[1] = y1;
			bottomRight[0] = x2;
			bottomRight[1] = y1;
			topLeft[0] = x1;
			topLeft[1] = y2;
			topRight[0] = x2;
			topRight[1] = y2;
			area = (x2-x1) * (y2-y1);
		}
		public boolean contains(int[] x) {
			if(topLeft[0] <= x[0] && x[0] <= topRight[0] && bottomRight[1] <= x[1] && x[1] <= topRight[1]) {
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) throws IOException{
		String inpath = "billboard.in";
		String outpath = "billboard.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		Billboard lawnmower = new Billboard(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(f.readLine());
		Billboard grass = new Billboard(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		int area = 0;
		if(grass.contains(lawnmower.topRight) && grass.contains(lawnmower.topLeft) && grass.contains(lawnmower.bottomLeft) && grass.contains(lawnmower.bottomRight)) {
			area = 0;
		}
		else if(grass.contains(lawnmower.topRight) && grass.contains(lawnmower.topLeft)) {
			area = (lawnmower.bottomRight[0] - lawnmower.bottomLeft[0]) * (grass.bottomRight[1] - lawnmower.bottomRight[1]);
		}
		else if(grass.contains(lawnmower.topRight) && grass.contains(lawnmower.bottomRight)) {
			area = (grass.bottomLeft[0] - lawnmower.bottomLeft[0]) * (lawnmower.topRight[1] - lawnmower.bottomRight[1]);
		}
		else if(grass.contains(lawnmower.topLeft) && grass.contains(lawnmower.bottomLeft)) {
			area = (lawnmower.bottomRight[0] - grass.bottomRight[0]) * (lawnmower.topRight[1] - lawnmower.bottomRight[1]);
		}
		else if(grass.contains(lawnmower.bottomRight) && grass.contains(lawnmower.bottomLeft)) {
			area = (lawnmower.bottomRight[0] - lawnmower.bottomLeft[0]) * (lawnmower.topRight[1] - grass.topRight[1]);
		}
		else {
			area = lawnmower.area;
		}
		out.println(area);
		out.close();
		f.close();
	}
}
