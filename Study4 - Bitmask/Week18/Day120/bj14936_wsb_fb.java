import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] elevatorInfo = br.readLine().split(" ");
        int N = Integer.parseInt(elevatorInfo[0]), timeLimit = Integer.parseInt(elevatorInfo[1]);

        int buttonStateBit = 1;
        //// buttonStateBit = 1 과 사실상 동일한 결과가 나오는데 무얼 의도하신건가요?
        //// -> 그냥 한가지 상태가 처음부터 추가된다. 라는 생각으로 쓴건데 1로 시작하는 게 더 깔끔한 것 같네요.

        if (timeLimit == 0) {
            System.out.println(1);
            return;
        }
        if (N == 1) {
            System.out.println(2);
            return;
        } 
        if (N == 2) {
            if (timeLimit == 1) System.out.println(3);
            else System.out.println(4);
            return;
        }

        int[] prankTimeArr = {
            N,
            N / 2 + N % 2,
            N / 2,
            (N - 1) / 3 + 1
        };

        for (int i = 0; i < 4; i++) {
            //// m 대신 PRANK_TIME_LIMIT 등으로 이름을 붙여줬다면 더 읽기 편했을 것 같습니다!
            //// -> 반영했습니다.
            if (prankTimeArr[i] <= timeLimit) buttonStateBit |= (1 << i + 1);
        }

        for (int i = 0; i < 3; i++) {
            if (timeLimit - prankTimeArr[i] < prankTimeArr[3] || (buttonStateBit & (1 << i)) == 0) continue;
            buttonStateBit |= (1 << i + 5);
        }

        System.out.println(Integer.bitCount(buttonStateBit));
        br.close();
    }
}