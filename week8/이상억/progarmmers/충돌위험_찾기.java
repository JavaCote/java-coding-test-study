/**
 * PackageName : week8.이상억.progarmmers;
 * FileName    : 충돌위험_찾기
 * Author      : sangeok
 * Date        : 2025. 6. 20.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 17.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]);
        }

        Map<Integer, Map<String, Integer>> timeToPositionCount = new HashMap<>();

        for (int[] route : routes) {
            List<int[]> path = new ArrayList<>();
            int time = 0;

            for (int i = 0; i < route.length - 1; i++) {
                int[] start = pointMap.get(route[i]);
                int[] end = pointMap.get(route[i + 1]);

                int r = start[0];
                int c = start[1];
                int er = end[0];
                int ec = end[1];

                while (r != er) {
                    path.add(new int[]{r, c});
                    r += (er > r) ? 1 : -1;
                }
                while (c != ec) {
                    path.add(new int[]{r, c});
                    c += (ec > c) ? 1 : -1;
                }
            }

            int[] last = pointMap.get(route[route.length - 1]);
            path.add(new int[]{last[0], last[1]});

            for (int[] pos : path) {
                String key = pos[0] + "," + pos[1];
                timeToPositionCount.putIfAbsent(time, new HashMap<>());
                Map<String, Integer> posCount = timeToPositionCount.get(time);
                posCount.put(key, posCount.getOrDefault(key, 0) + 1);
                time++;
            }
        }

        int dangerCount = 0;
        for (Map<String, Integer> map : timeToPositionCount.values()) {
            for (int count : map.values()) {
                if (count >= 2) {
                    dangerCount++;
                }
            }
        }

        return dangerCount;
    }
}
