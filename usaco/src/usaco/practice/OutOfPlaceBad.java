package usaco.practice;
import java.io.*;
import java.util.*;

//2018 January Bronze 3

public class OutOfPlaceBad {
	public static void main(String[] args) throws IOException {
		String inpath = "outofplace.in";
		String outpath = "outofplace.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(prepath + inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(prepath + outpath)));
		ArrayList<Integer> sortedCows = new ArrayList<Integer>();
		int N = Integer.parseInt(f.readLine());
		for (int i = 0; i < N; i++) {
			sortedCows.add(Integer.parseInt(f.readLine()));
		}
		int decrementer = 0;
		for (int i = 0; i < N - 1 - decrementer; i++) {
			if (sortedCows.get(i) == sortedCows.get(i + 1)) {
				sortedCows.remove(i + 1);
				decrementer++;
			}
		}
		int bessieIndex = 0;
		for (int i = 0; i < sortedCows.size() - 1; i++) {
			if (sortedCows.get(i) > sortedCows.get(i + 1)) {
				bessieIndex = i + 1;
			}
		}
		int swaps = 0;
		boolean moreSwaps = true;
		if (bessieIndex == 0) {
			moreSwaps = false;
		}
		while (moreSwaps) {
			int temp = sortedCows.get(bessieIndex - 1);
			sortedCows.set(bessieIndex - 1, sortedCows.get(bessieIndex));
			sortedCows.set(bessieIndex, temp);
			bessieIndex--;
			swaps++;
			if (bessieIndex != 0 && sortedCows.get(bessieIndex - 1) > sortedCows.get(bessieIndex)) {
				moreSwaps = true;
			}else {
				moreSwaps = false;
			}
		}
		out.println(swaps);
		out.close();
		f.close();
	}
}
