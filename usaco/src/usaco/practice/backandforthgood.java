package usaco.practice;
//2018 December Bronze 3

import java.io.*;
import java.util.*;

public class backandforthgood {
	public static void main(String[] args) throws IOException{
		int[] barn1 = new int[10];
		int[] barn2 = new int[11];
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		BufferedReader f = new BufferedReader(new FileReader("backforth.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		StringTokenizer st2 = new StringTokenizer(f.readLine());
		for(int i = 0; i<10;i++) {
			barn1[i] = Integer.parseInt(st.nextToken());
			barn2[i] = Integer.parseInt(st2.nextToken());
		}
		int[] barn1initial = barn1.clone();
		int[] barn2initial = barn2.clone();
		ArrayList<Integer> milks = new ArrayList<Integer>();
		int barn1milk = 1000;
		for(int a = 0; a<10; a++) {
			barn1milk = 1000;
			barn1 = barn1initial.clone();
			barn2 = barn2initial.clone();
			barn2[10] = barn1[a];
			int tuesdayRemove = barn1[a];
			int[] barn1wednesday = barn1.clone();
			int[] barn2wednesday = barn2.clone();
			for(int b = 0; b<11; b++) {
				barn1 = barn1wednesday.clone();
				barn2 = barn2wednesday.clone();
				barn1[a] = barn2[b];
				int wednesdayAdd = barn2[b];
				int[] barn1thursday = barn1.clone();
				int[] barn2thursday = barn2.clone();
				for(int c = 0; c<10; c++) {
					barn1 = barn1thursday.clone();
					barn2 = barn2thursday.clone();
					barn2[b] = barn1[c];
					int thursdayRemove = barn1[c];
					int[] barn1friday = barn1.clone();
					int[] barn2friday = barn2.clone();
					for(int d = 0; d<11; d++) {
						barn1 = barn1friday.clone();
						barn2 = barn2friday.clone();
						barn1[c] = barn2[d];
						barn1milk = 1000;
						int fridayAdd = barn2[d];
						barn1milk += wednesdayAdd;
						barn1milk += fridayAdd;
						barn1milk -= tuesdayRemove;
						barn1milk -= thursdayRemove;
						if(!milks.contains(Integer.valueOf(barn1milk))) {
							milks.add(barn1milk);
						}
					}
				}
			}
		}
		out.println(milks.size());
		out.close();
		f.close();
	}
}