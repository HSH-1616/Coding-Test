package com.programmers.level.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ParkWalking {
	public int[] solution(String[] park, String[] routes) {
		// 입출력 예
		park = new String[] { "OSO", "OOO", "OXO", "OOO" };
		routes = new String[] { "E 2", "S 3", "W 1" };

		int[] answer = {};
		
		//시작 위치 구하기
		int start[] = null;

		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[i].length(); j++) {
				if (park[i].charAt(j) == 'S') {
					start = new int[] { i, j };
				}
			}
		}
		
		//이동할 방향 Map에 입력 
		Map<Character, int[]> direction = new HashMap<>();

		direction.put('S', new int[] { 1, 0 });
		direction.put('N', new int[] { -1, 0 });
		direction.put('E', new int[] { 0, 1 });
		direction.put('W', new int[] { 0, -1 });
		
		//이동명령 for문
		for (String route : routes) {
			
			//이동할 방향좌표 
			int dy = direction.get(route.charAt(0))[0];
			int dx = direction.get(route.charAt(0))[1];
			
			//이동거리 
			int movement = Integer.parseInt(route.substring(2));
			
			//실시간 현재 위치
			int x = start[1];
			int y = start[0];
			
			//경로가 정상인지 판별
			boolean flag=true;
			
			//이동할 거리만큼 반복  "X"가 있을시 중단 
			for (int i = 0; i < movement; i++) {
				
				//현재 위치에 이동할 방향과 이동거리 입력
				x += dx;
				y += dy;
				
				//이동할 경로가 park를 벗어나면 중단
				if (x < 0 || y < 0 || x > park[0].length() - 1 || y > park.length - 1) {
					flag=false;
					break;
				}
				
				//이동할 경로에 "X"가 있을시 중단
				if (park[y].charAt(x) == 'X') {
					flag=false;
					break;
				}												
			}
			
			//정상 경로일시 현재 위치 저장
			if(flag) {
				start = new int[] { y, x };
			}
		}
 
		answer = start;

		return answer;
	}
}
