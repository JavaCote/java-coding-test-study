package week12.김상진.programmers;

public class 숫자_문자열과_영단어 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
            // arr기준 반복
            for(int i=0;i<arr.length;i++) {
                if(s.contains(arr[i])) {
                    s = s.replace(arr[i], Integer.toString(i));
                }
            }
            answer = Integer.parseInt(s);
            return answer;
        }
    }

}
