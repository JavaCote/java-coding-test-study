import java.io.*;
import java.util.*;

public class Main {

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = N - 1;
        while (i > 0 && arr[i - 1] < arr[i]) { // 오름차순 깨지는 구간
            i--;
        }

        if (i == 0) {
            System.out.println(-1);
            return;
        }

        int j = N - 1;
        while (arr[j] > arr[i - 1]) { // 내림차순 깨지는 구간
            j--;
        }

        swap(arr, i - 1, j);

        reverse(arr, i, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < N; k++) {
            sb.append(arr[k]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
