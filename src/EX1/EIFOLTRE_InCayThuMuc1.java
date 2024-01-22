package EX1;

import java.io.*;
import java.util.*;

public class EIFOLTRE_InCayThuMuc1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	static Hashtable<String, Vertex> map = new Hashtable<>();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = n - 1;
		readgraph(m);

		String root = reader.next();

		dfs(map.get(root));

		System.out.println(sb);

	}

	static void dfs(Vertex v) {
		v.visited = true;
		v.listOfFriend.sort((f1, f2) -> (f1.name.compareToIgnoreCase(f2.name)));

		sb.append("-");

		for (int i = 0; i < v.level; i++) {
			sb.append("---");
		}

		sb.append(v.name + "\n");

		for (Vertex w : v.listOfFriend) {
			if (w.visited == false) {
				w.level = v.level + 1;
				dfs(w);
			}
		}

	}

	static void readgraph(int nFriend) {

		for (int i = 0; i < nFriend; i++) {
			String u = reader.next();
			String v = reader.next();

			Vertex u1 = map.get(u);
			Vertex v1 = map.get(v);

			if (u1 == null) {
				u1 = new Vertex(u);
				map.put(u, u1);
			}

			if (v1 == null) {
				v1 = new Vertex(v);
				map.put(v, v1);
			}

			u1.addFriend(v1);
			v1.addFriend(u1);
		}

	}

	static class Vertex {
		String name;
		boolean visited;
		int level;
		public List<Vertex> listOfFriend = new ArrayList<>();

		public Vertex(String name) {
			this.name = name;
		}

		public void addFriend(Vertex v) {
			if (!listOfFriend.contains(v)) {
				listOfFriend.add(v);
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