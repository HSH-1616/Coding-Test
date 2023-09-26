package com.programmers.level.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KakaoReportResult {
	public int[] solution(String[] id_list, String[] report, int k) {
		// 입출력 예
		id_list = new String[] { "muzi", "frodo", "apeach", "neo" };
		report = new String[] { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		k = 2;
		
		//answer배열 크기 지정
		int[] answer = new int[id_list.length];

		// 중복 제거
		// distinct() : 중복 요소를 제거하고 고유한 요소로 구성된 Stream을 반환
		report = Arrays.stream(report).distinct().toArray(String[]::new);

		// 신고 리스트
		Map<String, String> reportList = new HashMap<String, String>();

		// 신고 당한 횟수
		Map<String, Integer> reportCount = new HashMap<String, Integer>();

		// 메일 횟수
		Map<String, Integer> mail = new HashMap<String, Integer>();

		// 신고자,당한자를 신고 리스트 map에 넣기
		for (int i = 0; i < report.length; i++) {
			// 신고자 ID
			String reporterId = report[i].split(" ")[0];
			// 신고 당한자 ID
			String reportedId = report[i].split(" ")[1];

			if (reportList.get(reporterId) != null) {
				// 여러명 신고일때 " "붙여서 구분할수 있게 넣기
				reportList.put(reporterId, reportList.get(reporterId) + " " + reportedId);
			} else {
				// 최초신고 일때
				reportList.put(reporterId, reportedId);
			}
		}

		// 신고 당한 횟수 map에 넣기
		for (int i = 0; i < report.length; i++) {
			// 신고 당한자 ID
			String reportedId = report[i].split(" ")[1];

			if (reportCount.get(reportedId) != null) {
				// 기존 신고 횟수
				int count = reportCount.get(reportedId);
				// 여러번 신고 당할때
				reportCount.put(reportedId, count + 1);
			} else {
				// 최초 신고 당할때 +1
				reportCount.put(reportedId, 1);
			}
		}

		// 신고 리스트 map에서 정지된 사람 찾기
		for (String id : reportList.keySet()) {
			// 신고자 별로 신고한 사람 배열
			String[] reportedId = reportList.get(id).split(" ");

			for (int i = 0; i < reportedId.length; i++) {
				// 신고 횟수가 기준값 k이상일때 정지 처리
				if (reportCount.get(reportedId[i]) >= k) {
					// 신고자한테 신고 처리된 횟수 만큼 mail보내기
					if (mail.get(id) != null) {
						int count = mail.get(id);
						mail.put(id, count + 1);
					} else {
						mail.put(id, 1);
					}
				}
			}

		}

		// 메일map answer배열로 옴기기
		for (int i = 0; i < id_list.length; i++) {
			if (mail.get(id_list[i]) != null) {
				// 신고한 사람 mail보낼 횟수
				answer[i] = mail.get(id_list[i]);
			} else {
				// 신고 안한 사람은 0
				answer[i] = 0;
			}
		}

		System.out.println("신고 리스트 : " + reportList);
		System.out.println("신고 당한 횟수 : " + reportCount);
		System.out.println("메일 횟수 : : " + mail);

		return answer;
	}

}
