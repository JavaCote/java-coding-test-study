/**
 * PackageName : week5.이상억.progarmmers;
 * FileName    : 동영상_재생기
 * Author      : sangeok
 * Date        : 2025. 5. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 29.     sangeok               Initial creation
 */

//문제 요구사항 :	제공하는 기능 => 10초 전으로 이동, 후로 이동, 오프닝 건너 뛰기
//			"prev" -> 현재 위치에서 -10초/ 10초 미만일 경우 처음 ( 0분 0초)
//			"next" -> 현재 위치에서 +10초/ 10초 미만으로 남을 경우 마지막 (= 동영상의 길이 )
//			"오프닝 건너뛰기" -> (op_start <= 현재 위치 <= op_end) 인 경우 자동으로 오프닝이 끝나는 구간
// video_len = 동영상 길이 나타내는 문자열
// pos : 기능이 수행되기 직전으 재생 위치 문자열
// op_start : 오프닝 시작 시간  /  op_end : 오프닝 끝나는 시간
// 사용자의 입력을 나타내는 문자열 배열 : commands
// 사용자의 입력이 모두 끝난 후 동영상의 위치를 " mm : ss " 형식으로 return

// 접근 방식 : (1)

import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videototalsec = timetoseconds(video_len);
        int possec = timetoseconds(pos);
        int opstartsec = timetoseconds(op_start);
        int opendsec = timetoseconds(op_end);

        possec = openingskip(possec, opstartsec, opendsec);

        for (String op : commands) {
            switch (op) {
                case "next":
                    possec = Math.min(videototalsec, possec + 10);
                    break;
                case "prev":
                    possec = Math.max(0, possec - 10);
                    break;
            }
            possec = openingskip(possec, opstartsec, opendsec);
        }

        return secondtotime(possec);
    }

    public static int timetoseconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static String secondtotime(int totalseconds) {
        return String.format("%02d:%02d", totalseconds / 60, totalseconds % 60);
    }

    public static int openingskip(int possec, int opstartsec, int opendsec) {
        if (possec >= opstartsec && possec <= opendsec) {
            return opendsec;
        }
        return possec;
    }
}
