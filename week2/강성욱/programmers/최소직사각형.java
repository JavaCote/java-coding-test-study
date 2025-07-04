package week2.강성욱.programmers;

public class 최소직사각형 {
    //가장 기본적인 조건은, 가로길이, 세로 길이 중, 가장 큰걸 x, y 로 잡는것
// 근데 이러면 눕히는 경우 계산이 안되니 패스

// 그럼 명함1번부터, 가로 <-> 세로를 뒤집고,
// 이중 가로 길이, 세로 길이 중 가장 큰걸 x, y 로 구해서 구하면?
// 최대 명함은 10_000 개가 들어올 수 있음
// O(10_000) 마다, 가장 큰걸 구해야하니? 괜찮나?

// 하나씩 집어넣는다고 가정하고
// 가로로 넣을래? 세로로 넣을래 체크하고, 되면 넣고 안되면 늘리고?
// 그럼 긴걸 가로로, 짧은걸 세로로 변경하고 집어넣으면 되잖아.

    class Solution {
        public int solution(int[][] sizes) {
            int maxW = 0;
            int maxH = 0;

            for (int[] size : sizes) {
                int w = Math.max(size[0], size[1]);
                int h = Math.min(size[0], size[1]);

                maxW = Math.max(maxW, w);
                maxH = Math.max(maxH, h);
            }

            return maxW * maxH;
        }
    }
}
