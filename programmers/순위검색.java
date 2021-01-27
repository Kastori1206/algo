package programmers;

import java.util.*;

public class 순위검색 {
	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		System.out.println(Arrays.toString(solution(info, query)));
	}
	static List<String> combiResult;
	public static int[] solution(String[] info, String[] query) {
		int N = info.length;
		HashMap<String, List<Integer>> table = new HashMap<>();
		for (int i = 0; i < N; i++) {
			List<Integer> scores = null;
			String[] temp = info[i].split(" ");
			String[] row = new String[5];
			for(int j =0;j<4;j++) {
				row[j] = temp[j];
			}
			row[4] = "-";
			int score = Integer.parseInt(temp[4]);
			
			System.out.println("row: " + Arrays.toString(row));
			for (int j = 0; j < temp.length; j++) {
				combiResult = new ArrayList<>();
				String[] result = new String[4];
				combi( 0, 0,j,row,result);
				for(String s : combiResult) {
					
					System.out.println(s);					
				}
//				for(int k = 0;k<combiResult.size();k++) {
//					List<String> list = new ArrayList<String>();
//					list.addAll(combiResult);
//					for(int l = )
//				}
			}
			System.out.println("===============================");

		}

		String[][] querys = new String[query.length][5];
		for (int i = 0; i < query.length; i++) {
			querys[i] = ((query[i].replace("and", "")).replace("  ", " ")).split(" ");
			String lng = querys[i][0];
			String skill = querys[i][1];
			String career = querys[i][2];
			String food = querys[i][3];
			String score = querys[i][4];

		}

		int[] answer = {};

		return answer;
	}
	private static void combi(int cur, int index,int r, String[] row,String[] result) {
		if(index ==r) {		
			StringBuilder temp = new StringBuilder();
//			for(int i =0;i<4;i++) {
//				if(result[i]==null) {
//					result[i] = "-";
//				}				
//			}
			temp.append(result[0]).append(" and ").append(result[1]).append(" and ").append(result[2]).append(" and ").append(result[3]).append(" and ");
			combiResult.add(temp.toString());
			return;
		}	
		for(int i=cur;i<row.length;i++) {
			result[index] = row[i];
			combi(i+1, index+1,r, row, result);
		}
	}
}
