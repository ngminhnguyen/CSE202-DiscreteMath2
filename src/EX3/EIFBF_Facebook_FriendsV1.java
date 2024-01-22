package EX3;

import java.io.*;
import java.util.*;

public class EIFBF_Facebook_FriendsV1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	static int countFemale = 0;
	static int countMale = 0;
	static int max = 0;

	public static void main(String[] args) {

		int n = reader.nextInt();
		int m = reader.nextInt();
		Vertex[] listOfAccount = readGraph(n, m);
		List<Sort> listIDMax = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (listOfAccount[i].visited == false) {
				dfs(listOfAccount[i]);
				Sort sort = new Sort(max, countFemale, countMale);
				listIDMax.add(sort);

				countFemale = 0;
				countMale = 0;
				max = 0;
			}

		}
		

		Collections.sort(listIDMax, (f1, f2) -> {
			int comparre = Integer.compare(f1.idMax, f2.idMax);
			return comparre;
		});

		for (Sort sort : listIDMax) {
			sb.append(sort.idMax + " ").append(sort.countMale + " ").append(sort.countFemale + "\n");
		}

		System.out.println(sb);
	}

	static class Sort {
		int idMax;
		int countFemale;
		int countMale;

		public Sort(int idMax, int countFemale, int countMale) {

			this.idMax = idMax;
			this.countFemale = countFemale;
			this.countMale = countMale;
		}

	}

	static void dfs(Vertex v) {
		v.visited = true;

		if (v.gender.equals("Nu")) {
			countFemale++;
		} else {
			countMale++;
		}

		if (max < v.id) {
			max = v.id;
		}

		for (Vertex w : v.listOfFriend) {
			if (w.visited == false) {
				dfs(w);
			}
		}
	}

	static Vertex[] readGraph(int idAccount, int idFriend) {
		Vertex[] vertices = new Vertex[idAccount];

		for (int i = 0; i < idAccount; i++) {
			String gender = reader.next();
			vertices[i] = new Vertex(i + 1, gender);
		}

		for (int i = 0; i < idFriend; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();

			vertices[u - 1].addFriend(vertices[v - 1]);
			vertices[v - 1].addFriend(vertices[u - 1]);
		}

		for (Vertex vertex : vertices) {
			vertex.listOfFriend.sort((f1, f2) -> Integer.compare(f1.id, f2.id));
		}
		return vertices;
	}

	static class Vertex {
		int id;
		String gender;
		boolean visited;
		public List<Vertex> listOfFriend = new ArrayList<>();

		public Vertex(int id, String gender) {
			this.id = id;
			this.gender = gender;
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