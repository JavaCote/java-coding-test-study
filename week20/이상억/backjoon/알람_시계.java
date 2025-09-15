/**
 * PackageName : week20.이상억.backjoon;
 * FileName    : 알람_시계
 * Author      : sangeok
 * Date        : 2025. 09. 10.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 10.     sangeok               Initial creation
 */

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken()); // 시
        int m = Integer.parseInt(st.nextToken()); // 분

        int totalMinutes = hToMinutes(h, m) - 45;

        if (totalMinutes < 0) {
            totalMinutes += 24 * 60;
        }

        int[] hm = minutesToHM(totalMinutes);

        System.out.println(hm[0] + " " + hm[1]);
    }

    public static int hToMinutes(int h, int m) {
        return h * 60 + m;
    }

    public static int[] minutesToHM(int m) {
        int[] result = new int[2];
        result[0] = (m / 60) % 24;
        result[1] = m % 60;
        return result;
    }
}
