
import java.io.*;
import java.util.*;

public class Check3 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int nTestcase = reader.nextInt();

		for (int i = 0; i < nTestcase; i++) {
			int nV = reader.nextInt();
			int nE = reader.nextInt();
			Vertex[] listLinks = readGraph(nV, nE);

			if (nE == nV - 1) {
				
			} else {

			}
		}
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