package usaco.practice;
import java.io.*;
import java.util.*;

//February 2018 Bronze 1

public class Teleportation {
	public static void main(String[] args) throws IOException{
		String inpath = "teleport.in";
		String outpath = "teleport.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int distance = Math.abs(b-a);
		if(Math.abs(a-x) + Math.abs(b-y) < distance) {
			distance = Math.abs(a-x) + Math.abs(b-y);
		}
		if(Math.abs(a-y)+Math.abs(b-x) < distance) {
			distance = Math.abs(a-y)+Math.abs(b-x);
		}
		out.println(distance+"");
		out.close();
		f.close();
	}
}
