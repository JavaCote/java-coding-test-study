package week24.강성욱.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * PackageName : week24.강성욱.baekjoon
 * FileName    : 듣보잡
 * Author      : Baekgwa
 * Date        : 2025-10-17
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-17     Baekgwa               Initial creation
 */
public class 듣보잡 {
	/**
	 * PackageName : baekgwa
	 * FileName    : ${NAME}
	 * Author      : Baekgwa
	 * Date        : 2025-09-11
	 * Description :
	 * =====================================================================================================================
	 * DATE          AUTHOR               NOTE
	 * ---------------------------------------------------------------------------------------------------------------------
	 * 2025-09-11     Baekgwa               Initial creation
	 */

	public class Main {
		public static void main(String[] args) {
			Set<String> set = new HashSet<>();
			Scanner sc = new Scanner(System.in);

			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			for (int i=0; i<N; i++) {
				set.add(sc.nextLine());
			}

			List<String> list = new ArrayList<>();
			for (int i=0; i<M; i++) {
				String name = sc.nextLine();

				if(set.contains(name)) {
					list.add(name);
				}
			}

			Collections.sort(list);
			System.out.println(list.size());
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}
}
