// 서비스 가입자 최대 > 판매액 최대 

// n 명의 사용자에게 이모티콘 m 개를 할인하여 판매
// 이모티콘 마다 할인율 다를 수 있음 10 20 30 40 중 ㅏ한
// 구매 비용의 합이 일정 가격 이상이 된다면 이모티콘 구매 모두 취소 플러스 가입

class Solution {
    static int[] discounts = {10, 20, 30, 40};
    static int maxSubs = 0;   // 최대 가입자 수
    static int maxSales = 0;  // 최대 매출

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, new int[emoticons.length], users, emoticons);
        return new int[]{maxSubs, maxSales};
    }

    private void dfs(int depth, int[] selected, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            evaluate(selected, users, emoticons);
            return;
        }

        for (int d : discounts) {
            selected[depth] = d;
            dfs(depth + 1, selected, users, emoticons);
        }
    }

    // 가입자 수와 매출 계산
    private void evaluate(int[] selected, int[][] users, int[] emoticons) {
        int subs = 0;
        int sales = 0;

        for (int[] user : users) {
            int minDiscount = user[0];
            int limit = user[1];
            int total = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (selected[i] >= minDiscount) {
                    total += emoticons[i] * (100 - selected[i]) / 100;
                }
            }

            if (total >= limit) {
                subs++; // 이모티콘 플러스 가입
            } else {
                sales += total;
            }
        }

        // 우선순위 가입자 수 → 매출
        if (subs > maxSubs || (subs == maxSubs && sales > maxSales)) {
            maxSubs = subs;
            maxSales = sales;
        }
    }
}
