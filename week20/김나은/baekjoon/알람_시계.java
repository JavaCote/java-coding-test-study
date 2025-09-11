package week20.김나은.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알람_시계 {

    public class Main {

        public static void main(String[] args) throws IOException {
            // BufferedReader: 표준 입력(System.in)으로부터 한 줄씩 빠르게 읽기
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // StringTokenizer: 공백 단위로 문자열을 나누어 토큰 형태로 관리
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 알람 맞춘 시각 H
            int hour = Integer.parseInt(st.nextToken());

            // 알람 맞춘 분 M
            int minute = Integer.parseInt(st.nextToken());

            // 분(minute)이 45보다 작은 경우
            if (minute < 45) {
                if (hour == 0) { // 현재 시간이 0시라면, "한 시간 전"은 23시가 됨 (하루 전으로 돌아감)
                    hour = 23;
                } else { // 0시가 아니면 그냥 시(hour)에서 1 빼기
                    hour -= 1;
                }
                minute = 60 - (45 - minute);
            } else {
                minute -= 45;
            }
            System.out.println(hour + " " + minute);
        }
    }
}