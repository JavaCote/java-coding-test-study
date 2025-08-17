package week17.김누리.programmers;

/**
 * PackageName : week17.김누리.programmers
 * FileName    : 점_찍기
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-17
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 17.     김누리(NRKim)               Initial creation
 */

/*
k = 추가 거리
d = 최대 길이 ( x축이든 y축이든 )

case 1 :
k = 2, d = 4;

시작점은 (0,0)

int dist = 0;
int x = 0;
int y = 0;

Queue<int[]> q = new LinkedList<>();

q.offer(new int[] {x,y});

while(!q.isEmpty()) {
    //  x,y 축 계산하며 Queue에 적재 로직
}


근데... 저렇게 bfs로가면? k도 d도 100만 이니 반복문 돌다 터질거 같은데...

그래서 스쿼트(sqrt)문을 쓰면... 제곱근 만큼만 계산하니 될지도?

*/

public class 점_찍기 {
	public long solution(int k, int d) {
		long answer = 0;

		for( int i = 0; i <= d; i+=k ) {
			//  a^2 + b^2 <= c^2 : 밑변^2 + 높이^2 <= 대각선^2
			//  위 공식을 통해 원의 반지름 d 인 원 안쪽의 좌표 갯수 계산
			long maxY = (long)Math.sqrt((long)d*d - (long)i*i);

			answer += (maxY / k) + 1;
		}

		return answer;
	}
}
