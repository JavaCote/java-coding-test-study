package week23.김나은.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 좌표_정렬하기 {

    public class Main {

        public static void main(String[] args) throws IOException {
            // BufferedReader: 표준 입력(System.in)으로부터 한 줄씩 빠르게 읽기
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 좌표 개수 N 입력
            int N = Integer.parseInt(br.readLine());

            // 2차원 배열로 좌표 저장
            int[][] arr = new int[N][2];

            StringTokenizer st;
            // N개의 좌표를 입력받아 배열에 저장
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // x 좌표
                arr[i][1] = Integer.parseInt(st.nextToken()); // y 좌표
            }

            // 좌표 정렬 (Comparator 사용)
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] e1, int[] e2) {
                    if (e1[0] == e2[0]) { // 첫번째 원소가 같다면 두 번째 원소끼리 비교
                        return Integer.compare(e1[1], e2[1]);
                    } else { // x좌표 오름차순 정렬
                        return Integer.compare(e1[0], e2[0]);
                    }
                }
            });

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
            }
            System.out.println(sb);
        }
    }
}