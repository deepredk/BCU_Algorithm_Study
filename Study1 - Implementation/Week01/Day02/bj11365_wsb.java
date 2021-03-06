import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        //// 조건식에서 대입/비교 한꺼번에 하는 거 배워갑니다
        while(!(str = br.readLine()).equals("END")){
            //// 문자열 거꾸로 뒤집는게 문제의 핵심이라서, 라이브러리 사용하지 않고 직접 짜는게 더 좋았을 것 같아요
            //// 기능들을 잘 활용해서 더 간단한 코드를 만들어내는게 대단합니다.
            sb.append(new StringBuffer(str).reverse().toString()).append("\n");
        }
        System.out.print(sb);
    }
}
