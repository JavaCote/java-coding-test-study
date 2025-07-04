package week3.강성욱.baekjoon;

/** 이건 맨첨에 한번만
 * 어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.
 */

/** 이게 반복 시작
 * "재귀함수가 뭔가요?"
 * "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
 * 마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
 * 그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
 */

/** 이게 반복 끝
 * 라고 답변하였지.
 */

//단, 마지막 뎁스에서는 반복 끝나기전에 아래 내용으로 변경
//"재귀함수는 자기 자신을 호출하는 함수라네"

//각각의 반복문은 ____ 로 뎁스 구분

import java.util.Scanner;

public class 재귀함수가_뭔가요 {
    static StringBuilder sb = new StringBuilder();
    static String spaceUnit = "____";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        newQuestion(n, 0);
        System.out.println(sb.toString());
    }

    static void newQuestion(int n, int depth) {
        String indent = spaceUnit.repeat(depth);

        sb.append(indent).append("\"재귀함수가 뭔가요?\"\n");

        if (depth == n) {
            sb.append(indent).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            sb.append(indent).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            sb.append(indent).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            sb.append(indent).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            newQuestion(n, depth + 1);
        }

        sb.append(indent).append("라고 답변하였지.\n");
    }
}
