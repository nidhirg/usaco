package usaco.practice;
import java.io.*;
import java.util.*;

//2019 February Silver 3
public class Revegetation {
	public static void main(String[] args) throws IOException{
		String inpath = "revegetate.in";
		String outpath = "revegetate.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(prepath+inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(prepath+outpath)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<Integer> starters = new HashSet<Integer>(N);
		HashMap<Integer, Integer> h = new HashMap<Integer,Integer>(N);
		HashMap<Integer, HashSet<Integer>> linkedLists = new HashMap<Integer, HashSet<Integer>>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(f.readLine());
			char restriction = st.nextToken().charAt(0);
			int pasture1 = Integer.parseInt(st.nextToken());
			int pasture2 = Integer.parseInt(st.nextToken());
			
			if(starters.contains(pasture1) && starters.contains(pasture2)) {
				starters.remove(pasture2);
				h.put(pasture2, pasture1);
				linkedLists.get(pasture1).add(pasture2);
				Iterator<Integer> iter = linkedLists.get(pasture2).iterator();
				while(iter.hasNext()) {
					int connectedPasture = iter.next();
					h.remove(connectedPasture);
					h.put(connectedPasture, pasture1);
					linkedLists.get(pasture1).add(connectedPasture);
				}
				linkedLists.remove(pasture2);
			}
			else if(starters.contains(pasture1) && h.containsKey(pasture2)) {
				if(!(h.get(pasture2) == pasture1)) {
					pasture2 = h.get(pasture2);
					starters.remove(pasture2);
					h.put(pasture2, pasture1);
					linkedLists.get(pasture1).add(pasture2);
					Iterator<Integer> iter = linkedLists.get(pasture2).iterator();
					while(iter.hasNext()) {
						int connectedPasture = iter.next();
						h.remove(connectedPasture);
						h.put(connectedPasture, pasture1);
						linkedLists.get(pasture1).add(connectedPasture);
					}
					linkedLists.remove(pasture2);
				}
			}
			else if(starters.contains(pasture1)) {
				linkedLists.get(pasture1).add(pasture2);
				h.put(pasture2, pasture1);
			}
			else if(starters.contains(pasture2) && h.containsKey(pasture1)) {
				if(!(h.get(pasture1) == pasture2)) {
					int temp = pasture2;
					pasture2 = h.get(pasture1);
					pasture1 = temp;
					starters.remove(pasture2);
					h.put(pasture2, pasture1);
					linkedLists.get(pasture1).add(pasture2);
					Iterator<Integer> iter = linkedLists.get(pasture2).iterator();
					while(iter.hasNext()) {
						int connectedPasture = iter.next();
						h.remove(connectedPasture);
						h.put(connectedPasture, pasture1);
						linkedLists.get(pasture1).add(connectedPasture);
					}
					linkedLists.remove(pasture2);
				}
			}
			else if(starters.contains(pasture2)) {
				linkedLists.get(pasture2).add(pasture1);
				h.put(pasture1, pasture2);
			}
			else if(h.containsKey(pasture1) && h.containsKey(pasture2)) {
				if(h.get(pasture1) != h.get(pasture2)) {
					pasture1 = h.get(pasture1);
					pasture2 = h.get(pasture2);
					starters.remove(pasture2);
					h.put(pasture2, pasture1);
					linkedLists.get(pasture1).add(pasture2);
					Iterator<Integer> iter = linkedLists.get(pasture2).iterator();
					while(iter.hasNext()) {
						int connectedPasture = iter.next();
						h.remove(connectedPasture);
						h.put(connectedPasture, pasture1);
						linkedLists.get(pasture1).add(connectedPasture);
					}
					linkedLists.remove(pasture2);
				}
			}
			else if(h.containsKey(pasture1)) {
				linkedLists.get(h.get(pasture1)).add(pasture2);
				h.put(pasture2, h.get(pasture1));
			}
			else if(h.containsKey(pasture2)) {
				linkedLists.get(h.get(pasture2)).add(pasture1);
				h.put(pasture1, h.get(pasture2));
			}
			else {
				starters.add(pasture1);
				h.put(pasture2, pasture1);
				linkedLists.put(pasture1, new HashSet<Integer>());
				linkedLists.get(pasture1).add(pasture2);
			}
			
		}
		out.println(((int)Math.pow(10, N-h.size()))+"");
		out.close();
		f.close();
	}
}
