package usaco.practice;
//January 2015 Bronze 3
import java.io.*;
import java.util.StringTokenizer;

public class whatbasebad {
	
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
		BufferedReader f = new BufferedReader(new FileReader(prepath+inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(prepath+outpath)));
		int K = Integer.parseInt(f.readLine());
		for (int z = 0; z < K; z++) {
			int highNum;
			int lowNum;
			StringTokenizer st = new StringTokenizer(f.readLine());
			int numOne = Integer.parseInt(st.nextToken());
			int numTwo = Integer.parseInt(st.nextToken());
			if (numOne > numTwo) {
				highNum = numOne;
				lowNum = numTwo;
			} else {
				highNum = numTwo;
				lowNum = numOne;
			}
			int max = 15000;
			int lowBase = 10;
			int highBase = 11;
			int A = highNum/100;
			int B = (highNum/10)%10;
			int C = highNum%10;
			int D = lowNum/100;
			int E = (lowNum/10)%10;
			int F = lowNum%10;
			int finalLowBase = 0;
			int finalHighBase = 0;
			for(int y = 10; y<15000; y++) {
				lowBase = y;
				int temp = A*y*y+B*y+C;
				double doubleMax = (E*-1+Math.sqrt(E*E-4*D*(F-temp)))/(2*D);
				max = (int) ((E*-1+Math.sqrt(E*E-4*D*(F-temp)))/(2*D)+2.0);
				int max1 = (int) ((E*-1+Math.sqrt(E*E-4*D*(F-temp)))/(2*D)+.5);
				System.out.println(E);
				System.out.println(temp);
				System.out.println(((E*-1+Math.sqrt(E*E-4*D*(F-temp)))/(2*D)+1.0));
				/*
				if(doubleMax == max1) {
					if (numOne > numTwo) {
						out.println(y + " " + max1);
					} else {
						out.println(max1 + " " + y);
					}
					break;
				}
				*/
				
				for(int x = y + 1; x<15000; x++) {
					highBase = x;
					if(convertBase(x,lowNum)==convertBase(y,highNum)) {
						System.out.println(y+" "+max);
						finalHighBase = x;
						break;
					}
				}
				if(convertBase(highBase,lowNum)==convertBase(y,highNum)) {
					finalLowBase = y;
					break;
				}
				
			}
			
			if (numOne > numTwo) {
				out.println(finalLowBase + " " + finalHighBase);
			} else {
				out.println(finalHighBase + " " + finalLowBase);
			}
			
		}
		out.close();
		f.close();
	}

}
