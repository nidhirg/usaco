package usaco.practice;
//February 2015 Bronze 3
import java.io.*;
import java.util.StringTokenizer;

public class CowHopscotch {
	public static class Cow{
		public int paths = 0;
		public char color;
		public Cow(char c) {
			color = c;
		}
	}
	public static void main(String[] args) throws IOException{
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		String inpath = "hopscotch.in";
		String outpath = "hopscotch.out";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		String s = f.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		System.out.println(R);
		System.out.println(C);
		Cow[][] list = new Cow[R][C];
		for(int i = 0; i<R; i++) {
			s = f.readLine();
			for(int x = 0; x<C; x++) {
				list[i][x] = new Cow(s.charAt(x));
			}
		}
		f.close();
		list[0][0].paths = 1;
		for(int i = 0; i<R; i++) {
			for(int x = 0; x<C; x++) {
				for(int z = 0; z<i; z++) {
					for(int y = 0; y<x; y++) {
						if(list[z][y].color!=list[i][x].color) {
							list[i][x].paths += list[z][y].paths;
						}
					}
				}
			}
		}
		out.println(list[R-1][C-1].paths);
		out.close();
	}
}
