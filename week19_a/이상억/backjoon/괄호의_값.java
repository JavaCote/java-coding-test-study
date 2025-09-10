// 괄호 안에 들어있으면 -> 곱하기
// 괄호 옆에 나란히 있으면 -> 더하기
// () : 2 [] : 3

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int mul = 1; // 중첩에 따른 곱
        char prev = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            switch(c){
                case '(':
                    stack.push(c);
                    mul *= 2;
                    break;

                case '[':
                    stack.push(c);
                    mul *= 3;
                    break;

                case ')':
                    if(stack.isEmpty() || stack.peek() != '(') {
                        System.out.println(0);
                        return ;
                    }
                    if(prev == '(') result += mul;
                    stack.pop();
                    mul /= 2;
                    break;

                case ']':
                    if(stack.isEmpty() || stack.peek() != '[') {
                        System.out.println(0);
                        return ;
                    }
                    if(prev == '[') result += mul;
                    stack.pop();
                    mul /= 3;

                    break;
                default:
                    result = 0; mul = 0;
                    break;
            }

            prev = c;
        }
        if(!stack.isEmpty()) result = 0;

        System.out.println(result);
    }
}