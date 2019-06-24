package usaco.practice;
//2018 December Bronze 1

import java.io.*;
import java.util.*;

public class mixmilk {

	public static void main(String[] args) throws IOException{
		String inpath = "mixmilk.in";
		String outpath = "mixmilk.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st;
		int[] caps = new int[3];
		int[] milks = new int[3];
		int[] space = new int[3];
		for(int i = 0; i<3; i++) {
			st = new StringTokenizer(f.readLine());
			caps[i] = Integer.parseInt(st.nextToken());
			milks[i] = Integer.parseInt(st.nextToken());
			space[i] = caps[i]-milks[i];
		}
		int current = 0;
		for(int i = 0; i<100;i++) {
			int next = current + 1;
			if(current==2) {
				next = 0;
			}
			int milk = milks[current];
			int capNext = caps[next];
			int milkNext = milks[next];
			space[next] = capNext-milkNext;
			if(milk<=space[next]) {
				milks[next] += milk;
				milks[current] = 0;
			}else {
				milks[current] -= space[next];
				milks[next] += space[next];
			}
			current++;
			if(current==3) current = 0;
		}
		out.println(milks[0]);
		out.println(milks[1]);
		out.println(milks[2]);
		out.close();
		f.close();
	}

}
