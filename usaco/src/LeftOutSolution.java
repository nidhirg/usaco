import java.io.*;
import java.util.*;

//2019 Open Silver 1
//solution based on the solution on the website, probably not the most efficient method, but easier for me cuz i copy pasted a bunch of code from my solution
//as of rn only gets the first two cases, but doesnt time out which is good. need to debug

public class LeftOutSolution {
	static int[][] switches;
	public static void main(String[] args) throws IOException{
		String inpath = "leftout.in";
		String outpath = "leftout.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		
		int N = Integer.parseInt(f.readLine());
		switches = new int[N][N];
		
		for(int row = 0; row < N; row++) {
			String roow = f.readLine();
			for(int col = 0; col < N; col++) {
				if(roow.charAt(col)=='R') switches[row][col] = 1;
				else switches[row][col] = 0;
			}
		}
		
		for(int i = 1; i < N; i++) {
			if(switches[0][i]==1) {
				flip('C', i, N);
			}
			if(switches[i][0]==1) {
				flip('R', i, N);
			}
		}
		
		boolean found = false;
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(switches[row][col] == 1) {
					if(row != N-1 && switches[row+1][col]==1) {
						out.println((1)+" "+(col+1));
					}
					else if(col != N-1 && switches[row][col+1] == 1) {
						out.println((row+1)+" "+(1));
					}
					else {
						out.println((row+1)+" "+(col+1));
					}
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
}
