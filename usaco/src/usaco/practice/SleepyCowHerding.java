package usaco.practice;
import java.io.*;
import java.util.*;

//2019 February Silver 1

public class SleepyCowHerding {
	public static void main(String[] args) throws IOException{
		String inpath = "herding.in";
		String outpath = "herding.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		
		int N = Integer.parseInt(f.readLine());
		ArrayList<Integer> cows = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			cows.add(Integer.parseInt(f.readLine()));
		}
		Collections.sort(cows);
		int minDiff = 1000000000;
		int minLeftSpace = 0;
		int minRightSpace = 0;
		int leftSpace = 0;
		int rightSpace = 0;
		for(int i = 1; i < N; i++) {
			int diff = cows.get(i) - cows.get(i-1) - 1;
			if(diff < minDiff&&diff!=0) {
				minDiff = diff;
			}
			if(i != 1) {
				rightSpace+=diff;
				if(diff!=0) minRightSpace++;//
			}
			if(i != cows.size()-1) {
				leftSpace+=diff;
				if(diff!=0) minLeftSpace++;//
			}
		}
		if(minDiff > N-2) out.println(N-1);
		else if(minRightSpace < N - 2 || minLeftSpace < N - 2) out.println(Math.min(minRightSpace, minLeftSpace));
		else out.println(N-2);
		out.println(Math.max(leftSpace, rightSpace));
		out.close();
		f.close();
	}
}
