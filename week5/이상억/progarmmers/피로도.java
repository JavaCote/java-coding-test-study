/**
 * PackageName : week5.이상억.progarmmers;
 * FileName    : 피로도
 * Author      : sangeok
 * Date        : 2025. 5. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 29.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return max;
    }

    public void dfs(int currentfatigue, int[][] dungeons, boolean[] visited, int count) {

        max = Math.max(max, count);

        for (int i = 0; i < dungeons.length; i++) {
            int required = dungeons[i][0];
            int consumed = dungeons[i][1];

            if (!visited[i] && currentfatigue >= required) {
                visited[i] = true;
                dfs(currentfatigue - consumed, dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }
}
