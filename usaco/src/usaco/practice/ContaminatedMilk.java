package usaco.practice;
import java.io.*;
import java.util.*;

//December 2015 Bronze 3

public class ContaminatedMilk {
	public static void main(String[] args) throws IOException {
		String inpath = "badmilk.in";
		String outpath = "badmilk.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		boolean[][][] drankMilk = new boolean[N][M][100];
		for (int person = 0; person < N; person++) {
			for(int milk = 0; milk < M; milk++) {
				for(int time = 0; time < 100; time++) {
					drankMilk[person][milk][time] = false;
				}
			}
		}
		
		for(int i = 0; i < D; i++) {
			st = new StringTokenizer(f.readLine());
			int person = Integer.parseInt(st.nextToken()) - 1;
			int milk = Integer.parseInt(st.nextToken()) - 1;
			int time = Integer.parseInt(st.nextToken()) - 1;
			drankMilk[person][milk][time] = true;
		}
		
		int[] sicks = new int[N];
		ArrayList<Integer> sickPeople = new ArrayList<Integer>();
		for(int i = 0; i < S; i++) {
			st = new StringTokenizer(f.readLine());
			int sickPerson = Integer.parseInt(st.nextToken()) - 1;
			int sickTime = Integer.parseInt(st.nextToken()) - 1;
			sicks[sickPerson] = sickTime;
			sickPeople.add(sickPerson);
		}
		
		int mostSick = 0;
		for(int milk = 0; milk < M; milk++) {
			boolean validMilk = false;
			for(int person: sickPeople) {
				for(int time = 0; time < sicks[person]; time++) {
					if(drankMilk[person][milk][time]) {
						validMilk = true;
					}
				}
				if(!validMilk) {
					break;
				}
			}
			int sick = 0;
			if(validMilk||sickPeople.isEmpty()) {
				for(int person = 0; person < N; person ++) {
					boolean add = false;
					for(int time = 0; time < 100; time++) {
						if(drankMilk[person][milk][time]) {
							add = true;
						}
					}
					if(add) {
						sick++;
					}
				}
				if(sick>mostSick) {
					mostSick = sick;
				}
			}
		}
		
		out.println(mostSick);
		out.close();
		f.close();
	}
}
