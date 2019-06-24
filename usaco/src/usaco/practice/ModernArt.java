package usaco.practice;
import java.io.*;
import java.util.*;

//2017 Open Bronze 3

public class ModernArt {
	public static class Color {
		public int num;
		public int height;
		public int width;
		public int left;
		public int bottom;
		public ArrayList<Integer> xs = new ArrayList<Integer>();
		public ArrayList<Integer> ys = new ArrayList<Integer>();

		public Color(int num) {
			this.num = num;
		}

		public void add(int x, int y) {
			xs.add(x);
			ys.add(y);
			left = Collections.min(xs);
			bottom = Collections.min(ys);
			height = Collections.max(ys) - bottom;
			width = Collections.max(xs) - left;
		}

		public boolean coveredBy(Color other) {
			boolean covered = false;
			for (int i = 0; i < other.xs.size(); i++) {
				int x = other.xs.get(i);
				int y = other.ys.get(i);
				if (left <= x && x <= left + width && bottom <= y && y <= bottom + height) {
					covered = true;
				}
			}
			return covered;
		}
	}

	public static void main(String[] args) throws IOException {
		String inpath = "art.in";
		String outpath = "art.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader( inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter( outpath)));
		int N = Integer.parseInt(f.readLine());
		int[][] canvas = new int[N][N];
		Color[] colors = new Color[9];
		ArrayList<Integer> colorIndex = new ArrayList<Integer>();
		for (int y = 0; y < 9; y++) {
			colors[y] = new Color(y);
		}
		for (int y = 0; y < N; y++) {
			String s = f.readLine();
			for (int x = 0; x < N; x++) {
				int colorID = Character.getNumericValue(s.charAt(x)) - 1;
				canvas[x][y] = colorID;
				if (!colorIndex.contains(colorID) && colorID != -1) {
					colorIndex.add(colorID);
				}
				if (colorID != -1) {
					colors[colorID].add(x, y);
				}
			}
		}
		int firsts = 0;
		for (int id : colorIndex) {
			boolean first = true;
			for (int otherID : colorIndex) {
				if (otherID == id) {
					continue;
				}
				if (colors[otherID].coveredBy(colors[id])) {
					first = false;
				}
			}
			if (first) {
				firsts++;
			}
		}
		out.println(firsts + "");
		out.close();
		f.close();
	}
}
