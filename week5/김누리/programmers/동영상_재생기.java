package week5.김누리.programmers;

/**
 * PackageName : week5.김누리.programmers
 * FileName    : 동영상_재생기
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-29
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 29.     김누리(NRKim)               Initial creation
 */

/*
pos : 기준이 되는 재생 위치
op_start : 오프닝 시작 시각
op_end : 오프닝 종료 시각

명령어 리스트
prev : 10초 전
next : 10초 후

*/

public class 동영상_재생기 {
	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		String answer = "";
		int videoLenSec = toSecond(video_len); //  비디오 총 길이
		int startSec = toSecond(op_start); //  오프닝 시작점
		int endSec = toSecond(op_end); //  오프닝 종료시점
		int current = toSecond(pos); //  기준점

		//  기준점 위치가 오프닝 범위 내에 있으면 오프닝 종료 이후 시점으로 이동
		if (current >= startSec && current <= endSec) {
			current = endSec;
		}

		//  명령어 처리
		for(String c : commands) {
			if(c.equals("next")) {
				current += 10;
			} else if (c.equals("prev")) {
				current -= 10;
			}

			//  명령어 처리 했을 때 시점이 00:00 이하일 때.
			if(current < 0) current = 0;

			//  명령어 처리 했을 때 시점이 비디오 종료 시점을 넘을 경우
			if(current > videoLenSec) current = videoLenSec;

			//  명령어 처리 했을 때 시점이 오프닝 범위 내에 있을 때
			if (current >= startSec && current <= endSec) current = endSec;
		}

		answer = String.format("%02d:%02d", current / 60, current % 60);

		return answer;
	}

	//  시간 포맷 >> 초로 변환
	private int toSecond(String time) {
		String[] parts = time.split(":");
		int m = Integer.parseInt(parts[0]);
		int s = Integer.parseInt(parts[1]);

		return m * 60 + s;
	}
}
