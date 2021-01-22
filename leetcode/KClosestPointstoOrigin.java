package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
	public static void main(String[] args) {
		int[][] points = {{3,3},{5,-1},{-2,4}};
		int K = 2;
		int[][] result = new Solution().kClosest(points, K);
		for(int[] point : result) {
			System.out.println("["+point[0] +","+point[1]+"]");
		}
	}
	static class Solution { 
	    public int[][] kClosest(int[][] points, int K) {
			PriorityQueue<int[]> pq = new PriorityQueue<>(points.length, new Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {		
					return Integer.compare(a[0]*a[0] + a[1]*a[1], b[0]*b[0] + b[1]*b[1]);
				}

			});
			for (int i = 0; i < points.length; i++) {
				pq.add(points[i]);
			}
			int[][] result = new int[K][2];
	        
	        for(int i =0;i<K;i++){
	            result[i] = pq.poll();
	        }	       
	                                                      
	        return result;
	    }
	}
}
