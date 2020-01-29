package swea.d2;

import java.util.Scanner;

public class swea1288 {   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T  = sc.nextInt();
      
      for(int test_case = 1; test_case <= T; test_case++){
         int N = sc.nextInt();
         int k= 1;
         int num;
         boolean[] check = new boolean[10];
         while(true) {
            num = N*k;
            while(num>0) {               
               check[num%10] = true;
               num/=10;                          
            }            
            if(isChk(check)) {
            	break;
            }
            k++;
         }
         System.out.println("#"+test_case+" "+N*k);
      }
   }
   static boolean isChk(boolean[] check) {
      for(int i =0;i<check.length;i++) {
         if(!check[i]) {
            return false;
      
         }
      }
      return true;
   }

}