package week8.김상진.programmers;

/**
 * PackageName : week8.김상진.programmers
 * FileName    : 이상한_문자_만들기
 * Author      : sangxxjin
 * Date        : 2025. 6. 13.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 13.     sangxxjin               Initial creation
 */
public class 이상한_문자_만들기 {
	// 1차 풀이는 몇몇 실패케이스가 있음.
	// 문제를 다시 보니 공백의 갯수는 몇개인지 모름.
	// 2차 풀이 방식으로 변경.
	class Solution {
		public String solution(String s) {
			String answer = "";
			// 다른사람의 코드를 확인해보니 아래의 코드를 사용해서 공백도 포함해서 split 가능 -> 실전에서는 못할듯
			// String[] stringArr = s.split(" "); -> String[] stringArr = s.split(" ",-1);
			String[] stringArr = s.split(" ");
			for (int i = 0; i < stringArr.length; i++) {
				String str = stringArr[i];
				char[] arr = str.toCharArray();
				for (int j = 0; j < arr.length; j++) {
					if (j % 2 == 0) answer += Character.toUpperCase(arr[j]);
					else answer += Character.toLowerCase(arr[j]);
				}
				if (i != stringArr.length - 1) answer += " ";
			}
			return answer;
		}
	}
	// 2차 풀이
	// split하지 않고 문자열의 인덱스를 차례로 훑음
	class Solution {
		public String solution(String s) {
			String answer = "";
			int idx=0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c==' '){
					answer+=c;
					idx=0;
				}
				else{
					if(idx%2==0)answer+=Character.toUpperCase(c);
					else answer+=Character.toLowerCase(c);
					idx++;
				}
			}
			return answer;
		}
	}


}
