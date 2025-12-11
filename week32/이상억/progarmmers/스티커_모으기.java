class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int n = sticker.length;

        if (n == 1) return sticker[0];

        int[] dp_first = new int[n]; // 첫 번째 사용, 마지막 x
        int[] dp_second = new int[n]; // 두 번째 사용, 마지막 o

        dp_first[0] = sticker[0];
        dp_first[1] = dp_first[0];

        dp_second[0] = 0;
        dp_second[1] = sticker[1];

        for(int i = 2; i < n -1 ; i++){
            dp_first[i] = Math.max(dp_first[i-1],dp_first[i-2]+sticker[i]);
        }
        for(int i = 2; i < n  ; i++){
            dp_second[i] = Math.max(dp_second[i-1],dp_second[i-2]+sticker[i]);
        }


        return Math.max(dp_first[n-2],dp_second[n-1]);
    }
}