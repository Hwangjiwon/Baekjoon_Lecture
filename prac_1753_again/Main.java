package prac_1753_again;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int to, value;

	Node(int to, int value) {
		this.to = to;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return value - o.value;
	}
}

public class Main {
	static int V, E, K;
	static int INF = 100_000_000;
	static List<Node>[] list;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");

		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);
		K = Integer.parseInt(br.readLine());

		list = new ArrayList[V + 1];
		dist = new int[V + 1];

		Arrays.fill(dist, INF);

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			list[Integer.parseInt(input[0])].add(new Node(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
		}

		StringBuilder sb = new StringBuilder();
		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF)
				sb.append("INF\n");
			else
				sb.append(dist[i] + "\n");

		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int cur = node.to;

			if (visited[cur] == true)
				continue;
			visited[cur] = true;

			for (Node n : list[cur]) {
				if (dist[n.to] > dist[cur] + n.value) {
					dist[n.to] = dist[cur] + n.value;
					pq.add(new Node(n.to, dist[n.to]));
				}
			}
		}

	}
}
