/**
 * PackageName : week15.이상억.progarmmers;
 * FileName    : 시소_짝궁
 * Author      : sangeok
 * Date        : 2025. 08. 07.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 07.     sangeok               Initial creation
 */


// 중심으로부터 2,3,4 거리 지점에 좌석이 하나씩

// 두 명이 마주보고 탄다 했을 때 토크 크기가 상쇄 되어 균형을 이룬다면 ? -> 시소 짝궁
// 탑승한 사람의 무게, 시소 축과 좌석 간의 거리의 곱이 양 쪽다 같다면 시소 짝궁.


import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);

        Map<Double, Integer> map = new HashMap<>();

        long answer = 0;

        for (int w : weights) {
            double[] ratios = {1.0, 2.0 / 3.0, 1.0 / 2.0, 3.0 / 4.0};

            for (double r : ratios) {
                double key = w * r;
                if (map.containsKey(key)) {
                    answer += map.get(key);  // 이미 나온 짝꿍 수만큼 더함
                }
            }

            map.put((double) w, map.getOrDefault((double) w, 0) + 1);
        }
        return answer;
    }
}