package leetcode;

import java.util.*;

public class SpiralMatrix {
	public static void main(String[] args) {
//		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		List<Integer> result = new Solution().spiralOrder(matrix);
		for(Integer n : result) {
			System.out.print(n+ " ");
		}
	}
	static class Solution {
	    public List<Integer> spiralOrder(int[][] matrix) {
	    	List<Integer> result = new ArrayList<Integer>();
	    	int top =0;
	    	int down = matrix.length-1;
	    	int left = 0;
	    	int right = matrix[0].length-1;
	    	
	    	while(top <= down && left<=right) {
	    		//right
	    		for(int i= left;i<=right;i++) {
	    			result.add(matrix[left][i]);
	    		}
	    		top++;
	    		//down
	    		for(int i=top ; i<= down;i++) {
	    			result.add(matrix[i][right]);
	    		}
	    		right--;
	    		//left
	    		if(top<=down) {
	    			for(int i =right;i>=left;i--) {
	    				result.add(matrix[down][i]);
	    			}
	    			down--;
	    		}
	    		//up
	    		if(left<=right) {
	    			for(int i = down;i>=top;i--) {
	    				result.add(matrix[i][left]);
	    			}
	    			left++;
	    		}
	    	}
	    		
	    	return result;
	    }
	}
}
