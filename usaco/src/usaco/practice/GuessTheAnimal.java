package usaco.practice;
import java.io.*;
import java.util.*;

//2019 January Bronze 3

public class GuessTheAnimal {
	public static class Animal{
		public String name;
		public HashMap<String, Characteristic> characteristics = new HashMap<String, Characteristic>();
		public Animal(String s) {
			name = s;
		}
	}
	public static class Characteristic implements Comparable<Characteristic>{
		public String name;
		public HashMap<String, Animal> animals = new HashMap<String, Animal>();
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
		HashMap<String,Animal> remainingAnimals = new HashMap<String, Animal>();
		for(int a = 0; a < N; a++) {
			String line = f.readLine();
			StringTokenizer st = new StringTokenizer(line);
			String animalName = st.nextToken();
			Animal animal = new Animal(animalName);
			remainingAnimals.put(animalName,animal);
			int K = Integer.parseInt(st.nextToken());
			for(int b = 0; b < K; b++) {
				String characteristicName = st.nextToken();
				if(!remainingCharacteristics.containsKey(characteristicName)) {
					remainingCharacteristics.put(characteristicName, new Characteristic(characteristicName));
					characteristics.add(remainingCharacteristics.get(characteristicName));
				}
				Characteristic characteristic = remainingCharacteristics.get(characteristicName);
				animal.characteristics.put(characteristicName, characteristic);
				characteristic.animals.put(animalName, animal);
			}
		}
		Collections.sort(characteristics);
		int yes = 0;
		while(remainingAnimals.size()>1 && characteristics.size()>0) {
			yes++;
			remainingAnimals = (HashMap<String, Animal>) characteristics.get(0).animals.clone();
			remainingCharacteristics.remove(characteristics.get(0).name);
			characteristics.remove(0);
			for(Characteristic c : characteristics) {
				for(Map.Entry element : c.animals.entrySet()) {
					String thisKey = (String) element.getKey();
					if(!remainingAnimals.containsKey(thisKey)) {
						c.animals.remove(thisKey);
					}
				}
			}
			Collections.sort(characteristics);
		}
		out.println(yes+"");
		out.close();
		f.close();
	}
}
