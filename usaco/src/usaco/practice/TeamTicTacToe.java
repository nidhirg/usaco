package usaco.practice;
//2018 Open Bronze 1

import java.io.*;
import java.util.*;

public class TeamTicTacToe {

	public static void main(String[] args) throws IOException{
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		String inpath = "tttt.in";
		String outpath = "tttt.out";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		char[][] board = new char[3][3];
		for(int y = 0; y < 3; y++) {
			String s = f.readLine();
			for(int x = 0; x < 3; x++) {
				board[x][y] = s.charAt(x);
			}
		}
		int singleWins = 0;
		int pairWins = 0;
		int inty;
		for(char a = 'A'; a <= 'Z'; a++) {
			inty = 0;
			inty += checkWins(a, board[0][0], board[1][1], board[2][2]);
			inty += checkWins(a, board[2][0], board[1][1], board[0][2]);
			for(int q = 0; q<3; q++) {
				inty += checkWins(a, board[q][0], board[q][1], board[q][2]);
				inty += checkWins(a, board[0][q], board[1][q], board[2][q]);
			}
			if(inty>0) singleWins++;
		}
		for(char a = 'A'; a<= 'Z'; a++) {
			for(char b = (char) (a+1); b<='Z'; b++) {
				inty = 0;
				inty += checkWins(a, b, board[0][0], board[1][1], board[2][2]);
				inty += checkWins(a, b, board[2][0], board[1][1], board[0][2]);
				for(int q = 0; q<3; q++) {
					inty += checkWins(a, b, board[q][0], board[q][1], board[q][2]);
					inty += checkWins(a, b, board[0][q], board[1][q], board[2][q]);
				}
				if(inty>0) pairWins ++;
			}
		}
		out.println(singleWins);
		out.println(pairWins);
		out.close();
		f.close();
	}
	
	public static int checkWins(char a, char one, char two, char three) {
		if(one!=a||two!=a||three!=a) {
			return 0;
		}
		return 1;
	}
	
	public static int checkWins(char a, char b, char one, char two, char three) {
		if((one!=a&&one!=b)||(two!=a&&two!=b)||(three!=a&&three!=b)) {
			return 0;
		}
		if(one==two&&two==three) {
			return 0;
		}
		return 1;
	}

}
