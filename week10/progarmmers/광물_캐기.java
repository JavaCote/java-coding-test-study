/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 광물_캐기
 * Author      : sangeok
 * Date        : 2025. 07. 02.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 02.     sangeok               Initial creation
 */

// 다이아몬드 곡괭이 , 철 곡괭이, 돌 곡괭이
// 한번에 5개를 캐야 함
// picks [ dia , iron, stone]

// 이거 일단 배열 5개씩 돌면서 광물 점수 계산 하면 될 듯

// 곡갱이 갯수 < minerals.length 를 고려 안하고 했다가 몇몇 테스트 케이스에서 실패했다.
// 그 후 계속 실패했는데 내가 point를 계산 할 때 임의로 5/3/1 을 했는데 이 부분에서 각 점수의 차가 크지 않아 point 정렬 할 때의 오류가 있었다.
// 위의 2가지 점 때문에 시간을 생각보다 꽤 많이 박았다.

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int len = minerals.length;

        int totalPicks = picks[0] + picks[1] + picks[2];            // 사용 가능한 총 곡괭이 수
        int maxgroups = Math.min((len + 4) / 5, totalPicks);        // 실제 채굴할 그룹 수
        int maxminerals = Math.min(len, totalPicks * 5);            // 실제 채굴할 광물 수

        int[] point = new int[maxgroups];

        //  필요한 만큼의 광물까지만 점수 계산
        for (int i = 0; i < maxminerals; i++) {
            if (minerals[i].equals("diamond")) point[i / 5] += 25;
            else if (minerals[i].equals("iron")) point[i / 5] += 5;
            else point[i / 5] += 1;
        }

        //  채굴 그룹 생성 및 우선순위 정렬
        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < maxgroups; i++) {
            groups.add(new int[]{i, point[i]});
        }
        groups.sort((a, b) -> b[1] - a[1]);       // 난이도 내림차순

        //  곡괭이 우선순위에 따라 그룹 채굴
        for (int[] g : groups) {
            if (picks[0] > 0) {
                answer += mine(minerals, g[0], 0);
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += mine(minerals, g[0], 1);
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += mine(minerals, g[0], 2);
                picks[2]--;
            } else break;
        }

        return answer;
    }

    //  피로도 계산 함수
    public int mine(String[] minerals, int groupIndex, int pickType) {
        int fatigue = 0;
        int start = groupIndex * 5;
        int end = Math.min(minerals.length, start + 5);

        for (int i = start; i < end; i++) {
            String m = minerals[i];

            if (pickType == 0) { // 다이아
                fatigue += 1;
            } else if (pickType == 1) { // 철
                if (m.equals("diamond")) fatigue += 5;
                else fatigue += 1;
            } else if (pickType == 2) { // 돌
                if (m.equals("diamond")) fatigue += 25;
                else if (m.equals("iron")) fatigue += 5;
                else fatigue += 1;
            }
        }
        return fatigue;
    }
}