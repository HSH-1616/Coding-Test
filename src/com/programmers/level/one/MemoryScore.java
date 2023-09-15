package com.programmers.level.one;

import java.util.HashMap;
import java.util.Map;

public class MemoryScore {	
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		//입출력 예
        name=new String[] {"may", "kein", "kain", "radi"};
        yearning =new int[] {5, 10, 1, 3};
        photo =new String[][] {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
		
		int[] answer = new int [photo.length];
        
		//이름과 점수를 담는 map생성
		Map<String,Integer> score= new HashMap<>();
		
		for(int i=0;i<name.length;i++) {
			score.put(name[i], yearning[i]);
		}
		
		//map에 이름 값이 있으면 점수를 합친뒤 answer 배열 에 추가
		for(int i=0;i<photo.length;i++) {			
			for(int j=0;j<photo[i].length;j++) {
				if(score.containsKey(photo[i][j])) {
					answer[i]+=score.get(photo[i][j]);
				}
			}
		}		
        
        return answer;
    }	
}