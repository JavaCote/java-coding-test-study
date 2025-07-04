package week2.김나은.programmers;

class Solution {
    public String solution(int a, int b) {
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 30};

        int answer = 0;

        for (int i = 0; i < a - 1; i++) {
            answer += month[i];
        }

        answer += b - 1;

        return day[answer % 7];
    }
}