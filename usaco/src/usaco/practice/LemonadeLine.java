package usaco.practice;
//2018 Open Silver 2

import java.io.*;
import java.util.*;

public class LemonadeLine {
	public static void main(String[] args) throws IOException{
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		BufferedReader f = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		int N = Integer.parseInt(f.readLine());
		StringTokenizer st = new StringTokenizer(f.readLine());
		int[] cows = new int[N];
		for(int x = 0; x<N; x++) {
			cows[x] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cows);
		int[] dCows = new int[N];
		for(int x=0;x<N;x++) {
			dCows[N-1-x] = cows[x];
		}
		int max = N;
		for(int x = 0; x < N; x++) {
			if(dCows[x]<x) {
				max = x;
				break;
			}
		}
		out.println(max);
		out.close();
		f.close();
	}
}
