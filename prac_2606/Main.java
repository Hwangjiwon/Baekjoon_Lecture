package prac_2606;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 컴퓨터 수
		M = sc.nextInt(); // 연결 쌍의 수

		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int src = sc.nextInt();
			int dst = sc.nextInt();

			list[src].add(dst);
			list[dst].add(src);
		}

		dfs(1);
		System.out.println(cnt - 1);
	}

	public static void dfs(int src) {
		if (visited[src] == true)
			return;

		visited[src] = true;
		cnt++;
		for (int i = 0; i < list[src].size(); i++) {
			dfs(list[src].get(i));
		}
	}

}
