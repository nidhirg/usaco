package usaco.practice;
/*
ID: nidhirg1
LANG: JAVA
TASK: namenum
*/
import java.util.*;
import java.io.*;

public class namenum {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		String serial = f.readLine();
		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
		int N = serial.length();
		Map<String, String> keys = new HashMap<String, String>();
		keys.put("A", "2");
		keys.put("B", "2");
		keys.put("C", "2");
		keys.put("D", "3");
		keys.put("E", "3");
		keys.put("F", "3");
		keys.put("G", "4");
		keys.put("H", "4");
		keys.put("I", "4");
		keys.put("J", "5");
		keys.put("K", "5");
		keys.put("L", "5");
		keys.put("M", "6");
		keys.put("N", "6");
		keys.put("O", "6");
		keys.put("P", "7");
		keys.put("R", "7");
		keys.put("S", "7");
		keys.put("T", "8");
		keys.put("U", "8");
		keys.put("V", "8");
		keys.put("W", "9");
		keys.put("X", "9");
		keys.put("Y", "9");
		ArrayList<String> dicta = new ArrayList<String>();
		ArrayList<String> dicto = new ArrayList<String>();
		String name;
		while ((name = dict.readLine()) != null) {
			dicto.add(name);
			dicta.add(name);
		}
		dict.close();
		for (String n:dicta) {
			if (n.length()!=N) {
				dicto.remove(n);
			}
		}
		boolean written = false;
		for(String n : dicto) {
			String stringNum = "";
			for(int i = 0; i<N;i++) {
				stringNum += keys.get(n.substring(i,i+1));
			}
			if(stringNum.equals(serial)) {
				System.out.println(stringNum);
				System.out.println(n);
				out.write(n + "\n");
				written = true;
			}
		}
		if(!written) {
			out.write("NONE\n");
		}
		out.close();
		f.close();
	}
}

