package usaco.practice;

import java.io.*;

public class censoringold {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("censor.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));
		String s = f.readLine();
		String t = f.readLine();
		f.close();
		int i = s.indexOf(t);
		while(i>0) {
			s = s.replace(t,"");
			i = s.indexOf(t);
		}
		out.write(s);
		out.close();
	}
}
