package Day3;

import java.util.Scanner;

//// 전체적으로 군더더기 없이 깔끔하네요! : 22
public class bj5086_jhw {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			if(num1 ==0 && num2 ==0) {
				return;
			}

			//// 깔끔하네요 : 22 깔끔해요~~
			if(num2%num1==0) {
				System.out.println("factor");
			}else if(num1%num2 ==0 ) {
				System.out.println("multiple");
			}else {
				System.out.println("neither");
			}
			sc.close();
			//// 섬세하네요
			}

	}
}
