package programmers;

/*
 * 징검다리건너기
 * https://programmers.co.kr/learn/courses/30/lessons/64062
 */
public class 징검다리건너기{
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.print(solution(stones, k));
    }
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max  = Integer.MIN_VALUE;

        for(int stone : stones){
            max = Math.max(max, stone);
            min = Math.min(min, stone);
        }

        return binarySearch(stones,k,min,max);
    }
    public static int binarySearch(int[] stones, int k, int left, int right){
        if(left == right){
            return left;
        }
        while(left<right){
            int mid = left+ (right - left)/2;

            if(check(stones, k, mid)){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left -1;
    }

    public static boolean check(int[] stones, int k, int mid){
        int cnt = 0;

        for(int stone : stones){
            if(stone - mid<0){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt==k){
                return false;
            }
        }
        return true;
    }
}
