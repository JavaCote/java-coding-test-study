import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int cameras = 1;
        int cameraPos = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > cameraPos) {
                cameras++;
                cameraPos = routes[i][1]; // 위치 갱신
            }
        }

        return cameras;
    }
}
