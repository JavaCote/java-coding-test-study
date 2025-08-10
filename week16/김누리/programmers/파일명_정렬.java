package week16.김누리.programmers;

import java.util.Arrays;

/**
 * PackageName : week16.김누리.programmers
 * FileName    : 파일명_정렬
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-10
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 10.     김누리(NRKim)               Initial creation
 */

/*
파일명 = foo9.txt
Head = foo
Number = 9
tail = .txt

Arrays.sort로 오름차순,

새로 알게 된 개념
Character.isDigit(char c) ==> 해당 글자가 숫자인지 판단.
Character.isLetter(char c) ==> 해당 글자가 문자인지 판단.

*/

public class 파일명_정렬 {
	public String[] solution(String[] files) {

		//  정렬 작업
		Arrays.sort(files, (f1,f2) -> {
			String [] p1 = splitName(f1);
			String [] p2 = splitName(f2);

			//  헤드 부분 비교.
			int headCompare = p1[0].compareToIgnoreCase(p2[0]); // 대수문자 구분 없이 비교
			if( headCompare != 0 ) return headCompare;

			int num1 = Integer.parseInt(p1[1]);
			int num2 = Integer.parseInt(p2[1]);

			return num1 - num2; //  NUBMER 값 기준으로 오름차순
		});

		return files;
	}

	//  파일명 분리용 함수
	private String[] splitName(String file) {
		int n = file.length();
		int idx = 0;

		//  해당 위치가 숫자가 아닌 경우
		while(idx < n && !Character.isDigit(file.charAt(idx))) idx++;
		int headEnd = idx;


		int numStart = idx;
		int cnt = 0;

		//  숫자인 경우
		//  NUMBER 최대 5자리 까지 가능
		while(idx < n && Character.isDigit(file.charAt(idx)) && cnt < 5) {
			idx++;
			cnt++;
		}

		int numEnd = idx;

		String head = file.substring(0,headEnd);
		String number = file.substring(numStart,numEnd);
		String tail = file.substring(numEnd);

		return new String[] {head, number, tail};
	}
}
