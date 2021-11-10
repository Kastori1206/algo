package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 여행 가자
 * https://www.acmicpc.net/problem/1976
 */
public class baek1976 {
	static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		p = new int[N+1];
		for(int i =1;i<=N;i++) {
			p[i] = i;
		}
		for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                int flag = Integer.parseInt(st.nextToken());
 
                if (flag==1) {
                    union(r, c);
                }
            }
        }
		
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int start = find(v);
		for(int i = 1; i<M;i++) {
			v = Integer.parseInt(st.nextToken());
			
			if(start != find(v)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
    public static int find(int x) {
        if (x == p[x]) {
            return x;
        }
 
        return p[x] = find(p[x]);
    }
 
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
 
        if (x != y) {
            if (x < y) {
                p[y] = x;
            } else {
                p[x] = y;
            }
        }
    }
}
