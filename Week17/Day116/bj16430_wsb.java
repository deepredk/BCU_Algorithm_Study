import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//// 아 서로소임이 보장되는구나...
//// 깔꼼해요
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numStrArr = br.readLine().split(" ");
        int A = Integer.parseInt(numStrArr[0]), B = Integer.parseInt(numStrArr[1]);
        System.out.printf("%d %d\n", B - A, B);

        br.close();
    }
}