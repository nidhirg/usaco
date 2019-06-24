package usaco.practice;
import java.io.*;
import java.util.*;

//2018 December Bronze 1;

public class mixmilkalsogood {
	public static void main(String[] args) throws IOException{
		String inpath = "mixmilk.in";
		String outpath = "mixmilk.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(prepath+outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int capacity1 = Integer.parseInt(st.nextToken());
		int milk1 = Integer.parseInt(st.nextToken());
		int space1 = capacity1-milk1;
		st = new StringTokenizer(f.readLine());
		int capacity2 = Integer.parseInt(st.nextToken());
		int milk2 = Integer.parseInt(st.nextToken());
		int space2 = capacity2-milk2;
		st = new StringTokenizer(f.readLine());
		int capacity3 = Integer.parseInt(st.nextToken());
		int milk3 = Integer.parseInt(st.nextToken());
		int space3 = capacity3-milk3;
		for(int i = 0; i<100; i++) {
			if(i%3==0) {
				if(space2>=milk1) {
					milk2 += milk1;
					milk1 = 0;
					space2 = capacity2-milk2;
					space1 = capacity1;
				}else {
					milk1 -= space2;
					milk2 = capacity2;
					space2 = 0;
					space1 = capacity1-milk1;
				}
			} else if(i%3==1) {
				if(space3>=milk2) {
					milk3 += milk2;
					milk2 = 0;
					space3 = capacity3-milk3;
					space2 = capacity2;
				}else {
					milk2 -= space3;
					milk3 = capacity3;
					space3 = 0;
					space2 = capacity2-milk2;
				}
			}else if(i%3==2) {
				if(space1>=milk3) {
					milk1 += milk3;
					milk3 = 0;
					space1 = capacity1-milk1;
					space3 = capacity3;
				}else {
					milk3 -= space1;
					milk1 = capacity1;
					space1 = 0;
					space3 = capacity3-milk3;
				}
				
			}
		}
		out.println(milk1);
		out.println(milk2);
		out.println(milk3);
		out.close();
		f.close();
	}
}
