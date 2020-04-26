package prac_14226;

/* 이모티콘
 * 
 * S개의 이모티콘 만들기
 * 복사하기 --> 이전내용 덮어쓰기
 * 붙여넣기 --> 클립보드의 모든 이모티콘 붙여넣기
 * 삭제하기 --> 이모티콘 중 하나 삭제
 * 
 * 현재 1개의 이모티콘 있는 상태
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int S;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		
		
		br.close();
	}

}
