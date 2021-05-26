package programmers;

/*
 * 땅따먹기
 * https://programmers.co.kr/learn/courses/30/lessons/12913
 */
public class 땅따먹기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {
			{1,2,3,5},
			{5,6,7,8},
			{4,3,2,1}
		}));
	}

    public static int solution(int[][] land) {
    	int answer = Integer.MIN_VALUE;
    	for(int i =0;i<land.length-1;i++) {
    		for(int j=0;j<4;j++) {
    			int max = 0;
    			for(int k=0;k<4;k++) {
    				if(j==k) {
    					continue;
    				}
    				max = Math.max(max, land[i][k]);
    				
    			}
    			land[i+1][j]+=max;
    		}
    	}
    	for(int i =0;i<4;i++) {
    		answer = Math.max(answer, land[land.length-1][i]);
    	}
    	return answer;
    }
  
}
