package EX3;

import java.io.*;
import java.util.*;

public class EIFOLTR2_INCayThuMuc2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	static Hashtable<String, Vertex> map = new Hashtable<>();

	public static void main(String[] args) {

		int n = reader.nextInt();
		int m = reader.nextInt();
		int q = reader.nextInt();

	}
	static void dfs(Vertex v) {
		
	}

	static void readGraph(int nV) {
		for (int i = 0; i < nV; i++) {
			String account = reader.next();
			String friend = reader.next();

			Vertex u = map.get(account);
			Vertex v = map.get(friend);

			if (u == null) {
				u = new Vertex(account);
				map.put(account, u);
			}
			if (v == null) {
				v = new Vertex(friend);
				map.put(friend, v);
			}

			u.addFriends(v);
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

		public void addFriends(Vertex v) {
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