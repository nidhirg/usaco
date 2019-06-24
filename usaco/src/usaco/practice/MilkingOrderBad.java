package usaco.practice;

import java.io.*;
import java.util.*;

public class MilkingOrderBad {

	public static void main(String[] args) throws IOException{
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		String inpath = prepath+"milkorder.in";
		String outpath = prepath+"milkorder.out";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st,st2;
		st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] order = new int[N];
		for(int i = 0; i < N; i++) {
			order[i] = 0;
		}
		int[] heirarchy = new int[M];
		st = new StringTokenizer(f.readLine());
		for(int i = 0; i < M; i++) {
			heirarchy[i] = Integer.parseInt(st.nextToken());
		}
		int[] specified = new int[K];
		int[] temp = new int[K];
		st = new StringTokenizer(f.readLine());
		st2 = new StringTokenizer(f.readLine());
		for(int i = 0; i < K; i++) {
			int id = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st2.nextToken());
			order[pos-1] = id;
			temp[i] = pos-1;
		}
		Arrays.sort(temp);
		for(int i = 0; i < K; i++) {
			specified[i] = order[temp[i]];
		}
		int prevIndex = M;
		int prevI = -1;
		for(int i = K-1; i > 0; i--) {
			int index = -1;
			int iSpec = -1;
			for(int j = 0; j < M; j++) {
				if(specified[i] == heirarchy[j]) {
					index = j;
					iSpec = i;
				}
			}
			int indexOfSpecifiedInOrder = temp[iSpec];
			int prevIndexOfSpecifiedInOrder = N-1;
			if(prevI>=0) prevIndexOfSpecifiedInOrder = temp[prevI];
			else prevIndexOfSpecifiedInOrder = N;
			if(index >= 0) {
				for(int j = prevIndex-1; j > index; j--) {
					for(int l = prevIndexOfSpecifiedInOrder-1; l > 0; l--) {
						if(order[l]==0) {
							order[l] = heirarchy[j];
							prevIndexOfSpecifiedInOrder = 1;
							break;
						}
					}
				}
			}
			prevIndex = index;
			prevI = iSpec;
		}
		for(int i = 0; i < N; i++) {
			if(order[i] == 0) {
				out.println((i+1)+"");
				break;
			}
		}
		out.close();
		f.close();
	}

}
