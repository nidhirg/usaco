package usaco.practice;
/*
ID: nidhirg1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

public class milk2alsobad {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		StringTokenizer st;
		List<Integer> startTimes = new ArrayList<Integer>();
		List<Integer> endTimes = new ArrayList<Integer>();
		int lateEnd = 0;
		int earlyStart = 1000000;
		int N = Integer.parseInt(f.readLine());
		int counter = 0;
		int milkTime = 0;
		int gapTime = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(f.readLine());
			startTimes.add(Integer.parseInt(st.nextToken()));
			endTimes.add(Integer.parseInt(st.nextToken()));
		}
		for (int x:endTimes) {
			if (x > lateEnd) {
				lateEnd = x;
			}
		}
		for (int x:startTimes) {
			if (x < earlyStart) {
				earlyStart = x;
			}
		}
		int[] times = new int[lateEnd+1];
		for (int x = 0; x <= lateEnd; x++) {
			times[x] = 0;
		}
		for (int x = 0; x < N; x++) {
			for (int y = startTimes.get(x); y <= endTimes.get(x); y++) {
				times[y] = 1;
			}
			times[startTimes.get(x)] = 2;
			times[endTimes.get(x)] = 3;
		}
		times[endTimes.get(N-1)] = 1;
		for (int x = 0; x < lateEnd; x++) {
			if ((times[x] == 1 || times[x] == 2) && (times[x+1] == 1 || times[x+1] == 2)) {
				counter++;
				if (counter > milkTime) {
					milkTime = counter;
				}
			}else if((times[x] == 0 && times[x+1] == 0) && x > earlyStart){
				counter++;
				if (counter > gapTime) {
					gapTime = counter;
				}
			}else if(times[x] == 3 && times[x+1] == 2){
				if(gapTime == 0) {
					gapTime = 1;
				}
			}else {
				counter = 0;
			}
		}
		out.write(String.valueOf(milkTime) + " " + String.valueOf(gapTime) + "\n");
		out.close();
		f.close();
	}
}
