import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        int[] count_x = new int[10];
        int[] count_y = new int[10];

        for(char c : X.toCharArray()){
            count_x[c-'0']++;
        }

        for(char c : Y.toCharArray()){
            count_y[c-'0']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 9; i>=0; i--){
            int common = Math.min(count_x[i],count_y[i]);

            for(int j = 0; j < common; j++){
                sb.append(i);
            }
        }

        if (sb.length() == 0) return "-1";
        if (sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}