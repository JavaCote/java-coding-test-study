package week14.강성욱.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PackageName : week14.강성욱.programmers
 * FileName    : 수식_최대화
 * Author      : Baekgwa
 * Date        : 2025-07-28
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-28     Baekgwa               Initial creation
 */
public class 수식_최대화 {

	class Solution {
		public long solution(String expression) {
			//계산식을 숫자부분과, 기호 부분으로 쪼개야됨.
			List<Long> numberList = new ArrayList<>();
			List<String> expressList = new ArrayList<>();
			StringBuilder sb = new StringBuilder();

			for(String s : expression.split("")){
				if(s.equals("+") || s.equals("-") || s.equals("*")) {
					numberList.add(Long.parseLong(sb.toString()));
					sb = new StringBuilder();
					expressList.add(s);
					continue;
				}

				sb.append(s);
			}
			numberList.add(Long.parseLong(sb.toString())); //마지막 숫자 넣어야됨.

			// +, -, * 3! 순열 만들기
			// 는 걍 고정이니 노가다로 만들기
			List<List<String>> orders = Arrays.asList(
				Arrays.asList("+", "-", "*"),
				Arrays.asList("+", "*", "-"),
				Arrays.asList("-", "+", "*"),
				Arrays.asList("-", "*", "+"),
				Arrays.asList("*", "+", "-"),
				Arrays.asList("*", "-", "+")
			);

			long result = 0;
			for (List<String> orderList : orders) {
				result = Math.max(result, Math.abs(calc(orderList, new ArrayList<>(numberList), new ArrayList<>(expressList))));
			}

			return result;
		}

		//버그 많음
		//     // order => 우선순위 리스트
		//     private long calc(List<String> orderList, List<Long> numberList, List<String> expressList) {
		//         for (String order : orderList) {
		//             for (int i = 0; i < expressList.size(); i++) {
		//                 if (expressList.get(i).equals(order)) {
		//                     long left = numberList.remove(i);
		//                     long right = numberList.remove(i);
		//                     long newResult = calculateResult(left, right, order);
		//                     numberList.add(i, newResult); //원래 위치 그대로에 넣어야됨
		//                     expressList.remove(i);
		//                 }
		//             }
		//         }

		//         return numberList.get(0);
		//     }

		private long calc(List<String> orderList, List<Long> numberList, List<String> expressList) {
			for (String curOp : orderList) {
				while (expressList.contains(curOp)) {
					for (int i = 0; i < expressList.size(); i++) {
						if (expressList.get(i).equals(curOp)) {
							long left = numberList.remove(i);
							long right = numberList.remove(i);
							long newResult = calculateResult(left, right, curOp);
							numberList.add(i, newResult);
							expressList.remove(i);
							break;
						}
					}
				}
			}

			return numberList.get(0);
		}

		// 연산 처리
		private long calculateResult(long left, long right, String order) {
			switch (order) {
				case "+": return left + right;
				case "-": return left - right;
				case "*": return left * right;
			}
			return 0;
		}
	}
}
