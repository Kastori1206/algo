package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 합이 0인 네 정수
 * https://www.acmicpc.net/problem/7453
 */
public class baek7453 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] nums = new int[N][4];
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<4;j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
				
		int[] AB = new int[N*N];
		int[] CD = new int[N*N];
		for(int i =0;i<N;i++) {		
			for(int j =0;j<N;j++) {
				AB[i*N+j] = nums[i][0] + nums[j][1];
				CD[i*N+j] = nums[i][2] + nums[j][3];
			}
		}
		
		Arrays.sort(CD);
		
		long answer = 0;
		for(int i =0;i<N*N;i++) {
			int high = upperBound(CD, -AB[i]);
			int low = lowerBound(CD, -AB[i]);
			answer+= high -low;
		}
		System.out.println(answer);

	}
	  public static int lowerBound(int[] array,  int value) {
	        int low = 0;
	        int high = array.length;
	        int mid;
	        while (low < high) {
	        	mid = (low+high)>>1;
	        	if (value <= array[mid]) {
	                high = mid;
	            } else {
	                low = mid + 1;
	            }
	        }
	        return low;
	    }

	public static int upperBound(int[] array, int value) {
        int low = 0;
        int high = array.length;
        int mid;
        while (low < high) {
        	mid = (low+high) >> 1;
        	if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
