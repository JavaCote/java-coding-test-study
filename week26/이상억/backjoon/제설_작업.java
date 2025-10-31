import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[][] A;
    static long[] rowSum, colSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new long[N][M];
        rowSum = new long[N];
        colSum = new long[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Long.parseLong(st.nextToken());
                rowSum[i] += A[i][j];
                colSum[j] += A[i][j];
            }
        }

        long left = 1;
        long right = 0;
        for (int i = 0; i < N; i++) right = Math.max(right, rowSum[i]);
        for (int j = 0; j < M; j++) right = Math.max(right, colSum[j]);

        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canClearAll(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canClearAll(long P) {
        for (int i = 0; i < N; i++) {
            if (rowSum[i] > P) {
                for (int j = 0; j < M; j++) {
                    if (colSum[j] > P && A[i][j] > 0) {
                        return false; // 해당 칸 제거 불가
                    }
                }
            }
        }
        return true;
    }
}
