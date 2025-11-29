import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N];
        int[] P = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());

        }

        int[] dp = new int[N+2];

        for(int i = 0; i < N; i++){
            int finish = i + T[i];

            dp[i+1] = Math.max(dp[i+1], dp[i]);

            if(finish <= N){
                dp[finish] = Math.max(dp[finish], dp[i] + P[i]);
            }
        }

        int answer = Math.max(dp[N],dp[N+1]);
        System.out.println(answer);

    }
}