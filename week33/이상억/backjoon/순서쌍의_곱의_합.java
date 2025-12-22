import java.util.*;
import java.io.*;

//         a1 a2 a3 a4
//                a1a2+a1a3+a1a4    a2a3+a2a4     a3a4
// a1(a2+a3+a4) , a2(a3+a4)
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        long result = 0;

        for (int i = 0; i < N; i++) {
            result += arr[i] * (sum - arr[i]);
            sum -= arr[i];
        }

        System.out.println(result);
    }
}
