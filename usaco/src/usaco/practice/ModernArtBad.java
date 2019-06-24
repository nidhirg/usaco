package usaco.practice;
import java.util.*;
import java.io.*;

public class ModernArtBad {
	public static ArrayList<Integer> present;
	public static Color[] colors;

	public static class Color {
		public int id;
		public ArrayList<Integer> xCoord = new ArrayList<Integer>();
		public ArrayList<Integer> yCoord = new ArrayList<Integer>();
		int width;
		int height;
		int bottomLeftx;
		int bottomLefty;
		boolean first = false;

		public Color(int id) {
			this.id = id;
		}

		public void add(int x, int y) {
			xCoord.add(x);
			yCoord.add(y);
			width = Collections.max(xCoord) - Collections.min(xCoord);
			height = Collections.max(yCoord) - Collections.min(yCoord);
			bottomLeftx = Collections.min(xCoord);
			bottomLefty = Collections.min(yCoord);
		}

		public boolean contains(int x, int y) {
			if (bottomLeftx <= x && x <= bottomLeftx + width && bottomLefty <= y && y <= bottomLefty+height) {
				return true;
			}
			return false;
		}
	}

	public static boolean valid(Color c) {
		boolean valid = true;
		for (int i : present) {
			if (i + 1 == c.id) {
				continue;
			}
			for (int coord = 0; coord < c.xCoord.size(); coord++) {
				if (colors[i].contains(c.xCoord.get(coord), c.yCoord.get(coord))) {
					valid = false;
				}
			}
		}
		return valid;
	}

	public static void main(String[] args) throws IOException {
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(prepath + "art.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(prepath + "art.out")));
		int N = Integer.parseInt(f.readLine());
		colors = new Color[9];
		for (int i = 0; i < 9; i++) {
			colors[i] = new Color(i + 1);
		}
		present = new ArrayList<Integer>();
		int[][] canvas = new int[N][N];
		for (int y = 0; y < N; y++) {
			String line = f.readLine();
			for (int x = 0; x < N; x++) {
				canvas[x][y] = Character.getNumericValue(line.charAt(x));
				if (canvas[x][y] != 0 && !present.contains(canvas[x][y])) {
					present.add(canvas[x][y] - 1);
				}
				if (canvas[x][y] != 0) {
					colors[canvas[x][y] - 1].add(x, y);
				}
			}
		}
		for (int i : present) {
			colors[i].first = valid(colors[i]);
		}
		int firsts = 0;
		for (int i : present) {
			if (colors[i].first) {
				firsts++;
			}
		}
		out.println(firsts);
		out.close();
		f.close();
	}
}
