package programmers;

/**
 * 최소직사각형
 * https://programmers.co.kr/learn/courses/30/lessons/86491
 */
public class 최소직사각형 {	
	public static void main(String[] args) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}}	;
		System.out.println(solution(sizes));
	}
	public static int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;
        for(int i =0;i<sizes.length;i++) {
        	int w = sizes[i][0];
        	int h = sizes[i][1];
        	
        	if(w <h) {
        		int temp = w;
				w = h;
				h = temp;
			}
        	
        	wMax = Math.max(wMax, w);
        	hMax = Math.max(hMax, h);
        }
        
        return wMax * hMax;
    }
}
