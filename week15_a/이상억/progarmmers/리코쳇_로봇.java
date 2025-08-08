// . : 빈 공간 , R : 로봇의 처음 위치, D : 장애물의 위치 , G : 목표 지점

import java.util.*;

class Solution {
    int[] dx = {-1, 1 , 0, 0};
    int[] dy = {0 , 0 , -1, 1};
    public int solution(String[] board) {
        int answer = 0;

        int n = board.length;
        int m = board[0].length();

        int start_x = 0;
        int start_y = 0;

        int end_x = 0;
        int end_y = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i].charAt(j) == 'R'){
                    start_x = i;
                    start_y = j;
                } else if(board[i].charAt(j) == 'G'){
                    end_x = i;
                    end_y = j;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> qe = new LinkedList<>();
        qe.offer(new int[]{start_x,start_y,0});
        visited[start_x][start_y] = true;

        while(!qe.isEmpty()){
            int[] cur = qe.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            for(int i = 0; i < 4; i++){
                int nx = x;
                int ny = y;

                while(true){
                    int vx = nx + dx[i];
                    int vy = ny + dy[i];

                    if( vx < 0 || vx >= n || vy < 0 || vy >= m || board[vx].charAt(vy) == 'D') break;

                    nx = vx;
                    ny = vy;

                }
                if( (nx == end_x) & (ny == end_y)) return count + 1;


                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    qe.offer(new int[]{nx,ny,count+1});
                }
            }


        }

        return -1;
    }
}