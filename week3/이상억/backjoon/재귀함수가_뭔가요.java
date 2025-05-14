package week3.이상억.backjoon;


/**
 * PackageName :  week3.이상억.backjoon
 * FileName    : 재귀함수가_뭔가요 ?
 * Author      : sangeok
 * Date        : 2025. 5. 14.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 14.     sangeok               Initial creation
 */

// 문제 요구사항)      저 위의 문장을 반복 출력
//                   마지막에 재귀함수가 뭔지 말해줌
//                   나올 때 마다 ---- 붙여서 나옴


// 접근 방법 : (1)     1) 반복되는 문장 출력
//                    2) 깊이 별로 ____ pattern 추가
//                    3) 깊이가 같을 때 재귀함수에 대한 답변 출력
//                    4) 마무리 하면서 "라고 하였지"라는 문장 출력

// 회고 :


import java.util.Scanner;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        Recursive(0);
    }

    static void Recursive(int depth) {
        String pattern = makeparttern(depth);

        System.out.println(pattern + "\"재귀함수가 뭔가요?\"");

        if (depth == n) {
            System.out.println(pattern + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        } else {
            System.out.println(pattern + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(pattern + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(pattern + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

            Recursive(depth + 1);
        }
        System.out.println(pattern + "라고 답변하였지.");
    }

    static String makeparttern(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("____");
        }
        return sb.toString();
    }
}
