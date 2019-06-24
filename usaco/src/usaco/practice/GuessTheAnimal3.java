package usaco.practice;
import java.io.*;
import java.util.*;

//2019 January Bronze 3

public class GuessTheAnimal3 {
	public static class Characteristic implements Comparable<Characteristic>{
		public String name;
		public ArrayList<String> animals = new ArrayList<String>();
		public Characteristic(String a) {
			name = a;
		}
		public int compareTo(Characteristic x) {
			return x.animals.size() - animals.size();
		}
	}
	
	public static int numOfYes(int index, ArrayList<Characteristic> remainingCharacteristics) {
		Characteristic c = remainingCharacteristics.get(index);
		if(c.animals.size() <= 1) {
			return 1;
		}
		ArrayList<Characteristic> characteristics = (ArrayList<Characteristic>) remainingCharacteristics.clone();
		characteristics.remove(c);
		int returner = 0;
		for(int i = 0; i < characteristics.size(); i++) {
			Characteristic c2 = characteristics.get(i);
			for(int a = 0; a < c2.animals.size(); a++) {
				String s = c2.animals.get(a);
				if(!c.animals.contains(s)) {
					c2.animals.remove(s);
				}
			}
		}
		Collections.sort(characteristics);
		for(int i = 0; i < Math.min(4,characteristics.size()); i++) {
			if(numOfYes(i, characteristics) + 1 > returner) {
				returner = numOfYes(i, characteristics) + 1;
			}
		}
		return returner;
	}
	
	public static void main(String[] args) throws IOException{
		String inpath = "guess.in";
		String outpath = "guess.out";
		String prepath = "C:\\Users\\nidhi\\eclipse-workspace\\usaco\\src\\usaco\\practice\\";
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		
		int N = Integer.parseInt(f.readLine());
		ArrayList<Characteristic> characteristics = new ArrayList<Characteristic>();
		HashMap<String, Characteristic> remainingCharacteristics = new HashMap<String, Characteristic>();
		
		for(int a = 0; a < N; a++) {
			String line = f.readLine();
			StringTokenizer st = new StringTokenizer(line);
			String animal = st.nextToken();
			int K = Integer.parseInt(st.nextToken());
			for(int b = 0; b < K; b++) {
				String characteristicName = st.nextToken();
				if(!remainingCharacteristics.containsKey(characteristicName)) {
					remainingCharacteristics.put(characteristicName, new Characteristic(characteristicName));
					characteristics.add(remainingCharacteristics.get(characteristicName));
				}
				Characteristic characteristic = remainingCharacteristics.get(characteristicName);
				characteristic.animals.add(animal);
			}
		}
		int yes = 0;
		Collections.sort(characteristics);
		for(int i = 0; i < Math.min(4,characteristics.size()); i++) {
			if(numOfYes(i, characteristics) > yes) {
				yes = numOfYes(i,characteristics);
			}
		}
		out.println(yes+"");
		out.close();
		f.close();
	}
}
