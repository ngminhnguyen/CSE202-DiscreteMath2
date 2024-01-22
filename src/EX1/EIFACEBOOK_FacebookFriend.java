package EX1;

import java.io.*;
import java.util.*;

public class EIFACEBOOK_FacebookFriend {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int n = reader.nextInt();
		int m = reader.nextInt();

		Facebook[] listOfAccount = reaFacebook(n, m);

		for (Facebook acc : listOfAccount) {
			sb.append(acc.getSize()).append(" ");
		}
		System.out.println(sb);
	}

	static Facebook[] reaFacebook(int nidAcc, int nidMakeFriend) {

		Facebook[] account = new Facebook[nidAcc];

		for (int i = 0; i < nidAcc; i++) {
			String gender = reader.next();
			account[i] = new Facebook(i + 1, gender);

		}

		for (int i = 0; i < nidMakeFriend; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();

			account[u - 1].addFriend(account[v - 1]);
			account[v - 1].addFriend(account[u - 1]);
		}
		
		return account;

	}

	static class Facebook {
		public int id;
		String gender;

		public List<Facebook> listOfFriend = new ArrayList<>();

		public Facebook(int id, String gender) {
			this.id = id;
			this.gender = gender;
		}

		public void addFriend(Facebook friend) {
			if (!listOfFriend.contains(friend) && !friend.gender.equals(gender)) {
				listOfFriend.add(friend);
			}
		}
		
		public int getSize() {
			return listOfFriend.size();
			
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