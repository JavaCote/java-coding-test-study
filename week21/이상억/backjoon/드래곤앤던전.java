/**
 * PackageName : week21.이상억.backjoon;
 * FileName    : 드래곤앤던전
 * Author      : sangeok
 * Date        : 2025. 09. 17.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 17.     sangeok               Initial creation
 */

// H_MaxHp : 용사의 최대 생명력 >= 1 -> 던전에 들어 간 이후 변함 없음
// H_CurHp : 현재 용사의 생명력. H_CurHp <= H_MaxHp
// H_Atk   : 용사의 공격력

// 던전 : N 개의 방 , i 번째 방을 통해서만 i + 1 번째 방
// N 번째 방에 공주 및 용 존재

// (1) t : 몬스터 방 , a : 몬스터의 공격력 , h : 몬스터의 체력
// (2) t : 포션 방, a : 증가할 공격력 , h : 회복할 체력

import java.util.*;
import java.io.*;

public class Main {

    static int N;          // 방 개수
    static long H_ATK;     // 초기 공격력
    static int[] t;        // 방 종류
    static long[] a;       // 공격력 or 포션 공격력 증가
    static long[] h;       // 체력 or 포션 회복량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H_ATK = Long.parseLong(st.nextToken());

        t = new int[N];
        a = new long[N];
        h = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            a[i] = Long.parseLong(st.nextToken());
            h[i] = Long.parseLong(st.nextToken());
        }

        long low = 1;
        long high = (long) 1e18;
        long answer = high;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (check(mid)) {
                answer = mid;
                high = mid - 1; //  더 작은 체력도 가능한지 확인
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // 초기 체력이 maxhp일 때 던전을 끝까지 버틸 수 있는지 검사
    public static boolean check(long maxhp) {
        long curhp = maxhp;
        long curatk = H_ATK;

        for (int i = 0; i < N; i++) {
            if (t[i] == 1) {
                long turns = (h[i] + curatk - 1) / curatk;
                long damage = (turns - 1) * a[i];          // 마지막 턴 반격 없음

                curhp -= damage;
                if (curhp <= 0) return false;
            } else {
                curatk += a[i];
                curhp = Math.min(maxhp, curhp + h[i]);
            }
        }

        return true;
    }
}
