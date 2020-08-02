package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class swea9760 {
	static List<Card> cards;
	static int[] rankCount;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int T = Integer.parseInt(br.readLine());
		for(int t =1 ;t<=T;t++) {
			String result = "";
			cards = new ArrayList<>(); 
			rankCount = new int[13+1];
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<5;i++) {
				String temp = st.nextToken();
				int rank =rankNum(temp.charAt(1));
				cards.add(new Card(temp.charAt(0),rank));
				rankCount[rank]++;
				if(max <rankCount[rank]) {
					max = rankCount[rank];
				}
			}
			Collections.sort(cards);
			
			if(isFlush()) {
				if(isStraight()) {
					result = "Straight Flush";
				}else {
					result = "Flush";
				}				
			}else if(max ==1 && isStraight()) {
				result = "Straight";
			}else if(max==4) {
				result ="Four of a Kind"; 
			}else if(max==3) {
				if(isFullHouse()) {
					result = "Full House";
				}else {
					result = "Three of a kind";
				}
			}else if(max ==2) {
				if(pair()==2) {
					result = "Two pair";							
				}else {
					result ="One pair";
				}
			}else {
				result = "High card";
			}		
			System.out.printf("#%d %s\n",t,result);
		}			
	}
	static boolean isFullHouse() {
		for(int i=1;i<14;i++) {
			if(rankCount[i] == 2) {
				return true;
			}
		}
		return false;
	}
	static boolean isStraight() {
		//연속된 수 
		if(cards.get(4).rank-cards.get(0).rank==4 ) {
			return true;
		//T,J,Q,K,A
		}else if(cards.get(1).rank ==10 && cards.get(4).rank-cards.get(1).rank==3 && cards.get(0).rank==1) {
			return true;
		}else {
			return false;			
		}
	}
	static boolean isFlush() {		
		for(int i=1;i<5;i++) {
			if(cards.get(0).suit != cards.get(i).suit) {
				return false;		
			}
		}
		return true;
	}
	static int pair() {
		int cnt =0;
		for(int i=1;i<14;i++) {
			if(rankCount[i] == 2) {
				cnt++;
			}
		}
		return cnt;
	}
	static int rankNum(char rank) {
		int num = 0;
		switch (rank) {
		case 'A':
			num = 1;
			break;
		case 'T':
			num = 10;
			break;
		case 'J':
			num = 11;
			break;
		case 'Q':
			num = 12;
			break;
		case 'K':
			num = 13;
			break;
		default:
			num = rank-'0';
			break;
		}
		return num;
	}
	
	static class Card implements Comparable<Card>{
		char suit;
		int rank;
		Card(char suit,int rank){
			this.suit = suit;
			this.rank = rank;
		}
		@Override
		public int compareTo(Card o) {			
			return this.rank - o.rank;
		}
		@Override
		public String toString() {
			return "Card [suit=" + suit + ", rank=" + rank + "]";
		}		
	}
}
