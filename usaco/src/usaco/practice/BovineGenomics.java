package usaco.practice;
import java.io.*;
import java.util.*;

//Open 2017 Bronze 2

public class BovineGenomics {
	public static class Cow{
		char[] genome;
		public static int M;
		public Cow(String s) {
			genome = new char[M];
			for(int i = 0; i < M; i++) {
				genome[i] = s.charAt(i);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		String inpath = "cownomics.in";
		String outpath = "cownomics.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Cow.M = M;
		Cow[] spotty = new Cow[N];
		Cow[] plain = new Cow[N];
		
		for(int i = 0; i < N; i++) {
			spotty[i] = new Cow(f.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			plain[i] = new Cow(f.readLine());
		}
		
		boolean viable = true;
		int viableLocations = 0;
		for(int i = 0; i < M; i++) {
			viable = true;
			char[] plainGenes = new char[N];
			for(int cowID = 0; cowID < N; cowID++) {
				plainGenes[cowID] = plain[cowID].genome[i];
			}
			for(int cowID = 0; cowID < N; cowID++) {
				char thisGene = spotty[cowID].genome[i];
				for(char gene : plainGenes) {
					if(gene == thisGene) {
						viable = false;
						break;
					}
				}
				if(!viable) {
					break;
				}
			}
			if(viable) {
				viableLocations++;
			}
		}
		out.println(viableLocations+"");
		out.close();
		f.close();
	}
}
