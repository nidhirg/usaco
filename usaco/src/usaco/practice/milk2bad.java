package usaco.practice;

/*
ID: nidhirg1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2bad {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		StringTokenizer st;
		List<Integer> startTimes = new ArrayList<Integer>();
		List<Integer> endTimes = new ArrayList<Integer>();
		int earlyStart;
		int nextStart = 1000000;
		int lateEnd;
		int milkTime = 0;
		int gapTime = 0;
		int N = Integer.parseInt(f.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			startTimes.add(Integer.parseInt(st.nextToken()));
			endTimes.add(Integer.parseInt(st.nextToken()));
		}
		for (int h = 0; h < N; h++) {
			earlyStart = startTimes.get(h);
			lateEnd = endTimes.get(h);
			for (int j = 0; j < N; j++) {
				if(lateEnd >= startTimes.get(j) && lateEnd < endTimes.get(j)) {
					lateEnd = endTimes.get(j);
				}
				if (earlyStart <= endTimes.get(j) && earlyStart > startTimes.get(j)) {
					earlyStart = startTimes.get(j);
				}
			}
			if (lateEnd - earlyStart > milkTime) {
				milkTime = lateEnd - earlyStart;
			}
		}
		for (int h = 0; h < N; h++) {
			earlyStart = startTimes.get(h);
			lateEnd = endTimes.get(h);
			for (int j = 0; j < N; j++) {
				if (lateEnd >= startTimes.get(j) && lateEnd < endTimes.get(j)) {
					lateEnd = endTimes.get(j);
				}
				if (earlyStart <= endTimes.get(j) && earlyStart > startTimes.get(j)) {
					earlyStart = startTimes.get(j);
				}
			}
			for (int j = 0; j < N; j++) {
				if ((lateEnd < startTimes.get(j) && startTimes.get(j) < nextStart) && startTimes.get(j) > earlyStart ) {
					nextStart = startTimes.get(j);
				}
			}
			if (nextStart - lateEnd > gapTime && nextStart != 1000000) {
				gapTime = nextStart - lateEnd;
			}
		}
		out.write(String.valueOf(milkTime) + " " + String.valueOf(gapTime) + "\n");
		out.close();
		f.close();
	}
}
