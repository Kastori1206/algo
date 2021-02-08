package codeforces.div2.round700;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * B. The Great Hero
 */
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int[][] monsters = new int[n][2];
			
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<n;i++) {
				monsters[i][0] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<n;i++) {
				monsters[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(monsters, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[0] - o2[0];
				}
				
			});
			boolean flag = true;
			for(int i =0;i<n;i++) {
				int attack = monsters[i][0];
				int health = monsters[i][1];
				int count = 0;
				while(health>0 && y>0) {
					health-=x;
					y -= attack;
				}
				
				if(y<=0) {
					if(i==n-1 && health<=0) {
						flag = true;
						break;
					}
					flag = false;
					break;
				}
			}
			
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
