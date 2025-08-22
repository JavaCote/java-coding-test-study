/**
 * PackageName : week17.이상억.backjoon;
 * FileName    : 랜선_자르기
 * Author      : sangeok
 * Date        : 2025. 08. 21.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 21.     sangeok               Initial creation
 */

// 모두 같은 크기로 잘라야 함

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 랜선 개수
        int n = Integer.parseInt(st.nextToken()); // 만들어야 할 조각 개수

        long[] len = new long[k];
        long maxLen = 0;
        for (int i = 0; i < k; i++) {
            len[i] = Long.parseLong(br.readLine().trim());
            if (len[i] > maxLen) maxLen = len[i];  // 최댓값 갱신

        }

        long lo = 1;
        long hi = maxlen;
        while(lo <= hi){
            long count = 0;
            mid = (lo + hi / 2);
            for(long le : len){
                count += (le/mid);
            }

            if( count >= n ){
                answer = mid;
                lo = mid +1;
            } else {
                hi = mid -1;
            }
        }
        return answer;
    }
}
