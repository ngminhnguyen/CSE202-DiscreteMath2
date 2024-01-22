package EX1;

import java.io.*;
import java.util.*;

public class EIUSUFBF_FriendSuggestion {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int n = reader.nextInt();
		int m = reader.nextInt();
		int q = reader.nextInt();
		Facebook[] listAccount = readGraph(n, m);

		for (Facebook acc : listAccount) {
			sb.append(acc.idAccount).append(" ");
			acc.showFriend(q);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static Facebook[] readGraph(int nIDAcc, int nIDFriend) {
		Facebook[] account = new Facebook[nIDAcc];

		for (int i = 0; i < nIDAcc; i++) {
			account[i] = new Facebook(i);
		}

		for (int i = 0; i < nIDFriend; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();

			account[u].addFriend(account[v]);
			account[v].addFriend(account[u]);
		}
		for (Facebook fr : account) {
			fr.listOfFriends.sort((f1,f2)->Integer.compare(f1.idAccount, f2.idAccount));
		}

		return account;

	}

	static class Facebook {
		int idAccount;
		public List<Facebook> listOfFriends = new ArrayList<>();

		public Facebook(int idAccount) {
			this.idAccount = idAccount;
		}

		private void addFriend(Facebook friend) {
			if (!listOfFriends.contains(friend)) {
				listOfFriends.add(friend);
			}
		}

		public void showFriend(int q) {
			for (Facebook acc : listOfFriends) {
				if (acc.listOfFriends.size() < q) {
					sb.append(acc.idAccount).append(" ");
				}
			}
		}

		public int getSizeOfFriend() {
			return listOfFriends.size();
		}

		@Override
		public String toString() {

			return "Facebook [idAccount=" + idAccount + "]";
		}

		@Override
		public int hashCode() {
			return ((Integer) idAccount).hashCode();
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