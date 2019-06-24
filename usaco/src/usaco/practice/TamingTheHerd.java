package usaco.practice;
import java.io.*;
import java.util.*;

//February 2018 Bronze 3

public class TamingTheHerd {
	public static void main(String[] args) throws IOException{
		String inpath = "taming.in";
		String outpath = "taming.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		int N = Integer.parseInt(f.readLine());
		StringTokenizer st = new StringTokenizer(f.readLine());
		int[] board = new int[N];
		for(int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
		boolean valid = true;
		if(board[0] != 0 && board[0] != -1) {
			valid = false;
		}else {
			board[0] = 0;
		}
		for(int i = N-1; i >= 0; i--) {
			if(!valid) break;
			int value = -1;
			value = board[i];
			int index = i;
			while(value > 0) {
				if(board[index-1] != -1 && board[index-1] != value - 1) {
					valid = false;
					break;
				}else {
					board[index-1] = value - 1;
				}
				index--;
				value--;
			}
		}
		if(!valid) {
			out.println(-1+"");
			out.close();
			f.close();
		}else {
			int breakouts = 0;
			int possible = 0;
			for(int i = 0; i < N; i++) {
				if(board[i] == 0) {
					breakouts++;
				}
				if(board[i] == -1) {
					possible++;
				}
			}
			out.println(breakouts + " " + (breakouts+possible));
			out.close();
			f.close();
		}
	}
}
