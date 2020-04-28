package prac_14226;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 0. 복사하기
 * 1. 붙여넣기
 * 2. 하나 삭제 
 */

class Node {
	int cnt, clip;

	Node(int cnt, int clip) {
		this.cnt = cnt;
		this.clip = clip;
	}
}

public class Main {
	static int S;
	static int time;
	static Queue<Node> q;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		S = Integer.parseInt(br.readLine());

		q = new LinkedList<>();
		visited = new boolean[1001][1001];

		bfs();
		bw.write(time + "");
		bw.close();
		br.close();
	}

	public static void bfs() {
		q.add(new Node(1, 0));
		visited[1][0] = true;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int k = 0; k < size; k++) {
				Node node = q.poll();

				int pcnt = node.cnt;
				int pclip = node.clip;

				if (S == pcnt)
					return;

				int ncnt = 0, nclip = 0;
				for (int i = 0; i < 3; i++) {
					if (i == 0) { // copy
						ncnt = pcnt;
						nclip = ncnt;
					} else if (i == 1) { // paste
						ncnt = pcnt + pclip;
						nclip = pclip;
						if (pclip <= 0 || ncnt > 1000 || visited[ncnt][nclip])
							continue;
						visited[ncnt][nclip] = true;

					} else { // delete
						ncnt = pcnt - 1;
						nclip = pclip;
						if (ncnt < 0 || visited[ncnt][nclip])
							continue;
						visited[ncnt][nclip] = true;
					}
					q.add(new Node(ncnt, nclip));
				}
			}
			time++;
		}
	}
}
