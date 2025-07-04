/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 호텔_대실
 * Author      : sangeok
 * Date        : 2025. 07. 03.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 03.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<int[]> events = new ArrayList<>();

        for (String[] reservation : book_time) {
            int start = htm(reservation[0]);
            int end = htm(reservation[1]) + 10; // 청소시간 포함
            events.add(new int[]{start, 1});  // 시작 이벤트: +1
            events.add(new int[]{end, -1});   // 종료 이벤트: -1
        }

        // 시간 오름차순 정렬, 같은 시간일 경우 종료(-1)를 먼저 처리
        events.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // -1 먼저 처리
            return a[0] - b[0];
        });

        int rooms = 0;
        int maxrooms = 0;

        for (int[] event : events) {
            rooms += event[1];           // +1이면 방 하나 더 씀, -1이면 하나 반환
            maxrooms = Math.max(maxrooms, rooms);  // 최대 몇 개까지 동시에 필요했는지 저장
        }

        return maxrooms;  // 최댓값이 필요한 방 개수
    }

    // "HH:MM" → 분 단위로 변환
    public int htm(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }
}
