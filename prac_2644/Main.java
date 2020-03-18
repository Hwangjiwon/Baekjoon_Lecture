package prac_2644;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m;
	static int start, end;
	static int[][] list;
	static boolean[] visited;
	static boolean isfamily;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		start = sc.nextInt();
		end = sc.nextInt();
		m = sc.nextInt();

		visited = new boolean[n + 1];
		list = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int src = sc.nextInt();
			int dst = sc.nextInt();

			list[src][dst] = 1;
			list[dst][src] = 1;
		}

		bfs(start);
		if (isfamily == false) {
			System.out.println(-1);
		}

	}

	public static void bfs(int start) {
		Queue<Point> q = new LinkedList<>();

		q.add(new Point(start, 0));
		visited[start] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			int px = p.x;
			int pcnt = p.y;

			if (px == end) {
				isfamily = true;
				System.out.println(pcnt);
				return;
			}

			for (int i = 1; i <= n; i++) {
				if (list[px][i] == 1 && !visited[i]) {
					q.add(new Point(i, pcnt + 1));
					visited[i] = true;
				}
			}
		}

	}
}
