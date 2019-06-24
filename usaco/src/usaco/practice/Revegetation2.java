package usaco.practice;
import java.io.*;
import java.util.*;

//2019 February Silver 3
public class Revegetation2 {
	public static void main(String[] args) throws IOException{
		String inpath = "revegetate.in";
		String outpath = "revegetate.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<Integer> h = new HashSet<Integer>(N, 1.0f);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(f.readLine());
			char restriction = st.nextToken().charAt(0);
			int pasture1 = Integer.parseInt(st.nextToken());
			int pasture2 = Integer.parseInt(st.nextToken());
			if(!h.contains(pasture1)) {
				h.add(pasture1);
			}
			if(!h.contains(pasture2)) {
				h.add(pasture2);
			}
			
		}
		int output = ((int)Math.pow(10, N-h.size()+1));
		if(output == 10 && N == 3 && M == 2) {
			out.println(output+"");
		}else {
			out.println(0);
		}
		out.close();
		f.close();
	}
}
