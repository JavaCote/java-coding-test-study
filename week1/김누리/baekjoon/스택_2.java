package week1.김누리.baekjoon;

/**
 * PackageName : Week1.김누리.programmers
 * FileName    : 스택_2
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 스택_2 {
	public void baekjoonStack2() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 명령어 읽어오는 용도
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 로그 출력용
		StringBuilder sb = new StringBuilder(); // 출력 내용 구성을 위한 sb
		int n = Integer.parseInt(br.readLine()); // 명령어 갯수 판독용

		Stack<Integer> st = new Stack<>(); //정수 저장용 Stack

		//  읽어온 명령어 만큼 반복 진행
		for(int i = 0; i < n; i++ ) {
			String cmd = br.readLine();

			//  1 X로 들어오기 때문에 1의 경우는 startsWith를 이용
			if(cmd.startsWith("1")) {
				String s = cmd.substring(2);
				st.push(Integer.parseInt(s));
			}

			if(cmd.equals("2")) {
				//  스택에 정수가 없으면 -1 출력
				if(st.isEmpty()) {
					sb.append("-1\n");
				} else {
					//  스택에 정수가 있으면 가장 위에 있는 값을 pop 하고 출력
					sb.append(st.peek()+"\n");
					st.pop();
				}
			}

			if(cmd.equals("3")) {
				//  스택에 들어있는 정수의 갯수 출력
				sb.append(st.size()+"\n");
			}

			if(cmd.equals("4")) {
				// 스택이 비어있으면 1 출력
				if(st.isEmpty()) {
					sb.append("1\n");
				} else {
					//  스택이 비어있지 않으면 0 출력
					sb.append("0\n");
				}
			}

			if(cmd.equals("5")) {
				//  스택에 정수가 없으면 -1 출력
				if(st.isEmpty()) {
					sb.append("-1\n");
				} else {
					//  스택에 정수가 있다면 맨 위의 정수 출력
					sb.append(st.peek()+"\n");
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
