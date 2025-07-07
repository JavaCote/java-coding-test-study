package week11;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week11
 * FileName    : 주차_요금_계산
 * Author      : Baekgwa
 * Date        : 2025-07-07
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-07     Baekgwa               Initial creation
 */
public class 주차_요금_계산 {
	//하루를 넘어가는 시간이 들어올 수 있나? -> 경우 없음, 모두 당일 처리
	//result 의 출력 순서는? -> 차량 번호가 작은 순서대로
	//같은 번호가 동시에 들어오고 (막 in, in), 없는 차량이 출차하고 그런경우는 없지만, 같은 차량이 여러번 들어왔다 나가는 경우는 있음.
	//출차 내역이 없다면, 23:59 기준으로 출차로 계산 할 것.

	class Solution {
		public int[] solution(int[] fees, String[] records) {
			Map<String, Integer> inHistoryMap = new HashMap<>(); //key : 자동차 번호, value : 들어온 시간 (분으로 처리)
			Map<String, Integer> totalTimeMap = new HashMap<>(); //key : 자동차 번호, value : 주차된 시간. (default 계산 안되어있음)

			for(String record : records) {
				String[] recordArray = record.split(" ");
				int timeMin = convertToMin(recordArray[0]);
				String carNumber = recordArray[1];
				String order = recordArray[2];

				if(order.equals("IN")) {
					inHistoryMap.put(carNumber, timeMin);
				} else if(order.equals("OUT")) {
					int inTime = inHistoryMap.remove(carNumber);
					int parkedTime = timeMin - inTime;
					totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkedTime);
				} else {
					throw new IllegalArgumentException("허용되지 않는 내역 입니다.");
				}
			}

			// 출차 정보가 없는 것, 23:59 기준으로 출차 요금 계산 필요.
			int endTime = convertToMin("23:59");
			for (Map.Entry<String, Integer> entry : inHistoryMap.entrySet()) {
				String carNumber = entry.getKey();
				int inTime = entry.getValue();
				int parked = endTime - inTime;
				totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parked);
			}

			return totalTimeMap.keySet().stream()
				.sorted()
				.mapToInt(carNumber -> calFee(totalTimeMap.get(carNumber), fees))
				.toArray();
		}

		private int convertToMin(String time) {
			String[] timeArray = time.split(":");
			return Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);
		}

		private int calFee(int totalMin, int[] fees) {
			int defaultMin = fees[0];
			int defaultFee = fees[1];
			int unitMin = fees[2]; //단위 시간(분)
			int unitFee = fees[3]; //단위 요금(원)

			if (totalMin <= defaultMin) {
				return defaultFee;
			} else {
				int extraTime = totalMin - defaultMin;
				int extraUnit = (int) Math.ceil((double) extraTime / unitMin);
				return defaultFee + extraUnit * unitFee;
			}
		}
	}
}
