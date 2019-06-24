package usaco.practice;
import java.io.*;
import java.util.*;

//December 2015 Bronze 2

public class SpeedingTicket {

	public static void main(String[] args) throws IOException {
		String inpath = "speeding.in";
		String outpath = "speeding.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] speedLimits = new int[100];
		int[] speeds = new int[100];
		int index = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			int distance = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int incrementer = 0;
			while(incrementer < distance) {
				speedLimits[index+incrementer] = speed;
				incrementer ++;
			}
			index += incrementer;
		}
		index = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(f.readLine());
			int distance = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int incrementer = 0;
			while(incrementer < distance) {
				speeds[index+incrementer] = speed;
				incrementer ++;
			}
			index += incrementer;
		}
		int speedOver = 0;
		for(int i = 0; i < 100; i++) {
			if(speeds[i] - speedLimits[i] > speedOver) speedOver = speeds[i] - speedLimits[i];
		}
		out.println(speedOver+"");
		out.close();
		f.close();
	}
}
