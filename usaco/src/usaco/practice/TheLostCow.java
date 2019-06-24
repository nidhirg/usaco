package usaco.practice;
import java.io.*;
import java.util.*;

//Open 2017 Bronze 1

public class TheLostCow {
	public static void main(String[] args) throws IOException{
		String inpath = "lostcow.in";
		String outpath = "lostcow.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int initial = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int targetStep = 1;
		int step = 1;
		int distance = 0;
		boolean found = false;
		int prevPos = initial;
		while(!found) {
			if(step%2 == 1) {
				if(initial + targetStep >= target && initial <= target) {
					found = true;
					distance += target - prevPos;
				}else {
					distance += initial + targetStep - prevPos;
				}
			}else {
				if(initial + targetStep <= target && initial >= target) {
					found = true;
					distance += prevPos - target;
				}else {
					distance += prevPos - (initial + targetStep);
				}
			}
			prevPos = initial + targetStep;
			step++;
			targetStep *= -2;
		}
		out.println(distance+"");
		out.close();
		f.close();
	}

}
