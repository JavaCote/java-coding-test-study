package week3.강성욱.programmers;

//흠. 문제에 h, w 로 나왔는데, x, y 로 바꿔서 괜히 복잡하게 생각하는듯
//나쁜습관 고칠것!
//디버깅 없이 한번에 통과 굳

public class PCCE_기출문제_9번_이웃한_칸 {
    class Solution {
        public static int[] dx = {-1, 0, 1, 0};
        public static int[] dy = {0, -1, 0, 1};

        public int solution(String[][] board, int h, int w) {
            //h == y;
            //w == x;
            //board[h][w];
            //정사각형임
            int count = 0;
            int maxXY = board.length;
            String color = board[h][w];
            for(int i=0; i<4; i++) {
                int nx = dx[i] + w;
                int ny = dy[i] + h;

                //underflow, overflow 확인
                if(nx < 0 || ny < 0 || nx >= maxXY || ny >= maxXY) continue;
                if(color.equals(board[ny][nx])) count++;
            }
            return count;
        }
    }
}
