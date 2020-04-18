package prac_1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

			for (int j = 0; j < E; j++) {
				input = br.readLine().split(" ");
				
				
			}
		}

		br.close();
	}

}
