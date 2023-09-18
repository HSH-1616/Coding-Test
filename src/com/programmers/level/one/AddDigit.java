package com.programmers.level.one;

public class AddDigit {
	    public int solution(int n) {
	        int answer = 0;
	        
	        n=123;
//	        String num=String.valueOf(n);
//	        	        	        
//	        for(int i=0;i<num.length();i++){	        			        
//	        	answer+=Integer.parseInt(String.valueOf(num.charAt(i)));	            
//	        }
	        
	        while (n != 0) {
	            answer += n % 10;
	            n /= 10;
	        }
	        
	        return answer;
	    }
	
}
