package EX3;

import java.io.*;
import java.util.*;

public class EIUSEFI2_TimKiemFile {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	static List<Vertex> list = new ArrayList<>();
	static Hashtable<String, Vertex> map = new Hashtable<>();

	public static void main(String[] args) {

		int nV = reader.nextInt();
		readGraph(nV);

		String root = reader.next();
		String find = reader.next();

		dfs(map.get(root), find);

		for (Vertex v : list) {

			if (v.count > 0 && v.getSize() > 1) {

				sb.append(v.nameFile + " ").append(v.count + "\n");
			}

		}

		System.out.println(sb);
	}

	static void dfs(Vertex v, String find) {

		v.visited = true;

		v.listOfFiles.sort((f1, f2) -> (f1.nameFile.compareTo(f2.nameFile)));

		for (Vertex w : v.listOfFiles) {
			if (w.visited == false) {
				dfs(w, find);

				if (w.nameFile.contains(find)) {
//					w.count++;
					v.count++;
				}
				v.count += w.count;
				
				

			}

		}
		list.add(v);

	}

	static void readGraph(int nV) {

		for (int i = 0; i < nV - 1; i++) {
			String file1 = reader.next();
			String file2 = reader.next();

			Vertex u = map.get(file1);
			Vertex v = map.get(file2);

			if (u == null) {
				u = new Vertex(file1);
				map.put(file1, u);
			}

			if (v == null) {
				v = new Vertex(file2);
				map.put(file2, v);
			}

			u.addFiles(v);
			v.addFiles(u);
		}
	}

	static class Vertex {
		String nameFile;
		boolean visited;
		int count;
		public List<Vertex> listOfFiles = new ArrayList<>();

		public Vertex(String nameFile) {
			this.nameFile = nameFile;
		}

		public void addFiles(Vertex v) {
			if (!listOfFiles.contains(v)) {
				listOfFiles.add(v);
			}
		}

		public int getSize() {
			return listOfFiles.size();
		}
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}