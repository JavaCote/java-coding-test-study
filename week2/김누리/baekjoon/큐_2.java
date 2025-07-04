package week2.김누리.baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * PackageName : week2.김누리.baekjoon
 * FileName    : 큐_2
 * Author      : 김누리
 * Date        : 2025-05-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 05.     김누리               Initial creation
 * 2025. 05. 06.     김누리               1차 풀이 완료
 */
public class 큐_2 {
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());

		//  front, back 명령어 때문에 인덱스를 신경써야 해서 일반적인 Queue가 아닌 Deque 이용
		Deque<Integer> que = new LinkedList<>();

		//  읽어온 명령어 만큼 반복문 진행
		for(int i = 0; i < n; i++) {
			String cmd = br.readLine();
			st = new StringTokenizer(cmd, " ");

			switch(st.nextToken()) {
				case "push":
					que.offer(Integer.parseInt(st.nextToken()));
					break;

				case "pop":
					if(que.isEmpty()) sb.append("-1\n");
					else sb.append(que.poll()+"\n");
					break;

				case "size":
					sb.append(que.size()+"\n");
					break;

				case "empty":
					if(que.isEmpty()) sb.append("1\n");
					else sb.append("0\n");
					break;

				case "front":
					if(que.isEmpty()) sb.append("-1\n");
					else sb.append(que.peekFirst()+"\n");
					break;

				case "back":
					if(que.isEmpty()) sb.append("-1\n");
					else sb.append(que.peekLast()+"\n");
					break;

				default:
					break;
			}

		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
