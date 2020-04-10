package prac_1753;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int dest, value;

	Node(int dest, int value) {
		this.dest = dest;
		this.value = value;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if (this.value > o.getValue())
			return 1;
		else if (this.value == o.getValue())
			return 0;
		return -1;
	}
}

public class Main {
	static int V, E, K;
	static boolean[] visited;
	static int[] distance;
	static ArrayList<Node>[] list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);
		K = Integer.parseInt(br.readLine());

		visited = new boolean[V + 1];
		distance = new int[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			list[Integer.parseInt(input[0])].add(new Node(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
		}

		StringBuilder sb = new StringBuilder();
		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(distance[i] + "\n");
		}
		bw.write(sb.toString());
		br.close();
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int c = node.dest;
			
			if (visited[c] == true)
				continue;
			visited[c] = true;

			for (Node n : list[c]) {
				if (distance[n.dest] > distance[c] + node.value) {
					distance[node.dest] = distance[c] + node.value;
					pq.add(new Node(n.dest, distance[n.dest]));
				}
			}

		}
	}

}
