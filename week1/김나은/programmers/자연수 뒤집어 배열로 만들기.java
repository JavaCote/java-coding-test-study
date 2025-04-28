class Solution {
    public int[] solution(long n) {
        String reversed = new StringBuilder(String.valueOf(n)).reverse().toString();

        int[] answer = new int[reversed.length()];

        for(int i = 0; i < reversed.length(); i++) {
            answer[i] = reversed.charAt(i) - '0';
        }

        return answer;
    }
}