/**
 * PackageName : week20.이상억.progarmmers;
 * FileName    : 우박수열_정적분
 * Author      : sangeok
 * Date        : 2025. 09. 09.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 09.     sangeok               Initial creation
 */



// 1-1) 2k -> 2k/2
// 1-2) 2k+1 -> (2k + 1) * 3 + 1
// result_value > 1 -> (1) result_value


import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {

        int[][] coords = Collatz_function(k);
        int n = coords.length - 1;

        // 구간별 면적 계산
        double[] areas = new double[n];
        for (int i = 0; i < n; i++) {
            int y1 = coords[i][1];
            int y2 = coords[i+1][1];
            areas[i] = (y1 + y2) / 2.0; // 사다리꼴 넓이
        }

        double[] prefix = new double[n+1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + areas[i-1];
        }


        double[] answer = new double[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1]; // end가 음수일 수도 있음

            if (start > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefix[end] - prefix[start];
            }
        }

        return answer;
    }


    public int[][] Collatz_function(int k) {
        List<int[]> list = new ArrayList<>();
        int a = k;
        int step = 0;

        list.add(new int[]{step, a}); // 시작 좌표 (0, k)

        while (a > 1) {
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a = a * 3 + 1;
            }
            step++;
            list.add(new int[]{step, a}); // 좌표 추가
        }

        int[][] array = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
