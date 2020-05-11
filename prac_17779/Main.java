package prac_17779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 게리맨더링2
 * 
 * N * N을 5개의 구역으로 나눔
 * 
 * 기준점 x,y와 경계의 길이 d1,d2를 정한다
 * (d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N)
 * 
 * 5번구역의 경계선은 아래와 같다
 * (x, y), (x+1, y-1), ..., (x+d1, y-d1)
 * (x, y), (x+1, y+1), ..., (x+d2, y+d2)
 * (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
 * (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
 * 
 * 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
 * 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
 * 3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
 * 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
 * 
 * 인구가 가장 많은 선거구와 가장 적은 선거구의 차이의 최소값
 * 
 */
public class Main {
	static int N;
	static int[][] people;
	static int[][] map;

	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);

		people = new int[N + 1][N + 1];
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				people[i][j] = Integer.parseInt(input[j - 1]);
			}
		}

		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				for (int d1 = 1; d1 <= 2 * N; d1++) {
					for (int d2 = 1; d2 <= 2 * N; d2++) {
						// 기준점 x,y와 경계의 길이 d1,d2를 정한다
						// 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N
						if (x + d1 + d2 <= N && 1 <= y - d1 && y + d2 <= N) {
							setFive(x, y, d1, d2);
						}
					}
				}
			}
		}

		br.close();
	}

	/*
	 * 5번구역의 경계선은 아래와 같다 
	 * (x, y), (x+1, y-1), ..., (x+d1, y-d1) 
	 * (x, y), (x+1, y+1), ..., (x+d2, y+d2) 
	 * (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
	 * (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
	 */
	public static void setFive(int x, int y, int d1, int d2) {
		//경계선
		for (int i = 0; i <= d1; i++) {
			map[x + i][y - i] = 5;
		}

		for (int i = 0; i <= d2; i++) {
			map[x + i][y + i] = 5;
		}

		for (int i = 0; i <= d2; i++) {
			map[x + d1 + i][y - d1 + i] = 5;
		}

		for (int i = 0; i <= d1; i++) {
			map[x + d2 + i][y + d2 - i] = 5;
		}
		
		
		//경계선 안쪽 5선거구
		
	}
	
	
}
