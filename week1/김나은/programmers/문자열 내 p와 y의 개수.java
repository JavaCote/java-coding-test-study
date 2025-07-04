package week1.김나은.programmers;

class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'p') {
                count++;
            } else if (s.charAt(i) == 'y') {
                count--;
            }
        }

        return count == 0;
    }
}