import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        long best = Long.MAX_VALUE;
        long ans1 = 0, ans2 = 0;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (Math.abs(sum) < best) {
                best = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.print(ans1 + " "+ ans2);
    }
}
