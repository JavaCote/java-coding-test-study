package week24.강성욱.baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * PackageName : week24.강성욱.baekjoon
 * FileName    : 스택
 * Author      : Baekgwa
 * Date        : 2025-10-17
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-17     Baekgwa               Initial creation
 */
public class 스택 {
	public class Main {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Deque<Integer> stack = new ArrayDeque<>();

			int cnt = sc.nextInt();

			for(int i=0; i<cnt; i++){
				String order = sc.next();

				if(order.equals("push")){
					int pushValue = sc.nextInt();
					stack.push(pushValue);
				}
				else if(order.equals("pop")){
					if(stack.isEmpty()){
						System.out.println(-1);
					}
					else {
						Integer pop = stack.pop();
						System.out.println(pop);
					}
				}
				else if(order.equals("size")){
					int size = stack.size();
					System.out.println(size);
				}
				else if(order.equals("empty")){
					boolean empty = stack.isEmpty();

					if (empty == true) {
						System.out.println(1);
					}
					else{
						System.out.println(0);
					}
				}
				else if(order.equals("top")){
					if(stack.isEmpty()){
						System.out.println(-1);
					}
					else {
						int top = stack.peek();
						System.out.println(top);
					}
				}
			}
		}

	}
}
