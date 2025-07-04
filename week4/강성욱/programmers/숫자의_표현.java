package week4.강성욱.programmers;

public class 숫자의_표현 {
    //수학적 규칙..? 그건 모르겠음
    //그냥 단순히 1부터 쭈르륵 한다고 치면?
    //10,000 일경우, 아무리 최악이라도 O^2 그 이하.
    //중간에 절반 이상은 볼필요도 없음.
        // ? + ? = 100 일때, 절반인 50 이후로는 절때 100이 나올수가 없음.
        // 즉, n이 15면, 50까지만 반복 돌아도 되어서, ^2 보다는 훨신 적을것
    //그럼 100_000_000 1억이면, 해볼만 하긴 함. (이것도 최악의 조건 일경우)
    class Solution {
        public int solution(int n) {

            int count=1; //자기 자신 경우는 무조건 1개는 있음.
            int target=n;
            int end = (int) Math.ceil(target/2);

            for(int start=1; start <= end; start++) {
                int sum = 0;
                int next = start;
                while(sum < target) {
                    sum += next;
                    next++;
                }

                if(sum == target) count++;
            }

            return count;
        }
    }
}
