package week6.강성욱.programmers;

import java.util.*;

public class 괄호_회전하기 {
    //먼저 올바른 괄호인지 확인하는 메서드 하나 필요.
    //괄호 확인은 stack 사용해서 pop 시키는 방식으로 진행?
    //열리는건 그냥 push 해서 넣고
    //닫히는 괄호가 들어오면 peek() 해서 마지막껄 확인 후, pop 할 수 있으면 pop (이때 넣지 않고 그냥 이번꺼랑 전에넣은거 pop)
    //만약 못하는 케이스가 나오면? 그건 바로 return false 해버려도 될듯?
    // 주의할 점, 아무것도 없을때, peek() 하면 뭐나오는지 확인해봐야함 (공식문서)

    class Solution {
        public int solution(String s) {
            int count = 0;

            for(int i=0; i<s.length(); i++) {
                //회전
                s = swap(s);
                //검증
                if(isOk(s)) count++;
            }
            return count;
        }

        private boolean isOk(String s) {
            Deque<Character> st = new ArrayDeque<>();

            for(char c : s.toCharArray()) {
                if(c == '[' || c == '{' || c == '(') {
                    st.push(c);
                    continue;
                }

                if (st.isEmpty()) return false;

                char now = st.peek();
                if ((now == '[' && c == ']') ||
                        (now == '{' && c == '}') ||
                        (now == '(' && c == ')')) {
                    st.pop();
                } else {
                    return false;
                }
            }

            return st.isEmpty();
        }

        private String swap(String s) {
            if (s.length() == 0) return s;
            return s.substring(1) + s.charAt(0);
        }
    }
}
