package baek;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 	1931. 회의실 배정
 * 	https://www.acmicpc.net/problem/1931
 */

public class baek1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] conferences = new int[n][2];
		for(int i=0;i<n;i++) {
			for(int j =0;j<2;j++) {
				conferences[i][j] = sc.nextInt();
			}
		}
		Arrays.sort(conferences, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// 끝나는 시간이 같은 경우 시작시간이 작은 순으로 정렬
				return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});

		int cnt =1;
		int temp = conferences[0][1];
		
		for(int i =1;i<n;i++) {
			if(temp <= conferences[i][0]) {
				temp = conferences[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
