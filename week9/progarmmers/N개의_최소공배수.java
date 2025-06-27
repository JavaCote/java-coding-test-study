/**
 * PackageName : week9.이상억.progarmmers;
 * FileName    : N개의_최소공배수
 * Author      : sangeok
 * Date        : 2025. 6. 26.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 26.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        // 각 소수의 최대 지수를 저장할 Map (LCM 계산용)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            // 현재 숫자의 소인수 분해 결과를 담은 Map
            Map<Integer, Integer> fymap = fx(i);
            for (int fy : fymap.keySet()) {
                int exponent = fymap.get(fy);
                // 기존에 저장된 지수와 비교하여 더 큰 값으로 갱신
                map.put(fy, Math.max(map.getOrDefault(fy, 0), exponent));
            }
        }

        int lcm = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int prime = entry.getKey();
            int exponent = entry.getValue();
            // LCM = 각 소수의 최대 지수만큼 곱한 값
            lcm *= Math.pow(prime, exponent);
        }

        answer = lcm;
        return answer;
    }

    // 소인수 분해 함수: n을 소인수로 분해하고, 소수와 그 지수를 Map으로 반환
    public static Map<Integer, Integer> fx(int n) {
        Map<Integer, Integer> fxmap = new HashMap<>();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                fxmap.put(i, fxmap.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }

        // n이 1보다 크면 그것도 소수임 (예: n이 소수일 경우)
        if (n > 1) {
            fxmap.put(n, fxmap.getOrDefault(n, 0) + 1);
        }

        return fxmap;
    }
}


// import java.util.*;
//
//class Solution {
//    public int solution(int[] arr) {
//        int lcm = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            lcm = lcm(lcm, arr[i]);
//        }
//        return lcm;
//    }
//
//    private int lcm(int a, int b) {
//        return a * b / gcd(a, b);
//    }
//
//    private int gcd(int a, int b) {
//        while (b != 0) {
//            int tmp = a % b;
//            a = b;
//            b = tmp;
//        }
//        return a;
//    }
//}