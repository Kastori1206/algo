package swea.d4;

import java.util.Scanner;

/*
 * 1808 지희의 고장난 계산기
 */
public class swea1808 {
	static int[] nums;
	static int[] datas;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1 ;t <=T;t++) {
			nums = new int[10];
			for(int i = 0;i<10;i++) {				
				nums[i] = sc.nextInt();				
			}
			int x = sc.nextInt();			
			datas = new int[x+1];
			calc(x);
			int result = datas[x]+1;
			if(datas[x] == Integer.MAX_VALUE) {
				result = -1;
			}
			System.out.printf("#%d %d\n",t,result);
			
		}//test_case
	}//main
	 static int calc(int num) {
        if(datas[num] != 0) return datas[num];	        
        
        datas[num] = go(num);	        
        
        for (int i = 1; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                int num1 = calc(i);
                int num2 = calc(num/i);
                int result = num1+num2+1;
                if(num1 == Integer.MAX_VALUE || num2 == Integer.MAX_VALUE) {
                	result = Integer.MAX_VALUE;
                }
                datas[num] = Math.min(datas[num], result);
            }
        }	        
        return datas[num];
    }
	 static int go(int num) {
		 int cnt = 0;
		 while(num>0) {
			 int n = num%10;
			 if(nums[n]==0) {
				 return Integer.MAX_VALUE;
			 }
			 
			 num/=10;
			 cnt++;
		 }
		 return cnt;
	 }
}
