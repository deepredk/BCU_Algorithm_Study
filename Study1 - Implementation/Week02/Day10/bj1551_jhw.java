package Day10;

import java.util.Scanner;

public class bj1551_jhw {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numArr = new int[N];
		int K = sc.nextInt();
		
		String number = sc.next();
        String[] numberArr = number.split(",");
		
		//// 루프를 줄이기 위해서 받으면서 바로 변형하는 작업을 해도 좋을 것 같아요! : 22
				//// : 33 이거 말고는 군더더기 없는 코드인거 같아요
				////->더 숙지하고 반영하겠습니다.
		for(int i = 0 ; i < N; i++) {
			numArr[i] = Integer.parseInt(numberArr[i]);	
        }
        
		for(int j =0; j < K;j++) {
		    for(int i = 0 ; i < N-j-1; i++) {
			    numArr[i] = numArr[i+1] - numArr[i];
			}
        }
        
        System.out.print(numArr[0]);
        
		for(int i =1 ; i < N-K; i ++) {
			System.out.print("," + numArr[i]);
		}
		
		

	}

}
