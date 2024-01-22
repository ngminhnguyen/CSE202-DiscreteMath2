package EX1;

import java.io.*;
import java.util.*;

public class EIMKF_MakeFriend {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	static int countAccount = 0;

	public static void main(String[] args) {

		int nOfAccounts = reader.nextInt();
		int nOfRelationships = reader.nextInt();

		Facebook[] arrOfAccount = readGraph(nOfAccounts, nOfRelationships);

		for (Facebook f : arrOfAccount) {
			sb.append(f.idOfAccount).append(" ").append(f.getSizeOfFriend()).append(" ");
			for (int i = 0; i < f.getSizeOfFriend(); i++) {
				sb.append(f.listOfAccout.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static Facebook[] readGraph(int nidAcc, int nidMakeFriend) {
		Facebook[] facebook = new Facebook[nidAcc];

		for (int i = 0; i < nidAcc; i++) {
			facebook[i] = new Facebook(i);
		}

		for (int i = 0; i < nidMakeFriend; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();

			facebook[v].add(facebook[u]);
			facebook[u].add(facebook[v]);
		}

		for (Facebook idFriend : facebook) {
			idFriend.listOfAccout.sort((p1, p2) -> Integer.compare(p1.idOfAccount, p2.idOfAccount));
		}
		return facebook;
	}

	static class Facebook {
		int idOfAccount;
		public List<Facebook> listOfAccout = new ArrayList<>();

		public Facebook(int idOfAccount) {
			this.idOfAccount = idOfAccount;
		}

		public void add(Facebook friend) {
			if (!listOfAccout.contains(friend)) {
				listOfAccout.add(friend);
			}
		}

		public int getSizeOfFriend() {
			return listOfAccout.size();
		}

		@Override
		public String toString() {
			return idOfAccount + "";
		}

		@Override
		public int hashCode() {
			return ((Integer) idOfAccount).hashCode();
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