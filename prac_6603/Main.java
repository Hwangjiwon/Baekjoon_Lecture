package prac_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int k;
	static int[] S;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] input = br.readLine().split(" ");
			k = Integer.parseInt(input[0]);
			
			if(k == 0)
				break;
			
			S = new int[k];
			visited = new boolean[k];

			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(input[i + 1]);
			}

			combi(0, 0, "");
			System.out.println();
		}
		
		br.close();
	}

	public static void combi(int cnt, int idx, String str) {
		if (cnt == 6) {
			System.out.println(str);
			return;
		}

		for (int i = idx; i < k; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			combi(cnt + 1, i, str + S[i] + " ");
			visited[i] = false;
		}
	}
}
