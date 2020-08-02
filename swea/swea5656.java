package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.InputMap;

/*
 * [모의 SW 역량테스트] 벽돌 깨기
 * 
 * 	1. 구술은
 * 		구슬이 떨어지는 위치에 따라 결과가 바꾸니다.
 * 
 * 	2. 벽돌의 파워에 의해 주변 벽돌이 제거 된다.
 * 		- 4방으로 영향력 받는 벽돌 제거
 * 		- 연쇄 작용은 모두 한꺼번에 동작
 * 		- 계속 파생되기 대문에 재귀로 작성하면 딱!
 * 		
 *	3. 빈 공간이 생기면 중력의 방향으로 아래로 떨어지낟.
 *		- 0
 *
 * 
 */
public class swea5656 {
	static StringBuffer sb = new StringBuffer();
	static int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
	
	static int T, N, C, R;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t =1;t<=T;t++) {
			
		}
		
	}
}
