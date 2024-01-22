package EX1;

import java.io.*;
import java.util.*;

import EX1.EITREHE1_TreeHeight.Vertex;

public class EIUBFS2_BFSUndirectedGraph2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int n = reader.nextInt();
		int m = reader.nextInt();
		Vertex[] vertice = readGraph(n, m);

		bfs(vertice[0]);

		System.out.println(sb);
		
	}

	static void bfs(Vertex v) {
		Queue<Vertex> q = new ArrayDeque<>();
		q.add(v);
		v.visited = true;
		while (!q.isEmpty()) {
			Vertex w = q.poll();
			sb.append(w.id).append(" ");
			for (Vertex x : w.listOfVertices) {
				if (x.visited == false) {
					x.visited = true;
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
			v.listOfVertices.sort((v1,v2)->Integer.compare(v1.id, v2.id));
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

		public void add(Vertex v) {
			if (!listOfVertices.contains(v)) {
				listOfVertices.add(v);
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