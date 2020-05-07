package prac_16922;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 로마숫자만들기
 * 
 * 중복없는 수 ==> Set
 * 조합 ==> dfs, 재귀, idx 사용
 */

public class Main {
	static int N, sum;
	static int[] arr = { 1, 5, 10, 50 };
	static Set<Integer> result = new HashSet<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		dfs(0, 0, 0);
		System.out.println(result.size());
	}

	public static void dfs(int cnt, int idx, int sum) {
		if (cnt == N) {
			result.add(sum);
			return;
		}

		for (int i = idx; i < 4; i++) {
			dfs(cnt + 1, i, sum + arr[i]);
		}
	}
}
