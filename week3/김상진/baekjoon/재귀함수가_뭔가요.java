package week3.김상진.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PackageName : week3.김상진.baekjoon
 * FileName    : 재귀함수가_뭔가요
 * Author      : sangxxjin
 * Date        : 2025. 5. 14.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 14.     sangxxjin               Initial creation
 */
public class 재귀함수가_뭔가요 {
	import java.io.*;
	public class Main {
		static int N = 0;
		static StringBuilder sb = new StringBuilder();

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
			repeate(0);
			System.out.print(sb);
		}

		private static void repeate(int depth) {
			String underScore = "";
			for (int i = 0; i < depth; i++) {
				underScore += "____";
			}
			sb.append(underScore + "\"재귀함수가 뭔가요?\"\n");
			if (N == depth) {
				sb.append(underScore + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
				sb.append(underScore + "라고 답변하였지.\n");
				return;
			}
			sb.append(underScore + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			sb.append(underScore + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			sb.append(underScore + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
			repeate(depth + 1);
			sb.append(underScore + "라고 답변하였지.\n");
		}
	}

}
