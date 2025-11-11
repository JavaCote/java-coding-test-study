class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;

        int[][] dp = new int[n+1][m+1];
        boolean[][] water = new boolean[n+1][m+1];

        for(int[] p : puddles){
            water[p[1]][p[0]] = true;
        }

        dp[1][1] = 1;

        for(int y = 1; y <= n; y++){
            for(int x = 1; x <= m; x++){
                if(water[y][x] || ( x == 1 && y == 1)) continue;
                dp[y][x] = (dp[y -1][x] + dp[y][x-1]) % mod;
            }
        }

        return dp[n][m];
    }
}