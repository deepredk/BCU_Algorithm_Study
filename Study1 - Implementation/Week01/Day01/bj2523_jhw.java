

import java.util.Scanner;

//// 탭 정리가 되어있지 않고, 공백이나 줄바꿈의 간격에 규칙성이 없어 읽기 불편해요. (다른 답안에서도):22지만 제 코드도 그런거 같아서 반성도 하고가요,, : 333


public class bj2523_jhw {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
//// 해당 문제에서 for문을 많이 돌릴 필요가 없어보여요.
		for(int i = 0; i < num; i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 0; i < num; i++) {
			for(int j = num-1; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
