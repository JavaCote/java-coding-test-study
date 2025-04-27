//약수를 모두 더한 값
//특정 수를 나눴을때, 나머지가 0 이면, 약수.
//3000 까지이니, 전체 반복돌려도 크게 문제 없을듯.
//만약 3000 이상이라면, 엄청 크게 잡아야 될듯.

class Solution {
	public int solution(int n) {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			if(n%i == 0) sum += i; //약수
		}
		return sum;
	}
}