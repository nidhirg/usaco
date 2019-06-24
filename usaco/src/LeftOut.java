import java.io.*;
import java.util.*;

//2019 Open Silver 1

public class LeftOut {
	static int[][] switches;
	public static void main(String[] args) throws IOException{
		String inpath = "leftout.in";
		String outpath = "leftout.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		
		int N = Integer.parseInt(f.readLine());
		switches = new int[N][N];
		
		int sum = 0;
		for(int row = 0; row < N; row++) {
			String roow = f.readLine();
			for(int col = 0; col < N; col++) {
				if(roow.charAt(col)=='R') switches[row][col] = 0;
				else switches[row][col] = 1;
				sum += switches[row][col];
			}
		}
		
		while(sum > 1) {
			for(int i = 0; i < N; i++) {
				if(sum('R',i,N)>N/2) {
					sum+=flip('R',i,N);
				}
			}
			for(int i = 0; i < N; i++) {
				if(sum('C',i,N)>N/2) {
					sum+=flip('C',i,N);
				}
			}
		}
		
		boolean found = false;
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(switches[row][col] == 1) {
					out.println((row+1)+" "+(col+1));
					out.close();
					f.close();
					found = true;
					break;
				}
			}
			if(found) break;
		}
		
	}
	
	static int flip(char which, int num, int N) {
		int swaps = 0;
		if(which == 'R') {
			for(int i = 0; i < N; i++) {
				swaps += switches[num][i];
				switches[num][i] = (switches[num][i] + 1)%2;
			}
		}else {
			for(int i = 0; i < N; i++) {
				swaps += switches[i][num];
				switches[i][num] = (switches[i][num] + 1)%2;
			}
		}
		return N - 2*swaps;
	}
	
	static int sum(char which, int num, int N) {
		int swaps = 0;
		if(which == 'R') {
			for(int i = 0; i < N; i++) {
				swaps += switches[num][i];
			}
		}else {
			for(int i = 0; i < N; i++) {
				swaps += switches[i][num];
			}
		}
		return swaps;
	}

}
