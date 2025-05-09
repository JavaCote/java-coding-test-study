package week2.이상억.backjoon;

/**
 * PackageName : week2.이상억.backjoon
 * FileName    : 큐_2
 * Author      : sangeok
 * Date        : 2025. 5. 7.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 7.     sangeok               Initial creation
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        int last = -1;
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();

            if (cmd.startsWith("push")) {
                int x = Integer.parseInt(cmd.split(" ")[1]);
                queue.addLast(x);
                last = x;
            } else if (cmd.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.removeFirst()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (cmd.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.getFirst()).append('\n');
            } else if (cmd.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : last).append('\n');
            }
        }
        System.out.print(sb);
    }
}
