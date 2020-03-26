package prac_2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int M, N, K;
	static int[][] map;
	static boolean[][] vistied;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);

		
		br.close();
	}

}
