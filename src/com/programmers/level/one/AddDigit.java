package com.programmers.level.one;

public class AddDigit {
	    public int solution(int n) {
	        int answer = 0;
	        
	        n=123;
	        
	        //while문을 사용하여 형변환 없이 실행
	        while (n != 0) {
	        	//%10으로 나머지 값 더하기
	            answer += n % 10;
	            
	            ///10으로 자리수 변경
	            n /= 10;
	        }
	        
	        return answer;
	    }
	
}
