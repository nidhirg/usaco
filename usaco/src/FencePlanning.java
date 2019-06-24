import java.io.*;
import java.util.*;

//2019 Open Silver 3

public class FencePlanning {
	
	public static class Cow{
		int x, y, xMax, yMax, xMin, yMin, group, index;
		ArrayList<Cow> mooConnection = new ArrayList<Cow>();
		
		public Cow(int x, int y, int index) {
			this.x = x;
			this.y = y;
			xMin = x;
			xMax = x;
			yMin = y;
			yMax = y;
			this.index = index;
			group = index;
			mooConnection.add(this);
		}
		
		public void add(Cow c) {
			if(c.xMin < xMin) xMin = c.xMin;
			if(c.yMin < yMin) yMin = c.yMin;
			if(c.xMax > xMax) xMax = c.xMax;
			if(c.yMax > yMax) yMax = c.yMax;
			mooConnection.addAll(c.mooConnection);
			for(int i = 0; i < mooConnection.size(); i++) {
				Cow cow = mooConnection.get(i);
				cow.group = group;
				cow.xMin = xMin;
				cow.xMax = xMax;
				cow.yMin = yMin;
				cow.yMax = yMax;
				cow.mooConnection = mooConnection;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		String inpath = "fenceplan.in";
		String outpath = "fenceplan.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(prepath + inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(prepath+outpath)));
		StringTokenizer st;
		
		st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		Cow[] cows = new Cow[N];
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(f.readLine());
			cows[Integer.parseInt(st.nextToken())-1].add(cows[Integer.parseInt(st.nextToken())-1]);
		}
		
		ArrayList<Integer> usedGroups = new ArrayList<Integer>();
		int minP = 9999999;
		for(int i = 0; i < N; i++) {
			Cow cow = cows[cows[i].group];
			if(usedGroups.contains(cow.group)) {
				continue;
			}else {
				usedGroups.add(cow.group);
			}
			int P = 2*(cow.xMax - cow.xMin) + 2*(cow.yMax - cow.yMin);
			if(P < minP) minP = P;
		}
		
		out.println(minP);
		out.close();
		f.close();
	}
	
}
