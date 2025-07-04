package week10.김누리.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * PackageName : week10.김누리.programmers
 * FileName    : 호텔_대실
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-03
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 03.     김누리(NRKim)               Initial creation
 */

/*
예약 시간 :

[
    ["15:00", "17:00"],
    ["16:40", "18:20"],
    ["14:20", "15:20"],
    ["14:10", "19:20"],
    ["18:20", "21:20"]
]

시작 시간 기준으로 오름차순을 한다면??

[
    ["14:10", "19:20"],
    ["14:20", "15:20"],
    ["15:00", "17:00"],

    ["16:40", "18:20"],
    ["18:20", "21:20"]
]

방 1 : ["14:10", "19:20"] : 입실
방 2 : ["14:20", "15:20"] : 입실
방 3 : ["15:00", "17:00"] : 입실

방 2 : ["14:20", "15:20"] : 퇴실 --> 10분 청소
방 2 : ["16:40", "18:20"] : 입실

방 3 : ["15:00", "17:00"] : 퇴실 --> 10분 청소
방 3 : ["18:20", "21:20"] : 입실

방 2 : ["16:40", "18:20"] : 퇴실 --> 10분 청소
방 1 : ["14:10", "19:20"] : 퇴실 --> 10분 청소

그러면 방을 우선순위 큐로 진행.

*/

public class 호텔_대실 {
	public int solution(String[][] book_time) {
		//  방
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int answer = 0;

		//  예약 시간 asc
		Arrays.sort(book_time,(a,b) -> a[0].compareTo(b[0]));

		for(String[] time : book_time) {
			int start = toMinute(time[0]); // 시작 시간 (분화)
			int end = toMinute(time[1]) + 10; // 종료 시간 + 청소시간 (분화)

			//  방이 비어 있거나, 이용 시간 종료하면 퇴실
			if(!pq.isEmpty() && pq.peek() <= start) {
				pq.poll();
			}

			//  새로 입실
			pq.offer(end);

			//  현재 이용중인 방의 갯수 반환
			answer = pq.size();
		}

		return answer;
	}

	private int toMinute(String time) {
		String[] parts = time.split(":");
		return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
	}
}
