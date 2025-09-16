import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        Arrays.sort(plans,(a,b) -> a[1].compareTo(b[1]));

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < plans.length; i ++){
            int current = htomin(plans[i][1]);

            return answer;
        }

        public int htomin(String s) {
            String[] time = s.split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            return hour * 60 + minute;
        }
    }
