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
            while (i < capacity) {
                st = new StringTokenizer(br.readLine());
                switch (st.nextToken()) {
                    case "push":
                        stack.push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop":
                        System.out.println(stack.isEmpty() ? -1 : stack.pop());
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        System.out.println(stack.isEmpty() ? 1 : 0);
                        break;
                    case "top":
                        System.out.println(stack.isEmpty() ? -1 : stack.peek());
                        break;
                }
                i++;
            }
            br.close();
        }
    }
}
