package leetcode;

import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {
		int[] digits = {1,2,3};
		System.out.println(Arrays.toString(new Solution().plusOne(digits)));
	}
	static class Solution { 
	    public int[] plusOne(int[] digits) {
//	    	int len = digits.length;
//	    	int carry = digits[len-1] ==9 ? 1:0;
//	    	String temp = (digits[len-1]+1)%10+"";
//	    			
//	        for(int i=len-2;i>=0;i--) {
//	        	if(digits[i]+carry>9) {
//	        		temp+= "0";
//	        		carry = 1;
//	        	}else {
//	        		temp+= digits[i]+carry;
//	        		carry = 0;
//	        	}
//	        }
//	        if(carry == 1) {
//	        	temp+=1 ;
//	        }
//	        int[] result = new int[temp.length()];
//	        int index = 0;
//	        for(int i =temp.length()-1;i>=0;i--) {
//	        	result[index++]= temp.charAt(i)-'0';
//	        }
//	        
//	        return result;
	    	
	    	int index = digits.length-1;
	    	int carry = 1;
	    	
	    	while(index >=0 && carry>0) {
	    		digits[index] = (digits[index]+1) %10;
	    		
	    		if(digits[index--] == 0) {
	    			carry=1;
	    		}else {
	    			carry=0;
	    		}
	    	}
	    	if(carry==1) {
	    		digits = new int[digits.length+1];
	    		digits[0] = 0;
	    	}
	    	
	    	return digits;
	    }
	}
}
