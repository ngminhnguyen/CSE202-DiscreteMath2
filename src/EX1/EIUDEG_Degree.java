package EX1;

import java.io.*;
import java.util.*;

public class EIUDEG_Degree {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int n = reader.nextInt();
		int m = reader.nextInt();

		Vertex[] arrayVertex = readGraph(n, m);

		for (int i = 0; i < n; i++) {
			sb.append(arrayVertex[i].getDegree()).append(" ");
		}
		System.out.println(sb);
	}

	static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];

		for (int i = 0; i < nVertices; i++) {
			vertices[i] = new Vertex(i + 1);
		}

		for (int i = 0; i < nEdges; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();
			vertices[v - 1].add(vertices[u - 1]);
			vertices[u - 1].add(vertices[v - 1]);
		}
		return vertices;
	}

	static class Vertex {
		int label;

		public ArrayList<Vertex> adjacentVertices = new ArrayList<>();

		public Vertex(int label) {
			this.label = label;
		}

		public void add(Vertex v) {
//			if (!adjacentVertices.contains(v)) {
//				adjacentVertices.add(v);
//			}
			adjacentVertices.add(v);
		}

		public int getDegree() {
			return adjacentVertices.size();
		}

		@Override
		public String toString() {
			return label + "";
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Vertex) {
				return ((Vertex) obj).label == label;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return ((Integer) label).hashCode();
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