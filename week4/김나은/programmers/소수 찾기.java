package week4.김나은.programmers;

import java.util.*;

class Solution {
    // 조합된 숫자의 중복을 피하기 위해 Set으로 구현
    HashSet<Integer> numbersSet = new HashSet<>();

    public int solution(String numbers) {
        // DFS를 통해 가능한 모든 숫자 조합을 생성
        dfs("", numbers);

        int count = 0;

        // 생성된 숫자 조합 중 소수인 숫자의 개수를 셈
        Iterator<Integer> it = numbersSet.iterator();

        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) // 소수인지 확인
                count++;
        }
        return count;
    }

    // 소수 판별 메서드
    public boolean isPrime(int num) {
        if (num == 0 || num == 1)
            return false; // 0과 1은 소수가 아님

        int lim = (int)Math.sqrt(num); // √num까지만 검사하면 됨

        for (int i = 2; i <= lim; i++)
            if (num % i == 0) // 나누어떨어지면 소수가 아님
                return false;

        return true; // 위 조건을 모두 통과하면 소수
    }

    // DFS를 사용하여 모든 가능한 숫자 조합 생성
    public void dfs(String str, String numbers) {
        // 비어있지 않은 문자열이면 숫자로 변환 후 Set에 저장
        if (!str.equals(""))
            numbersSet.add(Integer.valueOf(str));

        // 남은 숫자들로 재귀 호출하여 모든 순열을 생성
        for (int i = 0; i < numbers.length(); i++)
            // 현재 문자를 str에 추가하고, 해당 문자를 제외한 나머지로 dfs 재귀 호출
            dfs(str + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1));

    }
}