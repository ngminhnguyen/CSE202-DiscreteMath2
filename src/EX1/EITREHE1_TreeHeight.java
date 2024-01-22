package EX1;

import java.io.*;
import java.util.*;

public class EITREHE1_TreeHeight {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int nVertices = reader.nextInt();
		int nEdges = nVertices - 1;
		Vertex[] listVertex = readGraph(nVertices, nEdges);

		bfs(listVertex[0]);

		int checkLevel = listVertex[0].level;

		for (int i = 1; i < nVertices; i++) {
			if (listVertex[i].level > checkLevel) {
				checkLevel = listVertex[i].level;
			}
		}
		System.out.println(checkLevel);

	}

	static void bfs(Vertex v) {
		Queue<Vertex> q = new ArrayDeque<>();
		q.add(v);
		v.visited = true;
		while (!q.isEmpty()) {
			Vertex w = q.poll();
			
			for (Vertex x : w.listOfVertices) {
				if (x.visited == false) {
					x.visited = true;
					x.level = w.level + 1;
					q.add(x);
				}
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
		for (Vertex v : vertices) {
			v.listOfVertices.sort((v1, v2) -> Integer.compare(v1.id, v2.id));
		}

		return vertices;

	}

	static class Vertex {
		public int id;
		public int level;
		public boolean visited;
		public List<Vertex> listOfVertices = new ArrayList<>();

		public Vertex(int id) {
			this.id = id;
		}

		public void add(Vertex v) {

			listOfVertices.add(v);

		}
		public int getDegree() {
			return listOfVertices.size();
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