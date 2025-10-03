package week23.김나은.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집 {

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int start = 1;
            int cnt = 0;

            while (true) {
                start += (6 * cnt);
                if (start >= n) {
                    break;
                } else {
                    cnt++;
                }
            }
            System.out.println(cnt + 1);
        }
    }
}