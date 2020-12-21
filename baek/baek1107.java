package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 리모컨
 * https://www.acmicpc.net/problem/1107
 */
public class baek1107 {
	static String N;
	static int M,ans;
	static List<Integer> nums;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = br.readLine();						//N값
		M = Integer.parseInt(br.readLine());	//M값
		nums = new ArrayList<>();				//리모컨 사용할수있는 버튼 저장 리스트
		
		ans = Math.abs(Integer.parseInt(N) - 100);
		
		//사용할수있는 값 초기화
		for(int i =0;i<10;i++) {
			nums.add(i);
		}
		//사용 불가 버튼 제거
		if(M>0) {
			st = new StringTokenizer(br.readLine());
			
			for(int i =0;i<M;i++) {
				int n = Integer.parseInt(st.nextToken());
				nums.remove((Integer)n);
			}
			
		}
		
		//처음 값이 100이면
		if(Integer.parseInt(N)==100) {
			System.out.println(0);
			return;
		}
		
		int min = 0;
		int max = 0;

		if(nums.size()!=0) {
			min = nums.get(0);
			max = nums.get(nums.size()-1);
			String temp = "";
			//자리수 -1 의 최대로 만들수 있는 값
			if(N.length() !=1) {
				for(int i =0;i<N.length()-1;i++) {
					temp+=max;
				}			
				ans =Math.min(ans,Math.abs(Integer.parseInt(N) - Integer.parseInt(temp))+temp.length());
			}
			temp = "";
			//자리수 +1중 최소로 만들수 있는 값
			for(int i =0;i<N.length()+1;i++) {
				if(i==0 && nums.size()>1 && min==0) {
					temp += nums.get(1);
				}else {
					temp+=min;				
				}
			}
			ans =Math.min(ans,Math.abs(Integer.parseInt(N) - Integer.parseInt(temp))+temp.length());
		}		
		//N의 자리수에 가능한 수들을 찾아서 비교
		dfs(0,nums.size(),N.length(),"");
		System.out.println(ans);
	}
	private static void dfs(int index, int n, int r,String num) {
		if(r==0) {
			int result = Math.abs(Integer.parseInt(num)-Integer.parseInt(N))+N.length();
			ans = Math.min(result, ans);
			
			return;
		}
		for(int i =0;i<n;i++) {			
			if(r!=1 && index==0 && nums.get(i)==0) {
				continue;
			}			
			dfs(index+1, n,r-1,num+nums.get(i));
		}
	}
}
