package usaco.practice;
import java.io.*;
import java.util.*;

//December 2015 Bronze 1

public class FencePainting {

	public static void main(String[] args) throws IOException {
		String inpath = "paint.in";
		String outpath = "paint.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[] fence = new int[100];
		for(int i = 0; i < 100; i++) {
			fence[i] = 0;
		}
		for(int i = a; i < b; i++) {
			fence[i] = 1;
		}
		for(int i = c; i < d; i++) {
			fence[i] = 1;
		}
		int length = 0;
		for(int i : fence) {
			if(i == 1) length++;
		}
		out.println(length);
		out.close();
		f.close();
	}
}
