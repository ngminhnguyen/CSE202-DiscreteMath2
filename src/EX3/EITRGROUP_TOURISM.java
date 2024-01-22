package EX3;

import java.io.*;
import java.util.*;

public class EITRGROUP_TOURISM {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int nV = reader.nextInt();
		int nE = reader.nextInt();
		int levelOfTree = 0;
		Vertex[] listLinks = readGraph(nV, nE);

		for (int i = 0; i < nV; i++) {

			if (listLinks[i].isEmployess == false) {
				dfs(listLinks[i]);
				break;
			}
		}

		for (Vertex vertex : listLinks) {
			if (vertex.level > levelOfTree) {
				levelOfTree = vertex.level;
			}
		}
		System.out.println(levelOfTree + 1);
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
			vertices[v].isEmployess = true;
		}
		return vertices;

	}

	static class Vertex {
		int id;
		boolean visited;
		int level;
		boolean isEmployess;
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