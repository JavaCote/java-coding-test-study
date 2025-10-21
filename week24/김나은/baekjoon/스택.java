package week24.김나은.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 스택 {

    public class Main {

        public static void main(String[] args) throws IOException {
            // BufferedReader: 표준 입력(System.in)으로부터 한 줄씩 빠르게 읽기
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st;
            int capacity = Integer.parseInt(br.readLine());

            // 스택 구현
            Deque<Integer> stack = new ArrayDeque<>();

            int i = 0;
            // 주어진 명령 개수(capacity)만큼 반복 수행
            while (i < capacity) {
                // 한 줄을 공백 기준으로 나누기
                st = new StringTokenizer(br.readLine());
                switch (st.nextToken()) {
                    case "push":
                        // 정수 X를 스택 맨 위에 추가
                        stack.push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop":
                        // 스택 맨 위에 있는 정수를 빼고, 그 수를 출력
                        // 만약 스택에 들어있는 정수가 없는 경우 -1 출력
                        System.out.println(stack.isEmpty() ? -1 : stack.pop());
                        break;
                    case "size":
                        // 스택에 들어있는 정수의 개수 출력
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        // 스택이 비어있으면 1, 아니면 0 출력
                        System.out.println(stack.isEmpty() ? 1 : 0);
                        break;
                    case "top":
                        // 스택 맨 위에 있는 정수를 출력
                        // 만약 스택에 들어있는 정수가 없는 경우 -1 출력
                        System.out.println(stack.isEmpty() ? -1 : stack.peek());
                        break;
                }
                i++;
            }
            br.close();
        }
    }
}
