package usaco.practice;

import java.io.*;
import java.util.*;

//February 2018 Bronze 2

public class Hoofball {

	public static void main(String[] args) throws IOException {
		String inpath = "hoofball.in";
		String outpath = "hoofball.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		int N = Integer.parseInt(f.readLine());
		StringTokenizer st = new StringTokenizer(f.readLine());
		int[] distances = new int[N];
		for (int i = 0; i < N; i++) {
			distances[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(distances);
		int index = 1;
		int balls = 1;
		int right = 1001;
		while (index < N - 1) {
			int left = distances[index] - distances[index - 1];
			right = distances[index + 1] - distances[index];
			if (left < right) {
				balls++;
			}
			index++;
		}
		int minBalls = balls;
		index = N - 2;
		balls = 1;
		right = 1001;
		while (index > 0) {
			int left = distances[index] - distances[index - 1];
			right = distances[index + 1] - distances[index];
			if (left > right) {
				balls++;
			}
			index--;
		}
		if(balls < minBalls) {
			minBalls = balls;
		}
		out.println(minBalls + "");
		out.close();
		f.close();
	}

}
