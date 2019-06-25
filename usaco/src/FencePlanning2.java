import java.io.*;
import java.util.*;

//2019 Open Silver 3
//doesnt get sample case lmao

public class FencePlanning2 {
	public static class Cow{
		int x, y, index;
		ArrayList<Cow> mooConnection = new ArrayList<Cow>();
		boolean visited = false;
		boolean main = false;
		
		public Cow(int x, int y, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
			mooConnection.add(this);
		}
	}
	public static void main(String[] args) throws IOException{
		String inpath = "fenceplan.in";
		String outpath = "fenceplan.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
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
			int cow1 = Integer.parseInt(st.nextToken())-1;
			int cow2 = Integer.parseInt(st.nextToken())-1;
			cows[cow1].mooConnection.addAll(cows[cow2].mooConnection);
			cows[cow2].mooConnection.addAll(cows[cow1].mooConnection);
		}
		
		int minP = 999999;
		for(int i = 0; i < N; i++) {
			Cow cow = cows[i];
			if(!cow.visited) {
				int xMin = cow.x;
				int xMax = cow.x;
				int yMin = cow.y;
				int yMax = cow.y;
				for(int j = 0; j < cow.mooConnection.size(); j++) {
					Cow c = cow.mooConnection.get(j);
					if(c.x < xMin) xMin = c.x;
					if(c.y < yMin) yMin = c.y;
					if(c.x > xMax) xMax = c.x;
					if(c.y > yMax) yMax = c.y;
					c.visited = true;
				}
				int P = 2*(xMax - xMin) + 2*(yMax - yMin);
				if(P < minP) minP = P;
			}
		}
		
		out.println(minP);
		out.close();
		f.close();
	}
	
	
}
