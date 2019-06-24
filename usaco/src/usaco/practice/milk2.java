package usaco.practice;
/*
ID: nidhirg1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;
public class milk2 {
	public static class Times implements Comparable<Times>{
		public int time;
		public int id;
		public Times(int a, int b) {
			id = a;
			time = b;
		}
		public int compareTo(Times x) {
			return time - x.time;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		StringTokenizer st;
		int N = Integer.parseInt(f.readLine());
		Times[] times = new Times[2*N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			times[2*i] = new Times(i,Integer.parseInt(st.nextToken()));
			times[2*i+1] = new Times(i,Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(times);
		ArrayList<Integer> active = new ArrayList<Integer>();
		int currentMilkTime = 0;
		int longestMilkTime = 0;
		int noMilkTime = 0;
		int currentTime = times[0].time;
		int lastTime = times[0].time;
		for(Times x:times) {
			lastTime = currentTime;
			currentTime = x.time;
			if(!active.isEmpty() || currentTime == lastTime) {
				if(active.contains(x.id)) {
					active.remove(Integer.valueOf(x.id));
					currentMilkTime += currentTime - lastTime;
				}else {
					active.add(x.id);
					currentMilkTime += currentTime - lastTime;
				}
				if (currentMilkTime>longestMilkTime) {
					longestMilkTime = currentMilkTime;
				}
			}else {
				if (currentMilkTime>longestMilkTime) {
					longestMilkTime = currentMilkTime;
				}
				currentMilkTime = 0;
				if(currentTime - lastTime > noMilkTime) {
					noMilkTime = currentTime - lastTime;
				}
				active.add(x.id);
			}
		}
		out.write(String.valueOf(longestMilkTime) + " " + String.valueOf(noMilkTime) + "\n");
		out.close();
		f.close();
	}
}
