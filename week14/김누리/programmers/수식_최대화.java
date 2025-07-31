package week14.김누리.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PackageName : week14.김누리.programmers
 * FileName    : 수식_최대화
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-31
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 31.     김누리(NRKim)               Initial creation
 */

/*

expression을 분리

숫자 리스트, 연산자 리스트 만들어서 각각 적재

이후 연산자 조합에 따라 계산 진행.

추후 성욱님 소스 참조를 많이했기 때문에 재풀이 필요함.

*/

public class 수식_최대화 {

 public long solution(String expression) {
  long answer = 0;
  //  표현식 나누기
  String[] exp = expression.split("");

  //  각각 숫자와 연산자들이 들어갈 리스트
  List<Long> nums = new ArrayList<>();
  List<String> opt = new ArrayList<>();

  //  숫자 이어붙이기 용 sb
  StringBuilder sb = new StringBuilder();

  //  연산자 > 연산자 리스트로, 숫자? 숫자 리스트로
  for(String s : exp) {
   if ( s.equals("+") || s.equals("-") || s.equals("*") ) {
    nums.add(Long.parseLong(sb.toString())); //  숫자 이어붙인 것들을 숫자 리스트에 저장
    sb = new StringBuilder();  //  sb 초기화
    opt.add(s); // 연산자 추가
   } else {
    sb.append(s);
   }
  }

  //  마지막 숫자 입력
  nums.add(Long.parseLong(sb.toString()));

  //  조합을 노가다로 (성욱님꺼 참조함)
  List<List<String>> order = Arrays.asList(
      Arrays.asList("+", "-", "*"),
      Arrays.asList("+", "*", "-"),
      Arrays.asList("*", "+", "-"),
      Arrays.asList("*", "-", "+"),
      Arrays.asList("-", "+", "*"),
      Arrays.asList("-", "*", "+")
  );


  for(List<String> orderList : order) {
   //  최종 연산
   answer = Math.max(answer,Math.abs(calc(orderList, new ArrayList<>(nums), new ArrayList<>(opt))));
  }

  return answer;
 }

 public long calc(List<String> order, List<Long> nums, List<String> opt) {
  //  연산자 리스트 만큼 순회
  for(String o : order) {

   //  연산자 리스트에 대상 연산자가 있는 경우
   while(opt.contains(o)) {
    for(int i = 0; i < opt.size(); i++) {
     if(opt.get(i).equals(o)) {
      //  a (연산자) b 에서 a와 b를 추출하는 과정
      long left = nums.remove(i);
      long right = nums.remove(i);

      //  추출한 숫자들, 연산자를 통해 계산 진행
      long newAnswer = calResult(left,right,o);
      nums.add(i,newAnswer);
      opt.remove(i);
      break;
     }
    }
   }
  }

  return nums.get(0);
 }

 public long calResult(long left, long right, String o) {
  switch(o) {
   case "+" :
    return left + right;

   case "-" :
    return left - right;

   case "*" :
    return left * right;
  }

  return 0;
 }

}
