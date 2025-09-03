// N 명이 뭉쳐 있을 때 N^2 위력 - > 대각선으로 있을때는 뭉쳐있는거 아님 
// Input : 전쟁터의 가로 크기 : n , 세로 크기 : m ( 1<= n,m <= 100)
// B : blue , W : white
// 당신의 병사의 위력의 합과 적국의 병사의 위력의 합을 출력한다.
// 예제 입력 1 
// 5 5
// WBWWW  81 49 
// WWWWW  64 + 1
// BBBBB 
// BBBWW 
// WWWWW 
// 130 65


import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static char[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행

        grid = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            grid[i] = line.toCharArray();
        }

        int w_power = 0;
        int b_power = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    char team = grid[i][j];
                    int size = bfs(i, j, team);
                    if (team == 'W') {
                        w_power += size * size;
                    } else if (team == 'B') {
                        b_power += size * size;
                    }
                }
            }
        }

        System.out.println(w_power + " " + b_power);
    }

    static int bfs(int x, int y, char team) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && grid[nx][ny] == team) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
