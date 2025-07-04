package week4.강성욱.programmers;

import java.util.*;
public class 소수찾기 {
    //소수인지 아닌지 판별이 필요.
    //미리, 소수를 구해놓고, 배열로 check[1] = true 이면 소수 이런식으로 해두면 빨리 찾을 수 있을듯.
    //그럼 소수 찾는 범위는?
    //numbers 가 7개까지 들어올 수 있음. 중복? 999 도 들어올 수 있음.
    //그럼 최대 9,999,999 까지 확인을 미리 해놔야 한다. 라는 점?

    class Solution {
        private static final int MAX = 9_999_999;
        private static final boolean[] isPrime = getPrimeTable();
        private Set<Integer> numberSet = new HashSet<>();

        public int solution(String numbers) {
            boolean[] visited = new boolean[numbers.length()];
            dfs("", numbers, visited);

            int count = 0;
            for (int num : numberSet) {
                if (isPrime[num]) count++;
            }
            return count;
        }

        private void dfs(String current, String numbers, boolean[] visited) {
            if (!current.isEmpty()) {
                numberSet.add(Integer.parseInt(current));
            }

            for (int i = 0; i < numbers.length(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(current + numbers.charAt(i), numbers, visited);
                    visited[i] = false;
                }
            }
        }

        // 소수 미리 구하기
        private static boolean[] getPrimeTable() {
            boolean[] prime = new boolean[MAX + 1];
            Arrays.fill(prime, true);
            prime[0] = prime[1] = false;

            for (int i = 2; i * i <= MAX; i++) {
                if (prime[i]) {
                    for (int j = i * i; j <= MAX; j += i) {
                        prime[j] = false;
                    }
                }
            }

            return prime;
        }
    }
}
