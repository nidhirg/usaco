package usaco.practice;

import java.io.*;

public class censoring {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("censor.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));
		String s = f.readLine();
		String t = f.readLine();
		f.close();
		char[] sChar = s.toCharArray();
		StringBuilder r = new StringBuilder();
		//int i = s.indexOf(t);
		int l = t.length();
		int rL;
		String rShort;
		for(char c:sChar) {
			r.append(c);
			rL = r.length();
			if(rL>=l) {
				rShort = r.substring(rL-l, rL);
				if(rShort.equals(t)) {
					r.substring(0,rL-l);
				}
			}
		}
		/*while(i>0) {
			s = s.replace(t,"");
			i = s.indexOf(t);
		}*/
		out.write(r.toString());
		out.close();
	}
}
