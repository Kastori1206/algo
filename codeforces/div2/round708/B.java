package codeforces.div2.round708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * B. M-arrays
 * https://codeforces.com/contest/1497/problem/B
 */
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t =0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] count = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<N;i++) {
				int index = Integer.parseInt(st.nextToken());
				count[index%M]++;
			}
			int index = 1;
			int answer = 0;
			while(index<M) {
				int num = M-index;

				if(count[num]!=0&&count[index]!=0) {	
					if(index == num) {
						answer++;
					}else {
						int min = Math.min(count[index], count[num]);
						int maxIndex = index;
						int minIndex = num;
						if(count[index] < count[num]) {
							maxIndex = num;
							minIndex = index;
						}
						count[maxIndex] -= min;
						count[minIndex] -= min;
						answer++;
						if(count[maxIndex]>0) {
							count[maxIndex]--;
						}
						answer+= count[maxIndex];
						count[maxIndex] = 0;							
					}
				
				}else if(count[index]!=0){
					answer+=count[index];
					count[index] = 0;
				}
				index++;	
			}
			answer = count[0]>0 ? answer+1 : answer;
			System.out.println(answer);
		}
	}
}
