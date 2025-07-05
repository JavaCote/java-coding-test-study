/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 주차_요금_계산
 * Author      : sangeok
 * Date        : 2025. 07. 05.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 05.     sangeok               Initial creation
 */


// Hash 를 써서 주차 입출차를 등록하는게 무난해 보임

// fees[0] : 기본 시간 / fees[1] : 기본 요금 / fees[2] : 단위 시간 / fees[3] : 단위 요금
// 출차 안한 시간은 23:59 처리
// 요금 계산 시 올림

// 접근 방식 :  hash 사용해서 풀면 괜찮을듯

// 문제 조건들만 잘 파악하고 hash 로 풀면 할만했던 것 같음
// 10주차에 내가 호텔 대신 풀듯이 입차 때 + 1 / 출차 때 -1 을 두고 입출차를 관리해도 나쁘지 않을 것 같음


import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> carin = new HashMap<>();     // 차량 입차 시간
        Map<String, Integer> carout = new HashMap<>();  // 차량 누적 주차 시간

        for (String s : records) {
            String[] parts = s.split(" ");
            String time = parts[0];
            String car = parts[1];
            String action = parts[2];

            int minute = htm(time); // 시간 → 분

            if (action.equals("IN")) {
                carin.put(car, minute);
            } else {
                int intime = carin.remove(car);
                int duration = minute - intime;
                carout.put(car, carout.getOrDefault(car, 0) + duration);
            }
        }

        // 출차 안 한 차량은 23:59 기준으로 처리
        for (String car : carin.keySet()) {
            int inTime = carin.get(car);
            int duration = htm("23:59") - inTime;
            carout.put(car, carout.getOrDefault(car, 0) + duration);
        }

        // 차량 번호 오름차순 정렬
        List<String> cars = new ArrayList<>(carout.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];
        int idx = 0;

        for (String car : cars) {
            int time = carout.get(car);
            int fee = 0;

            if (time <= fees[0]) {
                fee = fees[1];
            } else {
                int extra = time - fees[0];
                int unit = (extra + fees[2] - 1) / fees[2];
                fee = fees[1] + unit * fees[3];
            }

            answer[idx++] = fee;
        }

        return answer;
    }

    public int htm(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }
}
