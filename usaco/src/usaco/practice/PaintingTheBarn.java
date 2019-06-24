package usaco.practice;
import java.io.*;
import java.util.*;

//2019 February Silver 2
public class PaintingTheBarn {
	public static void main(String[] args) throws IOException{
		String inpath = "paintbarn.in";
		String outpath = "paintbarn.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int kCoats = 0;
		int[][] barn = new int[1000][1000];
		for(int y = 0; y < 1000; y++) {
			for(int x = 0; x < 1000; x++) {
				barn[y][x] = 0;
			}
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int y = y1; y < y2; y++) {
				for(int x = x1; x < x2; x++) {
					int k = ++barn[y][x];
					if(k == K){
						kCoats++;
					}
					else if(k == K+1) {
						kCoats--;
					}
				}
			}
		}
		out.println(kCoats+"");
		out.close();
		f.close();
	}
}
