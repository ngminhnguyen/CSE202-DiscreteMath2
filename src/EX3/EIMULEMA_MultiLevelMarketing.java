package EX3;

import java.io.*;
import java.util.*;

public class EIMULEMA_MultiLevelMarketing {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int nV = reader.nextInt();
		int nE = nV - 1;
		Vertex[] vertices = readGraph(nV, nE);
		dfs(vertices[0]);

		for (Vertex vertex : vertices) {
			sb.append(vertex.id + " ").append(vertex.profits + "\n");
		}

		System.out.println(sb);
	}

	static void dfs(Vertex v) {
		v.visited = true;

		v.profits = (int) (v.sales * 0.15);
//		v.sales = (int) (v.sales * 0.15);

		for (Vertex w : v.listOfLinks) {
			if (w.visited == false) {
				w.level++;
				dfs(w);

			}
			if (v.listOfLinks.size() > 0) {
//				v.sales += w.sales / 2;
				v.profits += w.profits / 2;
			}

		}

	}

	static Vertex[] readGraph(int nV, int nE) {
		Vertex[] vertices = new Vertex[nV];

		for (int i = 0; i < nV; i++) {
			int sales = reader.nextInt();
			vertices[i] = new Vertex(i, sales);
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
		int level;
		int sales;
		int profits;
		boolean visited;
		public List<Vertex> listOfLinks = new ArrayList<>();

		public Vertex(int id, int sales) {
			this.sales = sales;
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