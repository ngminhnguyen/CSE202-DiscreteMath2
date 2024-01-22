package EX3;

import java.io.*;
import java.util.*;

public class EIPRF_Treasures {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
//	static List<Vertex> list = new ArrayList<>();

	public static void main(String[] args) {

		int nV = reader.nextInt();
		int nE = reader.nextInt();

		Vertex[] listLinks = readGraph(nV, nE);
		List<Vertex> listCycle = new ArrayList<>();

		dfs(listLinks[0], listCycle);

//		for (Vertex vertex : list) {
//			sb.append(vertex.id).append(" ");
//		}

//		for (Vertex vertex : listCycle) {
//			sb.append(vertex.id).append(" ");
//		}
		System.out.println(sb);
	}

	static void dfs(Vertex v, List<Vertex> listCycle) {
		v.visited = true;

		listCycle.add(v);

		for (Vertex w : v.listOfLinks) {
			if (w.visited == false) {
				dfs(w, listCycle);

			} else {
				if (listCycle.size() >= 3&&listCycle.contains(v)) {
					for (Vertex vertex : listCycle) {
						sb.append(vertex.id).append(" ");
					}
				}
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