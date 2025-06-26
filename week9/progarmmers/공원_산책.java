/**
 * PackageName : week9.이상억.progarmmers;
 * FileName    : 덧칠하기
 * Author      : sangeok
 * Date        : 2025. 6. 25.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 25.     sangeok               Initial creation
 */


// 회고 : 문제를 잘못 읽었음 장애물이 있으면 이동을 못하고 그 위치에서 다음 명령에 따라 움직이는 줄 알았는데 아니었음
    // x, dx ,nx 이러한 변수가 많다 보니까 헷갈림.. 좀 귀찮아도 그냥 변수명을 좀 길게 하는게 날 거 같기도 함

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int ph = park.length; // park hegiht
        int pw = park[0].length(); // park width;

        int x = 0;
        int y = 0;
        for(int i = 0; i < ph; i++){
            int k = park[i].indexOf("S");
            if( k != -1) {
                x = i; // 높이
                y = k; // 넓이
                break;
            }
        } // 시작 위치 탐색

        for(String route : routes){
            String[] parts = route.split(" ");
            String dir = parts[0];
            int mv = Integer.parseInt(parts[1]);

            int dx = 0;
            int dy = 0;

            switch(dir){
                case "E" : dy = 1; break;
                case "W" : dy = -1; break;
                case "N" : dx = -1; break;
                case "S" : dx = 1; break;
            }

            boolean canmove = true;

            for(int i = 1 ; i <= mv; i++){
                int nx = x + dx * i;
                int ny = y + dy * i;

                if (nx < 0 || ny < 0 || nx >= ph || ny >= pw || park[nx].charAt(ny) == 'X'){
                    canmove = false;
                    break;
                }
            }
            if(canmove){
                x += dx * mv;
                y += dy * mv;
            }
        }

        answer[0] = x;
        answer[1] = y;


        return answer;
    }
}