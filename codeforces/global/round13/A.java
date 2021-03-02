package codeforces.global.round13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/*
 * A. K-th Largest Value
 */
public class A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        StringBuilder answer = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] cnt = new int[2];
        for(int i = 1; i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 0){
                cnt[0]++;
            }else{
                cnt[1]++;
            }
        }
 
        for(int i =0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int temp = Integer.parseInt(st.nextToken());
 
            if(t == 1 ){
                cnt[1 - arr[temp]] ++;
                cnt[arr[temp]]--;
                arr[temp] = 1 - arr[temp];
            }else{
                if(cnt[1] < temp){
                    answer.append("0\n");
                }else{
                    answer.append("1\n");
                }
            }
        }
 
        System.out.println(answer.toString());
 
    }
}