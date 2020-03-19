package prac_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Dot {
	int x, y, z;

	Dot(int z, int y, int x) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int M, N, H;
	static int[][][] box;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, 0, -1, 1, 0 };
	static int[] dy = { 0, -1, 1, 0, 0, 0 };
	static int[] dz = { -1, 0, 0, 0, 0, 1 };
	static Queue<Dot> tomato = new LinkedList<>();
	static int day;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		H = Integer.parseInt(input[2]);

		box = new int[H][N][M];
		visited = new boolean[H][N][M];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					box[k][i][j] = Integer.parseInt(input[j]);
					if (box[k][i][j] == 1) {
						tomato.add(new Dot(k, i, j));
					}
				}
			}
		}

		bfs();

		br.close();
	}

	public static void bfs() {
		while (!tomato.isEmpty()) {
			day++;

			int size = tomato.size();
			for (int j = 0; j < size; j++) {
				Dot d = tomato.poll();
				int px = d.x;
				int py = d.y;
				int pz = d.z;

				for (int i = 0; i < 6; i++) {
					int nx = px + dx[i];
					int ny = py + dy[i];
					int nz = pz + dz[i];

					if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H)
						continue;
					if (visited[nz][ny][nx])
						continue;
					if (box[nz][ny][nx] == 0) {
						visited[nz][ny][nx] = true;
						box[nz][ny][nx] = 1;
						tomato.add(new Dot(nz, ny, nx));
					}
				}
			}
		}
		System.out.println(chk(box) ? day - 1 : -1);
	}

	public static boolean chk(int box[][][]) {
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[k][i][j] == 0)
						return false;
				}
			}
		}
		return true;
	}

	public static void print(int box[][][]) {
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(box[k][i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
