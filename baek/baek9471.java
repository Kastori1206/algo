package baek;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 피사노 주기
 * https://www.acmicpc.net/problem/9471
 */
public class baek9471 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int P = Integer.parseInt(br.readLine());

        int cnt, a, b;
        for(int t = 0 ;t<P;t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            cnt = 0;
            a = b = 1;
            while(true){
                int temp = (a+b)%M;
                a = b;
                b = temp;
                cnt ++;

                if(a ==1 && b==1){
                    break;
                }
            }
            System.out.println(N + " " + cnt);

        }

    }
}
