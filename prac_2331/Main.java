package prac_2331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 반복수열
 * 
 * D[1] = A
 * D[n] = D[n-1]의 각 자리의 숫자를 P번 곱한 수들의 합
 * 
 * A = 57, P =2
 * D = 57, 5^2+7^2(25+49=74), 7^2+4^2(49+16=65), 6^2+5^2(36+25=61), ...)
 * D = 99999, 9^5+9^5+9^5+9^5+9^5
 */

public class Main {
	static int A, P;
	static int[] chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		A = Integer.parseInt(input[0]);
		P = Integer.parseInt(input[1]);
		// System.out.println(Math.pow(9, 5)*5);
		chk = new int[300000];

		System.out.println(dfs(A, 1));

		br.close();
	}

	public static int getNext(int num, int pow) {
		int next = 0;
		while (num > 0) {
			next += (int)Math.pow(num % 10, pow);
			num /= 10;
		}
		return next;
	}

	public static int dfs(int i, int cnt) {
		if (chk[i] != 0) {
			return chk[i] - 1;
		}
		chk[i] = cnt;
		int nxt = getNext(i, P);
		return dfs(nxt, cnt + 1);
	}
}
