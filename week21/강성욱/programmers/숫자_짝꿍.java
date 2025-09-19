package week21.강성욱.programmers;

/**
 * PackageName : week21.강성욱.programmers
 * FileName    : 숫자_짝꿍
 * Author      : Baekgwa
 * Date        : 2025-09-19
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-19     Baekgwa               Initial creation
 */
public class 숫자_짝꿍 {
	// 3403
	//13203
	//{3, 3, 0} 이 셋트

	// class Solution {
	//     public String solution(String X, String Y) {
	//         List<Integer> list = new ArrayList<>();

	//         int loopCnt = Math.min(X.length(), Y.length());
	//         for(int i=loopCnt-1; i>=0; i--) {
	//             if(X.charAt(i) == Y.charAt(i)) {
	//                 list.add(Integer.valueOf(X.charAt(i)));
	//             }
	//         }

	//         list.sort(Collections.reverseOrder());
	//         StringBuilder sb = new StringBuilder();
	//         for(int now : list) {
	//             sb.append(now);
	//         }
	//         return sb.toString();
	//     }
	// }

	// class Solution {
	//     public String solution(String X, String Y) {
	//         List<Integer> list = new ArrayList<>();

	//         int loopCnt = Math.min(X.length(), Y.length());
	//         //X, Y 를 역순으로 정렬해둬야함. 0번이 끝으로 가야하니.
	//         char[] x = new char[X.length()];
	//         for(int i=0; i<X.length(); i++) {
	//             x[i] = X.charAt(X.length() - i - 1);
	//         }
	//         char[] y = new char[Y.length()];
	//         for(int i=0; i<Y.length(); i++) {
	//             y[i] = Y.charAt(Y.length() - i - 1);
	//         }

	//         // 확인
	//         for(int i=0; i<loopCnt; i++) {
	//             if(x[i] == y[i]) list.add(x[i] - '0');
	//         }

	//         if(list.isEmpty()) return "-1";

	//         list.sort(Collections.reverseOrder());
	//         StringBuilder sb = new StringBuilder();
	//         for(int now : list) {
	//             sb.append(now);
	//         }
	//         return sb.toString();
	//     }
	// }

	class Solution {
		public String solution(String X, String Y) {
			int[] countX = new int[10];
			int[] countY = new int[10];

			for (char c : X.toCharArray()) {
				countX[c - '0']++;
			}

			for (char c : Y.toCharArray()) {
				countY[c - '0']++;
			}

			StringBuilder answerBuilder = new StringBuilder();

			for (int i = 9; i >= 0; i--) {
				int commonCount = Math.min(countX[i], countY[i]);
				for (int j = 0; j < commonCount; j++) {
					answerBuilder.append(i);
				}
			}

			String answer = answerBuilder.toString();

			if (answer.isEmpty()) {
				return "-1";
			}

			if (answer.charAt(0) == '0') {
				return "0";
			}

			return answer;
		}
	}
}
