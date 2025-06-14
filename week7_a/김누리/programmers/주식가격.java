package week7_a.김누리.programmers;

/**
 * PackageName : week7_a.김누리.programmers
 * FileName    : 주식가격
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-14
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 14.     김누리(NRKim)               Initial creation
 */

/*
??? 뭔말이지??

price[0] = 1
price[1] ~ price[4] 까지 1 밑으로 떨어진거 없으니, 4

price[1] = 2
price[2] ~ price[4] 까지 2 밑으로 떨어진거 없으니, 3

price[2] = 3
price[3] 구간에서 3 밑으로 떨어지니, 1

price[3] = 2
price[4] ~ price[4] 까지 2 밑으로 떨어진거 없으니, 1

price[4] = 3
끝점이니 가격이 안떨어지므로 0

*/

public class 주식가격 {
 public int[] solution(int[] prices) {
  int[] answer = new int[prices.length];

  for(int i = 0; i < prices.length -1; i++) {
   int cnt = 0; // 카운팅 횟수
   int now = prices[i]; // 현재 가격

   for(int j = i+1; j < prices.length; j++) {
    cnt++;

    //  가격이 떨어지는 순간 내부 반복 종료
    if (now > prices[j]) {
     break;
    }
   }
   answer[i] = cnt;
  }

  return answer;
 }
}
