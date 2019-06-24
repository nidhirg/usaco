package usaco.practice;
//2018 Open Bronze 2

import java.io.*;
import java.util.*;

public class MilkingOrder {
	
	public static class SpecifiedCow implements Comparable<SpecifiedCow>{
		public int indexInOrder;
		public int indexInHeirarchy = -1;
		public int id;
		public int indexInSpecified;
		public SpecifiedCow(int id, int pos) {
			this.id = id;
			indexInOrder = pos - 1;
		}
		public int compareTo(SpecifiedCow x) {
			return indexInOrder - x.indexInOrder;
		}
	}
	public static void main(String[] args) throws IOException{
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		String inpath = prepath+"milkorder.in";
		String outpath = prepath+"milkorder.out";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st;
		
		st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] order = new int[N];
		int[] heirarchy = new int[M];
		SpecifiedCow[] specified = new SpecifiedCow[K];
		ArrayList<SpecifiedCow> overlap = new ArrayList<SpecifiedCow>();

		for(int i = 0; i < N; i++) {
			order[i] = 0;
		}
		
		st = new StringTokenizer(f.readLine());
		for(int i = 0; i < M; i++) {
			heirarchy[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(f.readLine());
			int id = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			order[pos-1] = id;
			specified[i] = new SpecifiedCow(id,pos);
		}
		Arrays.sort(specified);
		int jSetter = 0;
		for(int i = 0; i < K; i++) {
			for(int j = jSetter; j < M; j++) {
				if(heirarchy[j]==specified[i].id) {
					overlap.add(specified[i]);
					specified[i].indexInHeirarchy = j;
					specified[i].indexInSpecified = i;
					jSetter = j+1;
					break;
				}
			}
		}
		
		if(overlap.size()==0) {
			int minIndex = 0;
			for(int i = 0; i < N; i++) {
				if(order[i]==0) {
					minIndex = i+1;
					break;
				}
			}
			out.println(""+minIndex);
			out.close();
			f.close();
		}else if (overlap.size()==1) {
			int left = overlap.get(0).indexInHeirarchy;
			int right = M - overlap.get(0).indexInHeirarchy-1;
			int i = overlap.get(0).indexInOrder-1;
			int count = 0;
			while(count < left) {
				if(order[i] == 0) {
					order[i] = 1;
					count++;
				}
				i--;
			}
			count = 0;
			i = N-1;
			while(count < right) {
				if(order[i] == 0) {
					order[i] = 1;
					count++;
				}
				i--;
			}
			
			int minIndex = 0;
			for(i = 0; i < N; i++) {
				if(order[i]==0) {
					minIndex = i+1;
					break;
				}
			}
			out.println(""+minIndex);
			out.close();
			f.close();
		}else {
			int left = overlap.get(0).indexInHeirarchy;
			int i = overlap.get(0).indexInOrder-1;
			int count = 0;
			while(count < left) {
				if(order[i] == 0) {
					order[i] = 1;
					count++;
				}
				i--;
			}
			
			for(i = 0; i < overlap.size()-1; i++) {
				int inserts = overlap.get(i+1).indexInHeirarchy-overlap.get(i).indexInHeirarchy-1;
				count = 0;
				int index = overlap.get(i+1).indexInOrder - 1;
				while(count < inserts) {
					if(order[index] == 0) {
						order[index] = 1;
						count++;
					}
					index--;
				}
			}
			
			int right = M - overlap.get(overlap.size()-1).indexInHeirarchy;
			i = N-1;
			count = 0;
			while(count < right) {
				if(order[i] == 0) {
					order[i] = 1;
					count++;
				}
				i--;
			}
			
			int minIndex = 0;
			for(i = 0; i < N; i++) {
				if(order[i]==0) {
					minIndex = i+1;
					break;
				}
			}
			out.println(""+minIndex);
			out.close();
			f.close();
		}
	}

}
