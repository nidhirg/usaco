package usaco.practice;
import java.io.*;
import java.util.*;

//2018 January Bronze 2

public class Lifeguards {
	public static boolean[] openTimes = new boolean[1000];
	
	public static void main(String[] args) throws IOException{
		String inpath = "lifeguards.in";
		String outpath = "lifeguards.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st;
		int N = Integer.parseInt(f.readLine());
		int[][] times = new int[N][2];
		reset();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}
		int min = 0;
		for(int removed = 0; removed < N; removed++) {
			int index = 0;
			while(index < N) {
				if(index == removed) {
					index++;
				}else {
					for(int i = times[index][0]; i < times[index][1]; i++) {
						openTimes[i] = true;
					}
					index++;
				}
			}
			int tempMin = 0;
			for(boolean b : openTimes) {
				if(b) {
					tempMin++;
				}
			}
			if(tempMin > min) {
				min = tempMin;
			}
			reset();
		}
		out.println(min);
		out.close();
		f.close();
	}
	
	public static void reset() {
		for(int i = 0; i < 1000; i++) {
			openTimes[i] = false;
		}
	}
}
