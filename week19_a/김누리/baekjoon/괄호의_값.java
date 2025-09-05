package week19_a.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * PackageName : week19_a.김누리.baekjoon
 * FileName    : 괄호의_값
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 05.     김누리(NRKim)               Initial creation
 */

/*

() == > 2
[] ==> 3

()[] ==> 2+3
([]) ==> 2*3

고로

(()[[]]) ==> (2+(3*3)) ==> 2*(2+(3*3)) ===> 2*(2+9) ====> 2*11 =====> 22



*/

public class 괄호의_값 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		Deque<Character> dq = new ArrayDeque<>();
		int result = 0;
		int temp = 1;
		char prev = 0;

		for(char c : s.toCharArray()) {
			if(c == '(') {
				dq.push(c);
				temp *= 2;
			} else if (c == '[') {
				dq.push(c);
				temp *= 3;
			} else if ( c == ')') {
				if(dq.isEmpty() || dq.peek() != '(') {
					bw.write("0");  //  잘못된 괄호면 0 출력
					bw.flush();
					bw.close();
					return;
				}
				if(prev == '(') {
					result += temp;
				}
				dq.pop();
				temp /= 2;
			} else if ( c == ']') {
				if(dq.isEmpty() || dq.peek() != '[') {
					bw.write("0");   //  잘못된 괄호면 0 출력
					bw.flush();
					bw.close();
					return;
				}
				if(prev == '[') {
					result += temp;
				}
				dq.pop();
				temp /= 3;
			} else {
				return;
			}

			prev = c;
		}

		if(!dq.isEmpty()) {
			bw.write("0");
			bw.flush();
			bw.close();
		} else {
			bw.write(String.valueOf(result)); // 문자열로 변환 후 출력
			bw.flush();
			bw.close();
		}

	}
}
