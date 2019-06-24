package usaco.practice;
//January 2015 Bronze 3
import java.io.*;
import java.util.StringTokenizer;

public class whatbase {
	
	public static int convertBase(int b, int n) {
		int onesDigit = n%10;
		int tensDigit = (n/10)%10;
		int hundredsDigit = n/100;
		return onesDigit + tensDigit*b + hundredsDigit *b*b;
	}
	
	public static void main(String[] args) throws IOException{
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		String inpath = "whatbase.in";
		String outpath = "whatbase.out";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		int K = Integer.parseInt(f.readLine());
		for (int z = 0; z < K; z++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int numOne = Integer.parseInt(st.nextToken());
			int numTwo = Integer.parseInt(st.nextToken());
			int max = 15000;
			int X = 10;
			int Y = 10;
			while(X<max&&Y<max) {
				if(convertBase(X,numOne)<convertBase(Y,numTwo)) {
					X++;
				}else if(convertBase(X,numOne)>convertBase(Y,numTwo)){
					Y++;
				}else {
					out.println(X+" "+Y);
					break;
				}
			}
		}
		out.close();
		f.close();
	}

}
