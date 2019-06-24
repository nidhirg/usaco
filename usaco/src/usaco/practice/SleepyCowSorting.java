package usaco.practice;
import java.io.*;
import java.util.*;

//2019 January Bronze 2

public class SleepyCowSorting {
	static ArrayList<Integer> order = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		String inpath = "sleepy.in";
		String outpath = "sleepy.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		int N = Integer.parseInt(f.readLine());
		StringTokenizer st = new StringTokenizer(f.readLine());
		int highestWrongIndex = 0;
		int highestWrongValue = 0;
		int indexOfHighestWrongValue = 0;
		for (int i = 0; i < N; i++) {
			int cow = Integer.parseInt(st.nextToken()) - 1;
			order.add(cow);
			if (cow != i) {
				highestWrongIndex = i;
				if (cow > highestWrongValue) {
					highestWrongValue = cow;
					indexOfHighestWrongValue = i;
				}
			}
		}
		int checkValue = order.get(N-1);
		int indexToStart = 0;
		for(int i = N-1; i > -1; i--) {
			if(order.get(i) > checkValue) {
				indexToStart = i;
				break;
			}
			checkValue = order.get(i);
		}
		int steps = 0;
		while (!inOrder()) {
			int index = indexToStart + 1;
			int insert = order.get(0);
			while (index < N && order.get(index) < insert) {
				index++;
			}
			order.add(index, insert);
			order.remove(0);
			steps++;
			checkValue = order.get(N-1);
			indexToStart = 0;
			for(int i = N-1; i > -1; i--) {
				if(checkValue < order.get(i)) {
					indexToStart = i;
					break;
				}
				checkValue = order.get(i);
			}
		}
		if(steps > N) {
			steps = N;
		}
		out.println(steps);
		out.close();
		f.close();
	}

	public static boolean inOrder() {
		boolean returner = true;
		for (int i = 0; i < order.size(); i++) {
			if (i != order.get(i)) {
				returner = false;
				break;
			}
		}
		return returner;
	}

}
