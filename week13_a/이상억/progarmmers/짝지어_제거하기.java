// 같은 알파벳 2개 붙어 있는 짝 제거 앞 뒤로 문자열 이어 붙임
// 반복

import java.util.*;


class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(char a : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == a){
                stack.pop();
            } else{
                stack.push(a);
            }
        }

        return stack.isEmpty() ? 1 : 0 ;
    }
}