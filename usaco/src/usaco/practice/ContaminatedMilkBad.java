package usaco.practice;
import java.io.*;
import java.util.*;

//December 2015 Bronze 3

public class ContaminatedMilkBad {
	
	public static class Milk implements Comparable<Milk>{
		public int time;
		public int id;
		public Milk(int a, int b) {
			id = a;
			time = b;
		}
		public int compareTo(Milk x) {
			return time - x.time;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		String inpath = "badmilk.in";
		String outpath = "badmilk.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		ArrayList<Milk>[] people = (ArrayList<Milk>[]) new ArrayList[N];
		for(int i = 0; i < D; i++) {
			st = new StringTokenizer(f.readLine());
			int person = Integer.parseInt(st.nextToken()) - 1;
			int milkID = Integer.parseInt(st.nextToken());
			int milkTime = Integer.parseInt(st.nextToken());
			people[person].add(new Milk(milkID, milkTime));
		}
		
		ArrayList<int[]> sicks = new ArrayList<int[]>();
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(f.readLine());
			int[] sicko = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())};
			sicks.add(sicko);
		}
		
		ArrayList<Integer> validMilks = new ArrayList<Integer>(M);
		for(int i = 1; i <= M; i++) {
			validMilks.add(i);
		}
		ArrayList<Integer> currentMilks = new ArrayList<Integer>();
		for(int[] i : sicks) {
			int person = i[0];
			Collections.sort(people[person]);
			int index = 0;
			while(people[person].get(index).time < i[1]) {
				currentMilks.add(people[person].get(index).id);
				index ++;
			}
			for(int x = 0; x < validMilks.size(); x++) {
				if(!currentMilks.contains(validMilks.get(x))) {
					validMilks.remove(x);
					x--;
				}
			}
		}
		
		int sickPeople = 0;
		int currentSick = 0;
		for(int i : validMilks) {
			for(ArrayList<Milk> milks : people) {
				boolean add = false;
				for(Milk milk : milks) {
					if(milk.id == i) {
						add = true;
					}
				}
				if(add) {
					currentSick ++;
				}
			}
			if(currentSick > sickPeople) {
				sickPeople = currentSick;
			}
		}
		
		out.println(sickPeople);
		out.close();
		f.close();
	}

}
