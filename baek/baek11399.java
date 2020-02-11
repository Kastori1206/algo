package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek11399 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] p = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		int min = p[0];
		for(int i =1;i<N;i++) {
			p[i] += p[i-1];
			min += p[i];
		}
		System.out.println(min);
	}
}
