class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int cover = 2 * w + 1;
        int pos = 1;

        for(int st : stations){
            int left = st - w;

            if(pos < left) {
                int gap = left - pos;
                answer += (gap + cover - 1) / cover;
            }

            pos = st + w + 1;
        }

        if(pos <= n){
            int gap = n - pos + 1;
            answer += (gap + cover - 1) / cover;
        }

        return answer;
    }
}