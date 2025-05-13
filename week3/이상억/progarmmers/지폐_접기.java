package week3.이상억.progarmmers;

/**
 * PackageName : week3.이상억.progarmmers;
 * FileName    : 이웃한_칸
 * Author      : sangeok
 * Date        : 2025. 5. 13.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 13.     sangeok               Initial creation
 */

// 문제 요구사항 ) 긴 쪽으로 반 접음
//               길이가 홀 수 였다면 소수점 버림
//               접힌 지폐가 그대로 90 도 돌려서 넣을 수 있음 그만 접음

// 접근 방식 : (1)  지폐가 담길 때 까지 반복문
//                 크기 비교 후 큰쪽이 왼쪽 작은 쪽이 오른쪽
//                 안담기면 왼쪽 / 2

// 회고 : 무식하게 값 변경하지 말고 Math.min / Math.max 사용하기
// 처음보자마자 그 2주차에 했던 최소직사각형 문제 생각났음

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int tmp = 0;

        // 큰값 왼쪽으로 변경
        if(wallet[0] < wallet[1]){
            tmp = wallet[0];
            wallet[0] = wallet[1];
            wallet[1] = tmp;
        }

        while(true){
            if(bill[0] < bill[1]){
                tmp = bill[0];
                bill[0] = bill[1];
                bill[1] = tmp;
            }
            if( wallet[0] >= bill[0] && wallet[1] >= bill[1]){
                return answer;
            }

            bill[0] = bill[0]/2;
            answer ++;
        }
    }
}

// Math max/min 함수 사용 해봄 => 익숙하지 않아서 자꾸 생각이 안나고 안사용하는 거 같아 사용함
//class Solution {
//    public int solution(int[] wallet, int[] bill) {
//        int answer = 0;
//
//        int wmax = Math.max(wallet[0],wallet[1]);
//        int wmin = Math.min(wallet[0],wallet[1]);
//
//        while(true){
//            int bmax = Math.max(bill[0],bill[1]);
//            int bmin = Math.min(bill[0],bill[1]);
//
//            if(bmax <= wmax && bmin <= wmin) return answer;
//
//            if (bill[0] >= bill[1]) {
//                bill[0] /= 2;
//            } else {
//                bill[1] /= 2;
//            }
//            answer ++;
//
//        }
//    }
//}