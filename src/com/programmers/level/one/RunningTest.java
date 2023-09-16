package com.programmers.level.one;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RunningTest {
	    public String[] solution(String[] players, String[] callings) {
	    	//입출력 예
			players = new String[]{ "mumu", "soe", "poe", "kai", "mine" };
			callings = new String[]{ "kai", "kai", "mine", "mine" };
	    		    	
	    	String[] answer = {};

			//players배열 map으로 작성
			Map<String, Integer> player = new HashMap<>();
			//추월당한 사람을 구하는 map
			Map<Integer, String> player2 = new HashMap<>();

			for (int i = 0; i < players.length; i++) {
				player.put(players[i], i);
				player2.put(i, players[i]);
			}
			
			for (int i = 0; i < callings.length; i++) {
				
				//추월한 선수 순위
				int rank = player.get(callings[i]);				
				//rank-1로 추월당한 선수 이름 구하기
				String name = player2.get(rank - 1);
				
				//추월한 선수를 앞으로
				player.put(callings[i], rank - 1);
				//추월당한 선수를 뒤로
				player.put(name, rank);
				
				//추월당한 선수를 구하기 위해 player2도 정렬
				player2.put(rank - 1, callings[i]);
				player2.put(rank, name);
			}
			
			//Collection을 사용해서 map을 배열으로
			Collection<String> result = player2.values();
			answer = result.toArray(new String[0]);
            
	        return answer;        
	    }	    
	}