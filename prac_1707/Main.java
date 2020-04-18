package prac_1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int K, V, E;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		K = Integer.parseInt(input[0]);

		for (int i = 0; i < K; i++) {
			input = br.readLine().split(" ");
			V = Integer.parseInt(input[0]);
			E = Integer.parseInt(input[1]);

			// 정점만큼 인접리스트 생성
			ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[V + 1];
			for (int j = 1; j <= V; j++) {
				graph[j] = new ArrayList<>();
			}
			
			// 양방향 연결
			for (int j = 0; j < E; j++) {
				input = br.readLine().split(" ");
				graph[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
				graph[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
			}
			
			
			
		}

		br.close();
	}

}
