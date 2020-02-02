package baek;

import java.util.Scanner;

public class baek15652 {
    static int[] a = new int[10];
    static StringBuilder go(int start, int index, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<m; i++) {
                sb.append(a[i]);
                if (i != m-1) sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        for (int i=start; i<=n; i++) {        
            a[index] = i;
            ans.append(go(i,index+1, n, m));
        }
        return ans;
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.print(go(1,0,n,m));
    }
}
