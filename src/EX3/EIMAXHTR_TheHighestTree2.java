package EX3;

import java.io.*;
import java.util.*;

public class EIMAXHTR_TheHighestTree2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int nV = reader.nextInt();
		int nE = nV - 1;
		int max = -1;
		int idMax = 0;

		Vertex[] vertices = readGraph(nV, nE);

		dfs(vertices[0]);

		for (Vertex vertex : vertices) {
			if (vertex.level > max) {
				max = vertex.level;
				idMax = vertex.id;
			}
			vertex.level = 0;
			vertex.visited = false;
		}

		int idMax2 = idMax;

		dfs(vertices[idMax]);
		max = -1;

		for (Vertex vertex : vertices) {
			if (vertex.level > max) {
				max = vertex.level;
				idMax = vertex.id;
			}

		}
		int idMaxResult = idMax;

		sb.append(Math.min(idMax2, idMaxResult) + " ").append(max + "\n");

		System.out.println(sb);

	}

	static void dfs(Vertex v) {
		v.visited = true;

		for (Vertex w : v.listOfLinks) {
			if (w.visited == false) {

				w.level = v.level + 1;

				dfs(w);
			}
		}
	}

	static Vertex[] readGraph(int nV, int nE) {
		Vertex[] vertices = new Vertex[nV];

		for (int i = 0; i < nV; i++) {
			vertices[i] = new Vertex(i);
		}

		for (int i = 0; i < nE; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();

			vertices[u].addLinks(vertices[v]);
			vertices[v].addLinks(vertices[u]);

		}
		return vertices;
	}

	static class Vertex {
		int id;
		int level;
		boolean visited;
		public List<Vertex> listOfLinks = new ArrayList<>();

		public Vertex(int id) {
			this.id = id;
		}

		public void addLinks(Vertex v) {
			if (!listOfLinks.contains(v)) {
				listOfLinks.add(v);
			}
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