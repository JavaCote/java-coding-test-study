package Week1.김누리.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * PackageName : Week1.김누리.programmers
 * FileName    : 자연수_뒤집어_배열로_만들기
 * Author      : 김누리
 * Date        : 2025-04-25
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 04. 25.     김누리               Initial creation
 * 2025. 04. 26.     김누리               Stream API을 이용하지 않는 버전 작성
 */

public class 자연수_뒤집어_배열로_만들기 {
	 public int[] solution(long n) {
		 //  Stream API 이용 버전 
/*		 return Arrays.stream(String.valueOf(n).split(""))
			 .mapToInt(Integer::parseInt)
			 .boxed()
			 .sorted(Comparator.reverseOrder())
			 .mapToInt(Integer::intValue)
			 .toArray();*/

		 //  Stream API를 이용하지 않은 버전
		 String str = Long.toString(n);
		 String[] tmp = str.split("");
		 int[] answer = new int[tmp.length];
		 int idx = 0;
		 
		 for(int i = tmp.length-1; i >=0 ; i--) {
			 int target = Integer.parseInt(tmp[i]);
			 answer[idx++] = target;
		 }

		 return answer;
	 }

	 public void call_solution(long n) {
		 int[] answer = solution(n);

		 for(int i : answer) {
			 System.out.println(i);
		 }
	 }
}
