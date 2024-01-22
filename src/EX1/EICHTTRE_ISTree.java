package EX1;

import java.io.*;
import java.util.*;

public class EICHTTRE_ISTree {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int nTestcase = reader.nextInt();

		for (int i = 0; i < nTestcase; i++) {
			int count = 0;
			int nV = reader.nextInt();
			int nE = reader.nextInt();
			Vertex[] listVertext = readGraph(nV, nE);

			if (nE == nV - 1) {
				
				for (int j = 0; j < nV; j++) {
					if (listVertext[j].visited == false) {
						count++;
						dfs(listVertext[j]);
					}
				}
				if (count == 1) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}

	static void dfs(Vertex v) {
		v.visited = true;

		for (Vertex w : v.listOfVertices) {
			if (w.visited == false) {
				dfs(w);
			}
		}
	}

	static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];

		for (int i = 0; i < nVertices; i++) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nEdges; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();

			vertices[u].add(vertices[v]);
			vertices[v].add(vertices[u]);
		}

		return vertices;

	}

	static class Vertex {
		int id;
		boolean visited;
		public List<Vertex> listOfVertices = new ArrayList<>();

		public Vertex(int id) {
			this.id = id;
		}

		public void add(Vertex k) {
			if (!listOfVertices.contains(k)) {
				listOfVertices.add(k);
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