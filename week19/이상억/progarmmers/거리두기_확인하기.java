/**
 * PackageName : week19.이상억.progarmmers;
 * FileName    : 거리두기_확인하기
 * Author      : sangeok
 * Date        : 2025. 09. 02.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 02.     sangeok               Initial creation
 */

// 맨해튼 거리 : |x_2-x_1| + |y_2-y_1| <= 2 파티션으로 막혀있을 때는 허용
// 5 X 5 크기
// P : 응시자가 앉아 있는자리
// O : 빈 자리
// X : 파티션

import java.util.*;

class Solution {

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0 ; i < places.length; i++){
            if(is_check(places[i])){
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }


    public boolean is_check(String[] place){
        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 5; j ++){
                if(place[i].charAt(j) == 'P'){
                    if(!bfs(place,i,j)) return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(String[] place, int x, int y){
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if(dist > 0 && place[cx].charAt(cy) == 'P') return false;

            if(dist >= 2) continue;

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if( nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(visited[nx][ny]) continue;
                if(place[nx].charAt(ny) == 'X') continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny, dist + 1});
            }

        }

        return true;
    }
}