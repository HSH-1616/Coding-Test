package com.programmers.operator;

import java.util.Arrays;

import com.programmers.level.one.*;

public class Operator {
	public static void main(String[] args) {
		
		//Level 1		
		
		//달리기 경주 2023-09-14
		//String[] running=new RunningTest().solution(args, args); System.out.println(Arrays.toString(running));
		
		//추억 점수 2023-09-15
		//int[] memory=new MemoryScore().solution(null, null, null); System.out.println(Arrays.toString(memory));
		
		//공원 산책 2023-09-15
		//int[] park=new ParkWalking().solution(args, args); System.out.println(Arrays.toString(park));
		
		//약수의 합 2023-09-16		
		//int divisor=new SumDivisor().solution(0); System.out.println(divisor);
		
		//자리수 더하기 2023-09-16
		//int digit=new AddDigit().solution(0); System.out.println(digit); 
		
		//카카오 신고 결과 받기 2023-09-26
		int[] result=new KakaoReportResult().solution(args, args, 0); System.out.println(Arrays.toString(result));
	}
	
}
