package usaco.practice;
import java.io.*;
import java.util.*;

//2019 January Bronze 1

public class ShellGame {
	public static int[] shells = new int[3];
	public static int[] guess;
	public static int[] swap1;
	public static int[] swap2;
	public static void main(String[] args) throws IOException{
		String inpath = "shell.in";
		String outpath = "shell.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		int N = Integer.parseInt(f.readLine());
		guess = new int[N];
		swap1 = new int[N];
		swap2 = new int[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			swap1[i] = Integer.parseInt(st.nextToken()) - 1;
			swap2[i] = Integer.parseInt(st.nextToken()) - 1;
			guess[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		int mostRightGuesses = 0;
		for(int i = 0; i < 3; i++) {
			reset();
			shells[i] = 1;
			int rightGuesses = 0;
			for(int swap = 0; swap < N; swap++) {
				swap(swap);
				if(shells[guess[swap]] == 1) {
					rightGuesses++;
				}
			}
			if(rightGuesses > mostRightGuesses) {
				mostRightGuesses = rightGuesses;
			}
		}
		out.println(mostRightGuesses+"");
		out.close();
		f.close();
	}
	
	public static void reset() {
		shells[0] = 0;
		shells[1] = 0;
		shells[2] = 0;
	}
	
	public static void swap(int i) {
		int swop1 = swap1[i];
		int swop2 = swap2[i];
		int temp = shells[swop1];
		shells[swop1] = shells[swop2];
		shells[swop2] = temp;
	}
}
