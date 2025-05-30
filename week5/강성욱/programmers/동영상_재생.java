package week5.강성욱.programmers;

import java.time.*;

public class 동영상_재생 {
    //String 에서 LocalTime 변환 하는 로직을 추가하자.
    //시간 계산이 주로 있는데, LocalTime 을 사용하면 편함.
    //이거, 10초 전으로 이동해도, 만약 오프닝 위치라면, 오프닝 중간으로 들어갈 수 없음. 즉, 오프닝 중간으로 이동하는게 불가능.

    class Solution {
        private static final String ORDER_PREV = "prev";
        private static final String ORDER_NEXT = "next";

        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            LocalTime nowTime = convertToLocalTime(pos);
            LocalTime videoLen = convertToLocalTime(video_len);
            LocalTime opStart = convertToLocalTime(op_start);
            LocalTime opEnd = convertToLocalTime(op_end);

            int opStartSec = toSec(opStart);
            int opEndSec = toSec(opEnd);

            int nowSec = toSec(nowTime);
            if (nowSec >= opStartSec && nowSec <= opEndSec) {
                nowSec = opEndSec;
                nowTime = secToLocalTime(nowSec);
            }

            int videoLenSec = toSec(videoLen);

            for(String command : commands) {
                if (ORDER_PREV.equals(command)) {
                    nowSec = Math.max(0, nowSec - 10);
                } else if (ORDER_NEXT.equals(command)) {
                    nowSec = Math.min(videoLenSec, nowSec + 10);
                }
                nowTime = secToLocalTime(nowSec);

                if (nowSec >= opStartSec && nowSec <= opEndSec) {
                    nowSec = opEndSec;
                    nowTime = secToLocalTime(nowSec);
                }
            }

            return String.format("%02d:%02d", nowTime.getMinute(), nowTime.getSecond());
        }

        private LocalTime convertToLocalTime(String time) {
            String[] times = time.split(":");
            return LocalTime.of(0, Integer.parseInt(times[0]), Integer.parseInt(times[1]));
        }

        private int toSec(LocalTime t) {
            return t.getMinute() * 60 + t.getSecond();
        }

        private LocalTime secToLocalTime(int sec) {
            return LocalTime.of(0, sec / 60, sec % 60);
        }
    }
}
