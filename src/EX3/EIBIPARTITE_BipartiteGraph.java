package EX3;

import java.io.*;
import java.util.*;

public class EIBIPARTITE_BipartiteGraph {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		int testCase = reader.nextInt();
		
		for (int i = 0; i < testCase; i++) {
			int nV = reader.nextInt();
			int vE = reader.nextInt();
			
			Vertex[] listOfLinks = readGraph(nV, vE);
			
			
		}
		
	

	}
	static void bfs(Vertex v) {
		Queue<Vertex> q = new ArrayDeque<>();
		q.add(v);
		v.visited=true;
		
		while (!q.isEmpty()) {
			Vertex w = q.poll();
			
			for (Vertex x : w.listLinks) {
				if (x.visited=false) {
					x.visited =true;
					q.add(x);
				}
			}
			
		}
	}
	static Vertex[] readGraph(int nV,int nE){
		Vertex[] vertices = new Vertex[nV];
		for (int i = 0; i < nV; i++) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nE; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();
			
			vertices[u].addLinks(vertices[v]);
			vertices[v].addLinks(vertices[u]);
		}
		return vertices;
	}
	static class Vertex{
		int id;
		boolean visited;
		public List<Vertex> listLinks = new ArrayList<>();
		
		public Vertex(int id) {
			this.id = id;
		}

		public void addLinks(Vertex v) {
			if (!listLinks.contains(v)) {
				listLinks.add(v);
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