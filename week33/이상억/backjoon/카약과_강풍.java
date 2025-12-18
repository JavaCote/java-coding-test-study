
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 전체 팀 수
        int S = Integer.parseInt(st.nextToken()); // 카약이 손상된 팀의 수
        int R = Integer.parseInt(st.nextToken()); // 가약을 더 가져온 팀의 수

        int[] broken = new int[S];
        int[] extra = new int[R];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            broken[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            extra[i] = Integer.parseInt(st.nextToken());
        }

        int[] team = new int[N + 1];

        for (int x : broken) team[x]--;
        for (int x : extra) team[x]++;

        for (int i = 1; i <= N; i++) {
            if (team[i] == -1) {
                if (i > 1 && team[i - 1] == 1) {
                    team[i]++;
                    team[i - 1]--;
                } else if (i < N && team[i + 1] == 1) {
                    team[i]++;
                    team[i + 1]--;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (team[i] == -1) answer++;
        }

        System.out.println(answer);
    }
}
