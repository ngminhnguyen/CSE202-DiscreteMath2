package EX3;

import java.io.*;
import java.util.*;

public class EIGREENCITY_PlantStatistics {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int nV = reader.nextInt();
		int nE = nV - 1;
		int m = reader.nextInt();

		Vertex[] vertices = readGraph(nV, nE);
		dfs(vertices[m]);

		for (Vertex vertex : vertices) {
			sb.append(vertex.id + " ").append(vertex.level + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(Vertex v) {
		v.visited = true;

		for (Vertex w : v.listOfLinks) {
			if (w.visited == false) {
				dfs(w);
				v.level += w.level;
			}
		}
	}

	static Vertex[] readGraph(int nV, int nE) {
		Vertex[] vertices = new Vertex[nV];

		for (int i = 0; i < nV; i++) {

			vertices[i] = new Vertex(i);
		}

		for (int i = 0; i < nE; i++) {
			int a = reader.nextInt();
			int b = reader.nextInt();

			vertices[a].addLinks(vertices[b]);
		}

		for (int i = 0; i < nV; i++) {
			if (vertices[i].getSize() == 0) {
				int u = reader.nextInt();
				int v = reader.nextInt();

				vertices[u].level = v;
			}
		}

		return vertices;
	}

	static class Vertex {
		int id;

		boolean visited;
		int level;
		public List<Vertex> listOfLinks = new ArrayList<>();

		public Vertex(int id) {
			this.id = id;

		}

		public void addLinks(Vertex v) {
			if (!listOfLinks.contains(v)) {
				listOfLinks.add(v);
			}
		}

		public int getSize() {
			return listOfLinks.size();
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