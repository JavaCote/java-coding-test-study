package week11.김상진.programmers

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class 주차_요금_계산 {
    import java.util .*;

    class Solution {

        public int[] solution(int[] fees, String[] records) {
            // 요금 정보 파싱: 기본 시간, 기본 요금, 단위 시간, 단위 요금
            int basicTime = fees[0];
            int basicFee = fees[1];
            int unitTime = fees[2];
            int unitFee = fees[3];

            // 차량별 입차 시간 저장 (차량번호 -> 입차 시각(분))
            Map<String, Integer> inTime = new HashMap<>();
            // 차량별 총 주차 시간 저장 (차량번호 -> 누적 주차 시간(분))
            Map<String, Integer> totalParkingTime = new HashMap<>();

            // 모든 주차 기록 순회 및 처리
            for (String record : records) {
                String[] parts = record.split(" ");
                int time = parseTimeToMinutes(parts[0]); // 시간을 분 단위로 변환
                String carNumber = parts[1];
                String type = parts[2]; // IN 또는 OUT

                if (type.equals("IN")) {
                    // 입차 기록인 경우, 입차 시간을 저장
                    inTime.put(carNumber, time);
                } else {
                    // 출차 기록인 경우, 입차 시간을 가져와 주차 시간 계산 및 누적
                    int startTime = inTime.remove(carNumber); // inTime에서 해당 차량 제거
                    int parkedDuration = time - startTime;

                    totalParkingTime.put(carNumber,
                        totalParkingTime.getOrDefault(carNumber, 0) + parkedDuration);
                }
            }

            // 23:59 (1439분)까지 출차 기록이 없는 차량들 처리
            // inTime 맵에 남아있는 차량들이 대상
            for (Map.Entry<String, Integer> entry : inTime.entrySet()) {
                String carNumber = entry.getKey();
                int startTime = entry.getValue();
                int parkedDuration = 1439 - startTime; // 23:59에서 입차 시간을 빼서 주차 시간 계산

                totalParkingTime.put(carNumber,
                    totalParkingTime.getOrDefault(carNumber, 0) + parkedDuration);
            }

            // 차량 번호 순서대로 정렬하기 위해 리스트로 변환 후 정렬
            List<String> sortedCarNumbers = new ArrayList<>(totalParkingTime.keySet());
            Collections.sort(sortedCarNumbers);

            // 최종 주차 요금을 저장할 배열
            int[] resultFees = new int[sortedCarNumbers.size()];
            // 정렬된 차량 번호 순서대로 요금 계산
            for (int i = 0; i < sortedCarNumbers.size(); i++) {
                String carNumber = sortedCarNumbers.get(i);
                int totalMinutes = totalParkingTime.get(carNumber);
                int currentFee = basicFee;

                // 추가 요금 계산
                if (totalMinutes > basicTime) {
                    int extraMinutes = totalMinutes - basicTime;
                    // 초과 시간에 대해 단위 요금 계산
                    currentFee += (int) Math.ceil((double) extraMinutes / unitTime) * unitFee;
                }
                resultFees[i] = currentFee;
            }

            return resultFees;
        }

        private int parseTimeToMinutes(String timeStr) {
            String[] parts = timeStr.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return hours * 60 + minutes;
        }
    }
}