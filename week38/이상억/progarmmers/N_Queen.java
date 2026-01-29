class Solution {
    int count = 0;
    boolean[] col;
    boolean[] diag1; // 오른쪽 아래 대각
    boolean[] diag2; // 왼쪽 아래 대각

    public int solution(int n) {
        col = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        dfs(0, n);
        return count;
    }

    void dfs(int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] || diag1[row + i] || diag2[row - i + n - 1]) {
                continue;
            }

            col[i] = true;
            diag1[row + i] = true;
            diag2[row - i + n - 1] = true;

            dfs(row + 1, n);

            col[i] = false;
            diag1[row + i] = false;
            diag2[row - i + n - 1] = false;
        }
    }
}
