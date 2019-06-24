package usaco.practice;
//February 2015 Bronze 2
import java.io.*;
import java.util.*;

public class cow {

	public static void main(String[] args) throws IOException{
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		String inpath = "cow.in";
		String outpath = "cow.out";
		Scanner in = new Scanner(new File(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		int N = in.nextInt();
		int cs = 0;
		int ws = 0;
		long ret = 0;
		char[] letters = new char[N];
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		String word = in.next();
		for(int x = 0; x<N;x++) {
			letters[x] = word.charAt(x);
			if(letters[x] == 'O') {
				indexList.add(x);
			}
		}
		for(int x = 0; x<indexList.get(0); x++) {
			if(letters[x]=='C') {
				cs++;
			}
		}
		for(int x = indexList.get(0); x<N; x++) {
			if(letters[x] == 'W') {
				ws++;
			}
		}
		ret += (cs*ws);
		for(int x = 0; x < indexList.size()-1; x++) {
			for(int z = indexList.get(x); z<indexList.get(x+1);z++) {
				if(letters[z]=='C') {
					cs++;
				}
				if(letters[z]=='W'){
					ws--;
				}
			}
			ret+=(cs*ws);
		}
		out.println(ret+"");
		out.close();
		in.close();
	}

}
