package EX1;

import java.io.*;
import java.util.*;

public class EIUDFS1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int n = reader.nextInt();
		int m = reader.nextInt();

		Vertex[] graph = readGraph(n, m);
		for (int i = 1; i <= m; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();
			
		}
		System.out.println(sb);
	}

	static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices + 1];

		for (int i = 0; i < nVertices; i++) {
			vertices[i] = new Vertex(i);

		}

		for (int i = 0; i < nEdges; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();

			vertices[u].addAdjecentVertex(vertices[v]);
			vertices[v].addAdjecentVertex(vertices[u]);
			

		}

		for (int i = 0; i < nVertices; i++) {
			vertices[i].adjecentVertices.sort((v1, v2) -> Integer.compare(v1.id, v2.id));
		}

		return vertices;
		
	}

	static void dfs(Vertex v) {
		v.visited = true;
		sb.append(v.id + " ");
		for (Vertex w : v.adjecentVertices) {
			if (w.visited == false) {
				dfs(w);
			}
		}
	}

	static class Vertex {
		public int id;
		public boolean visited;
		public List<Vertex> adjecentVertices = new ArrayList();

		public Vertex(int id) {
			this.id = id;
		}

		public void addAdjecentVertex(Vertex vertex) {
			adjecentVertices.add(vertex);
		}

		public int getDegree() {
			return adjecentVertices.size();
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