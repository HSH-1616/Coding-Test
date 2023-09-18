package com.programmers.level.one;

public class SumDivisor {
	public int solution(int n) {
		// 입출력 예
		n = 12;

		int answer = 0;
		
		// 약수는 √n을 기점으로 서로 짝을 이루기 때문에 √n까지만 반복문을 돌리면 코드가 더 효율적이다.

		// 제곱근 구하는 메소드 sqrt
		int root = (int) Math.sqrt(n);

		for (int i = 1; i <= root; i++) {
			if (n % i == 0) {
				//4나 16처럼 n/제곱근=제곱근인 경우에는 2번 더해지기에 예외처리 해준다.
				if(n/i==i) {					
					answer += i;
				}else {
					answer += n / i + i;
				}
				
			}
		}

		return answer;
	}
}
