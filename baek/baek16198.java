package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 에너지 모으기
 * https://www.acmicpc.net/problem/16198
 */
public class baek16198 {
	static int N, answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(num);
		}
		go(0, list);
		System.out.println(answer);
		
	}
	public static void go(int sum, List<Integer> list) {
		if(list.size() <=2) {
			answer = Math.max(answer, sum);
			return;
		}
		
		
		for(int i=1;i<list.size()-1;i++) {
			int num = list.get(i);
			int e = list.get(i-1) * list.get(i+1);
			list.remove(i);
			go(sum + e, list);
			list.add(i, num);			
		}
	}
	
}
