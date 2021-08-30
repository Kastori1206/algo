package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class 모음사전 {
    public static void main(String[] args) {
        System.out.println(solution("AAAE"));
    }

    static char[] vowels ={'A','E','I','O','U'};
    static List<String> list = new ArrayList<>();
    public static int solution(String word) {
        int answer = 0;
        for(int i =1;i<=5;i++){
            dfs(0,i,new char[i]);
        }
        Collections.sort(list);

        int start = 0;
        int end = list.size()-1;
        while (start <= end) {
            int mid = (end+start)/2;
            if (list.get(mid).equals(word)) {
                answer = mid+1;
                break;
            } else if (list.get(mid).compareTo(word)<0) {
                start++;
            }else{
                end--;
            }
        }

        return answer;
    }
    public static void dfs(int depth, int n,char[] res) {
        if (depth == n) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < n; i++) {
                temp.append(res[i]);
            }
            list.add(temp.toString());
            return;
        }

        for(int i=0;i<5;i++){
            res[depth] = vowels[i];
            dfs(depth + 1,n, res);
        }
    }
}

/**
 A
 AA
 AAA
 AAAA
 AAAAA
 AAAAE
 AAAAI
 AAAAO
 AAAAU
 AAAE
 AAAI
 AAAO
 AAAU
 AE


 */