package usaco.practice;
//December 2018 Bronze 2

import java.io.*;
import java.util.*;

public class bucketlist {
	public static class Times implements Comparable<Times>{
		public int time;
		public int id;
		public int buckets;
		public Times(int a, int b, int c) {
			id = a;
			time = b;
			buckets = c;
		}
		public int compareTo(Times x) {
			return time - x.time;
		}
	}
	public static void main(String[] args) throws IOException{
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		BufferedReader f = new BufferedReader(new FileReader("blist.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
		StringTokenizer st;
		int N = Integer.parseInt(f.readLine());
		Times[] times = new Times[2*N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int buckets = Integer.parseInt(st.nextToken());
			times[2*i] = new Times(i,start,buckets);
			times[2*i+1] = new Times(i,end,buckets);
		}
		Arrays.sort(times);
		int activeBuckets = 0;
		int inactiveBuckets = 0;
		ArrayList<Integer> active = new ArrayList<Integer>();
		for(Times x:times) {
			if(active.contains(x.id)) {
				active.remove(Integer.valueOf(x.id));
				inactiveBuckets += x.buckets;
				activeBuckets -= x.buckets;
			}else {
				active.add(x.id);
				if(x.buckets>inactiveBuckets) {
					inactiveBuckets = 0;
					activeBuckets += x.buckets;
				}else {
					inactiveBuckets -= x.buckets;
					activeBuckets += x.buckets;
				}
			}
		}
		out.println(activeBuckets+inactiveBuckets);
		out.close();
		f.close();
	}
}
