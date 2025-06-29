package week10.김상진.programmers;

import java.util.ArrayList;
import java.util.List;

public class 광물_캐기 {
    // 테스트케이스 8번이 계속 틀림
    // 원인 분석 필요
    import java.util.*;

    class Solution {
        public int solution(int[] picks, String[] minerals) {
            int answer = 0;
            List<int[]> groups = new ArrayList<>();

            // 5개씩 그룹 나누기
            for (int i = 0; i < minerals.length; i += 5) {
                int dia = 0, iron = 0, stone = 0;
                for (int j = i; j < i + 5 && j < minerals.length; j++) {
                    if (minerals[j].equals("diamond")) dia++;
                    else if (minerals[j].equals("iron")) iron++;
                    else stone++;
                }
                groups.add(new int[]{dia, iron, stone});
            }

            // 그룹 정렬 (다이아 많은 순, 그 다음 철 많은 순)
            groups.sort((a, b) -> {
                if (b[0] != a[0]) return b[0] - a[0];
                else return b[1] - a[1];
            });

            int idx = 0;

            // 다이아곡괭이
            while (picks[0] > 0 && idx < groups.size()) {
                int[] g = groups.get(idx++);
                answer += g[0]*1 + g[1]*1 + g[2]*1;
                picks[0]--;
            }

            // 철곡괭이
            while (picks[1] > 0 && idx < groups.size()) {
                int[] g = groups.get(idx++);
                answer += g[0]*5 + g[1]*1 + g[2]*1;
                picks[1]--;
            }

            // 돌곡괭이
            while (picks[2] > 0 && idx < groups.size()) {
                int[] g = groups.get(idx++);
                answer += g[0]*25 + g[1]*5 + g[2]*1;
                picks[2]--;
            }

            return answer;
        }
    }


}
