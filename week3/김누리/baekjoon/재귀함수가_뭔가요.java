package week3.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * PackageName : week3.김누리.baekjoon
 * FileName    : 재귀함수가_뭔가요
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-13
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 13.     김누리(NRKim)               Initial creation
 */

/*
* 반복 구호 :
*
* "재귀함수가 뭔가요?"
* "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
* 마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
 * 그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
*
*/

public class 재귀함수가_뭔가요 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void solution() throws Exception{
		int n = Integer.parseInt(br.readLine()); //  출력 반복 수
		bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n"); // 초기 대사
		dfs(0,n); // for(int i = 0; i < n; i++)
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	public static void dfs(int start, int end){
		String indent = "____".repeat(start);

		sb.append(indent).append("\"재귀함수가 뭔가요?\"").append("\n");

		if(start == end) {
			//  마지막 호출일 때 출력 대사
			sb.append(indent).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		} else {
			//  대사 반복. 1번째 호출일 경우 '____'는 안붙음, 2번째일때는 '____'가 붙고 등등등
			sb.append(indent).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
			sb.append(indent).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
			sb.append(indent).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");

			//  호출 카운트 증가
			dfs(start+1,end);
		}

		//  맺음말
		sb.append(indent).append("라고 답변하였지.\n");
	}
}
