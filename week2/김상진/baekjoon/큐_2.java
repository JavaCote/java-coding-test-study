package week2.김상진.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * PackageName : week2.김상진.programmers
 * FileName    : 큐_2
 * Author      : sangxxjin
 * Date        : 2025. 5. 8.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 8.     sangxxjin               Initial creation
 */
public class 큐_2 {

	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();

			int N = Integer.parseInt(br.readLine());
			Deque<Integer> queue = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				String[] parts = input.split(" ");
				String command = parts[0];

				switch (command) {
					case "push":
						int num = Integer.parseInt(parts[1]);
						queue.offer(num);
						break;
					case "pop":
						sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
						break;
					case "size":
						sb.append(queue.size()).append('\n');
						break;
					case "empty":
						sb.append(queue.isEmpty() ? 1 : 0).append('\n');
						break;
					case "front":
						sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
						break;
					case "back":
						sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
						break;
				}
			}

			System.out.print(sb);
		}
	}

}
