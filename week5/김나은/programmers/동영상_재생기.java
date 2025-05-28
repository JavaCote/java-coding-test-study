package week5.김나은.programmers;

public class 동영상_재생기 {

    class Solution {

        public String solution(String video_len, String pos, String op_start, String op_end,
                String[] commands) {
            // 문자열로 된 시간을 초 단위 정수로 변환
            int len_s = second(video_len);     // 전체 영상 길이 (초 단위)
            int current_s = second(pos);       // 현재 재생 위치 (초 단위)
            int op_start_s = second(op_start); // 오프닝 시작 시간 (초 단위)
            int op_end_s = second(op_end);     // 오프닝 종료 시간 (초 단위)

            // 현재 위치가 오프닝 구간이면 오프닝 종료 지점으로 이동
            if (current_s >= op_start_s && current_s <= op_end_s) {
                current_s = op_end_s;
            }

            // 명령어 배열을 하나씩 순회
            for (String command : commands) {
                if (command.equals("prev")) {
                    // "prev"인 경우 10초 전으로 이동 (단, 최소 0초까지)
                    current_s = Math.max(current_s - 10, 0);
                } else {
                    // "next"인 경우 10초 후로 이동 (단, 영상 길이 초과 금지)
                    current_s = Math.min(current_s + 10, len_s);
                }

                // 이동한 위치가 오프닝 구간에 들어왔다면 다시 오프닝 끝으로 이동
                if (current_s >= op_start_s && current_s <= op_end_s) {
                    current_s = op_end_s;
                }
            }

            // 최종 위치를 "MM:SS" 형식 문자열로 변환하여 반환
            String minute = String.format("%02d", current_s / 60);
            String second = String.format("%02d", current_s % 60);
            return minute + ":" + second;
        }

        // "MM:SS" 형식 문자열을 초 단위 정수로 변환하는 함수
        private static int second(String time) {
            String[] time_ms = time.split(":"); // "MM:SS" → ["MM", "SS"]
            return (Integer.parseInt(time_ms[0]) * 60) + Integer.parseInt(time_ms[1]);
        }
    }
}
