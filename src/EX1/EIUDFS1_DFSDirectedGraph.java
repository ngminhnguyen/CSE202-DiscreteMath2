package EX1;

import java.io.*;
import java.util.*;

import EX1.EIHCON_IsThereAPath.Vertex;

public class EIUDFS1_DFSDirectedGraph {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int n = reader.nextInt();
		int m = reader.nextInt();

		Vertex[] arrayVertex = readGraph(n, m);

		dfs(arrayVertex[0]);
		System.out.println(sb);

	}

	static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];

		for (int i = 0; i < nVertices; i++) {
			vertices[i] = new Vertex(i);
		}
		
		for (int i = 0; i < nEdges; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();
//			vertices[v - 1].add(vertices[u - 1]);
			vertices[u].add(vertices[v]);
		}
		for (Vertex v : vertices) {
			v.adjacentVertices.sort((v1, v2) -> Integer.compare(v1.id, v2.id));
		}

		return vertices;
	}

	static void dfs(Vertex v) {
		v.visited = true;
		sb.append(v.id).append(" ");

		for (Vertex w : v.adjacentVertices) {
			
			if (w.visited == false) {
				dfs(w);
			}
		}
	}

	static class Vertex {
		int id;
		boolean visited;
		public ArrayList<Vertex> adjacentVertices = new ArrayList<>();

		public Vertex(int label) {
			this.id = label;
		}

		public void add(Vertex v) {
			if (!adjacentVertices.contains(v)) {
				adjacentVertices.add(v);
			}
		}

		public int getSizeArr() {
			return adjacentVertices.size();
		}

		@Override
		public String toString() {
			return id + "";
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Vertex) {
				return ((Vertex) obj).id == id;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return ((Integer) id).hashCode();
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