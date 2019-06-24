package usaco.practice;
//2018 Open Bronze 1

import java.io.*;
import java.util.*;

public class teamtictactoebad {
	public static int checkWin(char a, char b, char one, char two, char three) {
		if(one != a && one != b) {
			return 0;
		}
		if(two != a && two != b) {
			return 0;
		}
		if(three != a && three != b) {
			return 0;
		}
		if(three==two&&two==one&&one==three) {
			return 0;
		}
		return 1;
	}
	
	public static int checkWin(char a, char one, char two, char three) {
		if(one != a) {
			return 0;
		}
		if(two != a) {
			return 0;
		}
		if(three != a) {
			return 0;
		}
		
		return 1;
	}
	
	public static void main(String[] args) throws IOException{
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		String inpath = "tttt.in";
		String outpath = "tttt.out";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		char[][] board = new char[3][3];
		String s = f.readLine();
		board[0][0] = s.charAt(0);
		board[1][0] = s.charAt(1);
		board[2][0] = s.charAt(2);
		s = f.readLine();
		board[0][1] = s.charAt(0);
		board[1][1] = s.charAt(1);
		board[2][1] = s.charAt(2);
		s = f.readLine();
		board[0][2] = s.charAt(0);
		board[1][2] = s.charAt(1);
		board[2][2] = s.charAt(2);
		int singleWins = 0;
		int pairWins = 0;
		for(int i = 64; i<=91; i++) {
			char a = (char) i;
			singleWins+=checkWin(a,board[0][0],board[1][1],board[2][2]);
			singleWins+=checkWin(a,board[2][0],board[1][1],board[0][2]);
			for(int x = 0; x<3; x++) {
				singleWins += checkWin(a,board[0][x],board[1][x], board[2][x]);
				singleWins += checkWin(a,board[x][0],board[x][1], board[x][2]);
			}
		}
		for(int o = 64; o<=91; o++) {
		for(int i = o+1; i<=91; i++) {
			char a = (char) i;
			char b = (char) o;
			pairWins+=checkWin(a,b,board[0][0],board[1][1],board[2][2]);
			pairWins+=checkWin(a,b,board[2][0],board[1][1],board[0][2]);
			for(int x = 0; x<3; x++) {
				pairWins += checkWin(a,b,board[0][x],board[1][x], board[2][x]);
				pairWins += checkWin(a,b,board[x][0],board[x][1], board[x][2]);				
			}
		}
		}
		out.println(singleWins);
		out.println(pairWins);
		out.close();
		f.close();
	}

}
