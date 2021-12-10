package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 박스 채우기
 * https://www.acmicpc.net/problem/1493
 */

public class baek1493 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cubes = new int[N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			cubes[A] = B;
		}
		
		long prev = 0;
		long answer = 0;
		for(int i = N-1;i>=0;i--) {
			prev <<= 3;
			
			long check = (long)(L>>i) * (W>>i) * (H>>i) - prev;
			long cube = Math.min((long)cubes[i], check);
			
			prev += cube;
			answer += cube;
		}
		
		if(prev == (long) L * W * H) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}
	}
}
