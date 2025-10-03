package week23.김나은.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집 {

    public class Main {

        public static void main(String[] args) throws IOException {
            // BufferedReader: 표준 입력(System.in)으로부터 한 줄씩 빠르게 읽기
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 찾고자 하는 방 번호 n 입력
            int n = Integer.parseInt(br.readLine());

            // 벌집의 시작점 (1번 방부터 시작)
            int start = 1;

            // 몇 겹(층)째인지 세기 위한 변수 (0부터 시작)
            int cnt = 0;

            // 무한 루프를 돌면서 겹을 늘려감
            while (true) {
                // start는 현재 겹의 마지막 번호
                // cnt가 0일 때는 start=1 (첫 방)
                // cnt가 1일 때는 start=7 (2겹의 마지막 방)
                // cnt가 2일 때는 start=19 (3겹의 마지막 방)
                start += (6 * cnt);

                // 현재 겹의 마지막 번호가 n 이상이면 그 겹에 속함
                if (start >= n) {
                    break;
                } else {
                    // 아직 도달 못했으면 겹을 하나 늘림
                    cnt++;
                }
            }

            // 겹 수(cnt는 0부터 세므로 +1)
            System.out.println(cnt + 1);
        }
    }
}