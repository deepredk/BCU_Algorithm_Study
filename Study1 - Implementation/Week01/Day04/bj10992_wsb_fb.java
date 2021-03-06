import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        //// 상수에 이름을 달아준건 되게 좋은거같아요! 근데 calN으로는 어떤 의미인지 알 수 없네요 ㅠㅠ
        //// -> 좋은 지적 감사해요
        int topOfTree = N - 1;

        for(int i = 0; i < topOfTree; i++){
            sb.append(" ".repeat(topOfTree - i))
                .append("*")
                .append(" ".repeat(i == 0 ? 0 : i * 2 - 1))
                .append(i == 0 ? "\n" : "*\n");
        }
        sb.append("*".repeat(2 * N - 1));
        System.out.print(sb);
    }
}