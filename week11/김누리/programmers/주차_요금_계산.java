package week11.김누리.programmers;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * PackageName : week11.김누리.programmers
 * FileName    : 주차_요금_계산
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-06
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 06.     김누리(NRKim)               Initial creation
 */

/*
feeds = [180, 5000, 10, 600] // 요금
recoreds = [
    "05:34 5961 IN",
    "06:00 0000 IN",
    "06:34 0000 OUT",
    "07:59 5961 OUT",
    "07:59 0148 IN",
    "18:59 0000 IN",
    "19:09 0148 OUT",
    "22:59 5961 IN",
    "23:00 5961 OUT"
]

Map<String,Integer>inMap = new HashMap<>();  //  입차 map
Map<String,Integer>totalMap = new HashMap<>(); // 통합 map
Set<String> car = new HashSet<>(); // IO 차량 관리용 셋

//  자동차 별, 누적 주차 시간 계산
//  예 : 5961 >> (1차) 05:34에 들어와서 07:59에 나감.  2시간 25분 (145분) // (2차) 22:59에 들어와서 23:00에 나감. 1분 >> 총 146분 머무름.
for(String s : records) {
  String[]tmp = s.split(" ");
  String carNum = tmp[1];
  String time = toMin(tmp[0]);
  String io = tmp[2];

  car.add(carNum); // 차량별 중복 제거

  switch(io) {
    case "IN" :
      inMap.put(carNum, time); // 입차
      break;

    case "OUT" :
      int inTime = inMap.get(carNum);
      int totalTime = time - inTime;
      totalMap.put(carNum, totalMap.getOrDefault(carNum,0) + totalTime); //  차량별 누적 주차시간 계산
      inMap.remove(carNum);
      break;
  }
}

//  출차 기록 없는 차량 시간 계산
for (String s : inMap.keySet()) {
  int inTime = inMap.get(s);
  int totalTime = toMin("23:59") - inTime;

  totalMap.put(s, totalMap.getOrDefault(s,0) + totalTime); //  차량별 누적 주차시간 계산
}

//  요금표에 맞춰 차량 별 요금 게산.
//  int timeCal = map.get(차량번호) - feeds[0] < 0 ? 0 : map.get(차량번호) - feeds[0];
//  int feed = 기본요금 (fees[1]) + timeCal  x 단위 요금(feeds[3]);
//  answer[i] = feed;

*/

public class 주차_요금_계산 {
	public int[] solution(int[] fees, String[] records) {
		Map<String,Integer> inMap = new HashMap<>(); // 입차 기록용
		Map<String,Integer> totalMap = new HashMap<>(); // 최종 누적 시간 기록용

		//  차량 입출력 기록
		for(String r : records) {
			String[] tmp = r.split(" ");
			String carNum = tmp[1]; // 차량 번호
			int time = toMin(tmp[0]); // 입출력 시간
			String io = tmp[2]; // 입출력 구분

			switch(io) {
				case "IN" :
					inMap.put(carNum,time); // 입차 기록
					break;

				case "OUT" :
					int inTime = inMap.get(carNum); // 입차 시간
					int totalTime = time - inTime; // 주차 시간
					totalMap.put(carNum,totalMap.getOrDefault(carNum,0) + totalTime);
					inMap.remove(carNum);
			}
		}

		//  출차 안된 차량의 출차 처리
		for(String s : inMap.keySet()) {
			int inTime = inMap.get(s); //  출차 안된 차량의 입차 시간
			int totalTime = toMin("23:59") - inTime; //  출차 안된 차량의 출차시간을 23:59로 fix

			totalMap.put(s,totalMap.getOrDefault(s,0) + totalTime);
		}

		List<String> list = new LinkedList<>(totalMap.keySet());
		Collections.sort(list);

		int[] answer = new int[list.size()];
		int idx = 0;

		//  요금 계산.
		for(String carNum : list) {
			int basicTime = fees[0]; //  기본 시간 (분)
			int basicFee = fees[1];  //  기본 요금 (원)
			int unitTime = fees[2];  //  단위 시간 (분)
			int unitFee = fees[3];   //  단위 요금 (원)
			int targetTime = totalMap.getOrDefault(carNum,0);  //  대상 차량의 총 주차 시간

			int calTime = targetTime - basicTime;

			if( calTime <= 0 ) {
				//  기본시간 동안 주차
				answer[idx++] = basicFee;
			} else {
				//  기본시간을 초과한 경우
				int calFee = basicFee + (int)(Math.ceil((double)calTime / unitTime) * unitFee);
				answer[idx++] = calFee;
			}
		}

		return answer;
	}


	//  hh:mm >> minute 화
	private int toMin(String time) {
		String[] times = time.split(":");

		return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
	}
}
