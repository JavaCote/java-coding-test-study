package week13.김누리.programmers;

/**
 * PackageName : week13.김누리.programmers
 * FileName    : 키패드_누르기
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-24
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 24.     김누리(NRKim)               Initial creation
 */

/*
1, 4, 7 == "L"
3, 6, 9 == "R"

int[] lP = {3,0};
int[] rP = {3,2};



키패드 좌표화

0,0 0,1 0,2
1,0 1,1 1,2
2,0 2,1 2,2
3,0 3,1 3,2

Map을 채용 해서 진행
Map<String,int[]> map = new HashMap<>();

map = {
1 = {0,0}
2 = {0,1}
3 = {0,2}
4 = {1,0}
5 = {1,1}
6 = {1,2}
7 = {2,0}
8 = {2,1}
9 = {2,2}
* = {3,0}
0 = {3,1}
# = {3,2}
}


case 1 :
numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5];

for(int n : numbers) {
    if (n == 1 || n == 4 || n == 7 ) {
        //  L 처리
        lP = map.get(n);
        answer += "L"
    } else if (n == 3 || n == 6 || n == 9) {
        //  R 처리
        rP = map.get(n);
        answer += "R"
    } else {
        //  0 2 5 8 일 때 처리
        타겟 거리 계산
        int[] tmp = map.get(n)
        int lToTarget =  Math.abs(tmp[0]-lp[0]) + Math.abs(tmp[1] - lP[1]);
        int rToTarget =  Math.abs(tmp[0]-rp[0]) + Math.abs(tmp[1] - rP[1]);

        if(lToTarget > rToTarget) {
            answer += "L"
        } else if (lToTarget < rToTarget) {
            answer += "R"
        } else {
            String t = hand.toUpperCase();
            answer += substring(t,0);
        }
    }
}

대충 위와 같은 느낌으로 로직 진행하면 됨

*/

public class 키패드_누르기 {
}
