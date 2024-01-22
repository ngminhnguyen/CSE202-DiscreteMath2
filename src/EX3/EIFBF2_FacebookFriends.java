package EX3;

import java.io.*;
import java.util.*;

public class EIFBF2_FacebookFriends {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	static int countMale = 0;
	static int countFemale = 0;
	static List<Integer> listLinks = new ArrayList<>();
	static Hashtable<Integer, String> map = new Hashtable<>();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = reader.nextInt();
		Vertex[] vertices = readGraph(n, m);

		for (int i = 0; i < n; i++) {
			dfs(vertices[i]);

			sb.append(vertices[i].id + " ").append(countMale + " ").append(countFemale + "\n");
			countFemale = 0;
			countMale = 0;
			
			for (int j = 0; j < n; j++) {
				if (vertices[j].visited == true) {
					vertices[j].visited = false;
				}
			}
		}
		System.out.println(sb);
	}

	static void dfs(Vertex v) {
		v.visited = true;

		if (v.gender.equals("Nu")) {
			countFemale++;
		} else {
			countMale++;
		}

		for (Vertex w : v.listOfLink) {
			if (w.visited == false) {
				dfs(w);
			}
		}
	}

	static Vertex[] readGraph(int nVertices, int nedges) {

		Vertex[] vertices = new Vertex[nVertices];

		for (int i = 0; i < nVertices; i++) {
			String gender = reader.next();
			vertices[i] = new Vertex(i + 1, gender);

		}

		for (int i = 0; i < nedges; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();

			vertices[u - 1].add(vertices[v - 1]);
			vertices[v - 1].add(vertices[u - 1]);
		}

		return vertices;

	}

	static class Vertex {
		int id;
		String coutBoth;
		boolean visited;
		String gender;

		public List<Vertex> listOfLink = new ArrayList<>();

		public Vertex(int id, String gender) {
			this.gender = gender;
			this.id = id;
		}

		public void add(Vertex v) {
			if (!listOfLink.contains(v)) {
				listOfLink.add(v);
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