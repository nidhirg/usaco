package usaco.practice;
import java.io.*;
import java.util.*;

//2018 January Bronze 3

public class OutOfPlace {
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
		int index = 0;
		int repeats = 0;
		for(int i = 0; i < N-1; i++) {
			if(sortedCows.get(i) > sortedCows.get(i+1)) {
				index = i+1;
				break;
			}
			if(sortedCows.get(i) == sortedCows.get(i+1)) {
				repeats++;
			}
		}
		int bessie = sortedCows.get(index);
		Collections.sort(sortedCows);
		int goal = 0;
		for(int i = 0; i < N; i++) {
			if(sortedCows.get(i)==bessie) {
				goal = i;
				break;
			}
		}
		if(index == 0) repeats = 0;
		out.println(Math.abs(index - goal) - repeats);
		out.close();
		f.close();
	}

}
