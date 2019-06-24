package usaco.practice;
import java.io.*;
import java.util.*;

//2019 January Bronze 3

public class GuessTheAnimal2 {
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
		Collections.sort(characteristics);
		int yes = 0;
		ArrayList<String> remainingAnimals = characteristics.get(0).animals;
		while(remainingAnimals.size()>1 && characteristics.size()>0) {
			yes++;
			remainingAnimals = characteristics.get(0).animals;
			remainingCharacteristics.remove(characteristics.get(0).name);
			characteristics.remove(0);
			for(int i = 0; i < characteristics.size(); i++) {
				Characteristic c = characteristics.get(i);
				for(int a = 0; a < c.animals.size(); a++) {
					String s = c.animals.get(a);
					if(!remainingAnimals.contains(s)) {
						c.animals.remove(s);
					}
				}
			}
			Collections.sort(characteristics);
		}
		out.println(yes  +"");
		out.close();
		f.close();
	}
}
