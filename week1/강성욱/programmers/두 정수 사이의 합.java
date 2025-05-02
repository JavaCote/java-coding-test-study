class Solution {
    public long solution(int a, int b) {
        int start = a < b ? a : b;
        int end = a > b ? a : b;

        long sum = 0L;
        for(int i = start; i <= end; i++) {
            sum += (long)i;
        }

        return sum;
    }
}