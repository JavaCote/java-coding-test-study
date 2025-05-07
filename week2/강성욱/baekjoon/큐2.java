// Scanner 로 했다가 시간초과 떠서 bufferdReader 로 변경

import java.util.LinkedList;
import java.io.*;

public class 큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> q = new LinkedList<>();
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String order = br.readLine();

            Integer pushValue = 0;
            //order 에서, push 가 있는 경우에는, 값을 빼놔야됨.
            if(order.contains("push")) {
                String[] orderSpec = order.split(" ");
                order = orderSpec[0];
                pushValue = Integer.valueOf(orderSpec[1]);
            }

            switch (order) {
                case "push":
                    q.offer(pushValue);
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
