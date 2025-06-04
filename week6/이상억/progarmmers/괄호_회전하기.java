import java.util.Deque;
import java.util.ArrayDeque;

class Solution{
    public int solution(String s) {
        int answer = - 1;

        Deque<Character> deque = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            deque.addLast(c);
        }
        return answer;
   }
}


