package usaco.practice;

/*
ID: nidhirg1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class palsquare {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		int B = Integer.parseInt(f.readLine());
		Map<Integer, String> keys = new HashMap<Integer, String>();
		keys.put(0, "0");
		keys.put(1, "1");
		keys.put(2, "2");
		keys.put(3, "3");
		keys.put(4, "4");
		keys.put(5, "5");
		keys.put(6, "6");
		keys.put(7, "7");
		keys.put(8, "8");
		keys.put(9, "9");
		keys.put(10, "A");
		keys.put(11, "B");
		keys.put(12, "C");
		keys.put(13, "D");
		keys.put(14, "E");
		keys.put(15, "F");
		keys.put(16, "G");
		keys.put(17, "H");
		keys.put(18, "I");
		keys.put(19, "J");
		for (int i = 1; i < 301; i++) {
			int n = i * i;
			String nBaseBString = "";
			while (n > B) {
				nBaseBString += keys.get(Integer.valueOf(n % B));
				n /= B;
			}
			nBaseBString += n;
			boolean palindrome = true;
			for (int x = 0; x < nBaseBString.length(); x++) {
				if (palindrome) {
					if (!(nBaseBString.charAt(x) == nBaseBString.charAt(nBaseBString.length() - 1 - x))) {
						palindrome = false;
					}
				}
			}
			if (palindrome) {
				System.out.println(i);
				System.out.println(nBaseBString);
				out.write(String.valueOf(i) + " " + nBaseBString + "\n");
			}
		}
		f.close();
		out.close();
	}
}
