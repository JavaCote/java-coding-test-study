package week1.강성욱.baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 스택2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();

            if (command.startsWith("1")) {
                handlePush(stack, command);
                continue;
            }

            switch (command) {
                case "2":
                    handlePop(stack, sb);
                    break;
                case "3":
                    sb.append(stack.size()).append("\n");
                    break;
                case "4":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "5":
                    handlePeek(stack, sb);
                    break;
            }
        }

        System.out.print(sb);
    }

    private static void handlePush(Deque<Integer> stack, String command) {
        int x = Integer.parseInt(command.split(" ")[1]);
        stack.push(x);
    }

    private static void handlePop(Deque<Integer> stack, StringBuilder sb) {
        sb.append(stack.isEmpty() ? "-1" : stack.pop()).append("\n");
    }

    private static void handlePeek(Deque<Integer> stack, StringBuilder sb) {
        sb.append(stack.isEmpty() ? "-1" : stack.peek()).append("\n");
    }
}
