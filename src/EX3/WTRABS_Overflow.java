package EX3;

import java.io.*;
import java.util.*;

public class WTRABS_Overflow {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = n - 1;
		

		Vertex[] listLinks = readGraph(n, m);
		dfs(listLinks[0]);

		for (Vertex vertex : listLinks) {
			if (vertex.water > 0 && vertex.getSize() == 0) {
				
				sb.append(vertex.id + " ").append(Math.round(vertex.water*10000)/10000d).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void dfs(Vertex v) {
		v.visited = true;
		int n =4;

		for (Vertex w : v.listOfLinks) {
			if (w.visited == false) {

				w.water += v.water / v.getSize();
				dfs(w);
			}
		}
	}

	static Vertex[] readGraph(int nV, int nE) {
		Vertex[] vertices = new Vertex[nV];

		for (int i = 0; i < nV; i++) {
			double water = reader.nextDouble();
			vertices[i] = new Vertex(i, water);
		}

		for (int i = 0; i < nE; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();

			vertices[v].addLinks(vertices[u]);
		}

		return vertices;
	}

	static class Vertex {
		int id;
		double water;
		boolean visited;
		public List<Vertex> listOfLinks = new ArrayList<>();

		public Vertex(int id, double water) {
			this.id = id;
			this.water = water;
		}

		public void addLinks(Vertex v) {
			if (!listOfLinks.contains(v)) {
				listOfLinks.add(v);
			}
		}

		public int getSize() {
			return listOfLinks.size();
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