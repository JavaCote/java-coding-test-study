import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;

        // 모든 8x8 구간을 완전탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(answer, getRepaintCount(board, i, j));
            }
        }

        System.out.println(answer);
    }

    // 특정 구간에서 다시 칠해야 하는 최소 횟수 계산
    private static int getRepaintCount(char[][] board, int startRow, int startCol) {
        int repaintW = 0; // 왼쪽 위가 W인 경우
        int repaintB = 0; // 왼쪽 위가 B인 경우

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = board[startRow + i][startCol + j];

                // (i + j)가 짝수면 시작 색과 같아야 함
                if ((i + j) % 2 == 0) {
                    if (current != 'W') repaintW++;
                    if (current != 'B') repaintB++;
                } else { // (i + j)가 홀수면 반대색이어야 함
                    if (current != 'B') repaintW++;
                    if (current != 'W') repaintB++;
                }
            }
        }

        return Math.min(repaintW, repaintB);
    }
}
