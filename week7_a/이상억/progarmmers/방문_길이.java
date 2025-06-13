// 내가 이동한 방문 좌표 저장해야 할 거 같은데 ?
// 방문 간선 ? (x,y) 형식 저장해서 중복 체크
// 거쳐간 길이라고 명시 했으니 직선 0,0 -> 1,0 // 1,0 -> 0,0 이 둘 다 동일시 되는  거같음
import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;

        for(char dir : dirs.toCharArray()){
            int dx = x;
            int dy = y;

            if((dir == 'U') && y < 5) dy++;
            else if((dir == 'D') && y > -5) dy--;
            else if((dir == 'R') && x < 5) dx ++;
            else if((dir == 'L') && x > -5) dx --;
            else continue;

            String path = x + "," + y + "," + dx + "," + dy;
            String reversepath = dx + "," + dy + "," + x + "," + y;

            if(!visited.contains(path) && !visited.contains(reversepath)){
                visited.add(path);
                visited.add(reversepath);
                answer++;
            }

            x = dx;
            y = dy;
        }

        return answer;
    }
}