package usaco.practice;
//2018 December Bronze 3

import java.io.*;
import java.util.*;

public class backandforthbad {
	public static void main(String[] args) throws IOException{
		int[] barn11 = new int[10];
		int[] barn21 = new int[11];
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		BufferedReader f = new BufferedReader(new FileReader(prepath+"backforth.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(prepath+"backforth.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		StringTokenizer st2 = new StringTokenizer(f.readLine());
		for(int i = 0; i<10;i++) {
			barn11[i] = Integer.parseInt(st.nextToken());
			barn21[i] = Integer.parseInt(st2.nextToken());
		}
		int[] barn1copy = barn11.clone();
		int[] barn2copy = barn21.clone();
		ArrayList<Integer> milks = new ArrayList<Integer>();
		int barn1milk = 1000;
		for(int a = 0; a<10; a++) {
			int[] barn1 = barn1copy.clone();
			int[] barn2 = barn2copy.clone();
			barn2[10] = barn1[a];
			int aVal = barn1[a];
			for(int b = 0; b<11; b++) {
				barn1[a] = barn2[b];
				int bVal = barn2[b];
				for(int c = 0; c<10; c++) {
					barn2[b] = barn1[c];
					int cVal = barn1[c];
					for(int d = 0; d<11; d++) {
						barn1[c] = barn2[d];
						int dVal = barn2[d];
						barn1milk = 1000;
						barn1milk -= aVal;
						barn1milk += bVal;
						barn1milk -= cVal;
						barn1milk += dVal;
						if(!milks.contains(Integer.valueOf(barn1milk))) {
							milks.add(barn1milk);
						}
						/*
						if(a==0&&b==1&&c==0&&d==0) {
						//if(barn1milk == 1005||barn1milk==1001) {
							out.println(barn1milk);
							out.println(aVal);
							out.println(bVal);
							out.println(cVal);
							out.println(dVal);
							out.println(a+" "+b+" "+c+" "+d);
						}
						*/
					}
				}
			}
			barn1 = barn1copy.clone();
			barn2 = barn2copy.clone();
		}
		for(int i:milks) {
			out.println(i);
		}
		out.println(milks.size());
		out.close();
		f.close();
	}
}
