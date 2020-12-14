package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * https://www.acmicpc.net/problem/5549
 * 행성탐사
 * DP + 구간합
 */
public class baek5549 {
	static int[][] jungle, osean, ice;
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		K = Integer.parseInt(br.readLine()); //좌표수

		ice = new int[N + 1][M + 1];
		jungle = new int[N + 1][M + 1];
		osean = new int[N + 1][M + 1];

		//각각 수를 저장
		for (int i = 1; i <= N; i++) {
			String temp = br.readLine();
			for (int j = 1; j <= M; j++) {
				if (temp.charAt(j - 1) == 'J') {
					jungle[i][j]++;
				} else if (temp.charAt(j - 1) == 'O') {
					osean[i][j]++;
				} else if (temp.charAt(j - 1) == 'I') {
					ice[i][j]++;
				}
			}
		}
		
		//누적 합 구하기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				jungle[i][j] += jungle[i][j - 1];
				osean[i][j] += osean[i][j - 1];
				ice[i][j] += ice[i][j - 1];
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				jungle[i][j] += jungle[i-1][j];
				osean[i][j] += osean[i-1][j];
				ice[i][j] += ice[i-1][j];
			}
		}
		
		//결과 구하기
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			int J = jungle[y2][x2] - jungle[y1-1][x2] - jungle[y2][x1-1] + jungle[y1-1][x1-1];
			int O = osean[y2][x2] - osean[y1-1][x2] - osean[y2][x1-1] + osean[y1-1][x1-1];
			int I = ice[y2][x2] - ice[y1-1][x2] - ice[y2][x1-1] + ice[y1-1][x1-1];
			
			System.out.println(J+" " + O + " " + I);
		}
	}
}
