package usaco.practice;
/*
ID: nidhirg1
LANG: JAVA
TASK: transform
*/
import java.io.*;
public class transform {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		int N = Integer.parseInt(f.readLine());
		String[][] square = new String[N][N];
		for(int i = 0; i<N; i++) {
			String row = f.readLine();
			for(int j = 0; j<N;j++) {
				square[i][j] = row.substring(j,j+1);
			}
		}
		String[][] tSquare = new String[N][N];
		for(int i = 0; i<N; i++) {
			String row = f.readLine();
			for(int j = 0; j<N;j++) {
				tSquare[i][j] = row.substring(j,j+1);
			}
		}
		String[][] hSquare = new String[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N;j++) {
				hSquare[i][j] = square[i][N-1-j];
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N;j++) {
				System.out.print(hSquare[i][j]);
			}
			System.out.println();
		}
		boolean yes = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(yes) {
				if(square[i][j].equals(tSquare[j][N-1-i])) {
					yes = true;
				}
				else {
					yes = false;
				}
			}
			}
		}
		if (yes) {
			out.write("1\n");
			out.close();
			f.close();
		}
		yes=true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {		
				if(yes) {
					if(square[i][j].equals(tSquare[N-1-i][N-1-j])) {
						yes = true;
					}
					else {
						yes = false;
					}
				}
			}
		}
		if (yes) {
			out.write("2\n");
			out.close();
			f.close();
		}
		yes = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(yes) {
				if(square[i][j].equals(tSquare[N-1-j][i])) {
					yes = true;
				}
				else {
					yes = false;
				}
				}
			}
		}
		if (yes) {
			out.write("3\n");
			out.close();
			f.close();
		}
		yes = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(yes) {
				if(tSquare[i][j].equals(hSquare[i][j])) {
					yes = true;
				}
				else {
					yes = false;
				}
			}
			}
		}
		if (yes) {
			out.write("4\n");
			out.close();
			f.close();
		}
		yes=true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(yes) {
				if(hSquare[i][j].equals(tSquare[j][N-1-i])) {
					yes = true;
				}
				else {
					yes = false;
				}
				}
			}
		}
		if (yes) {
			out.write("5\n");
			out.close();
			f.close();
		}
		yes = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (yes) {
				if(hSquare[i][j].equals(tSquare[N-1-i][N-1-j])) {
					yes = true;
				}
				else {
					yes = false;
				}
				}
			}
		}
		if (yes) {
			out.write("5\n");
			out.close();
			f.close();
		}
		yes = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (yes) {
				if(hSquare[i][j].equals(tSquare[N-1-j][i])) {
					yes = true;
				}
				else {
					yes = false;
				}
				}
			}
		}
		if (yes) {
			out.write("5\n");
			out.close();
			f.close();
		}
		yes = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(yes) {
				if(square[i][j].equals(tSquare[i][j])) {
					yes = true;
				}
				else {
					yes = false;
				}
			}
			}
		}
		if (yes) {
			out.write("4\n");
			out.close();
			f.close();
		}
		else {
			out.write("7\n");
			out.close();
			f.close();
		}
	}
}
