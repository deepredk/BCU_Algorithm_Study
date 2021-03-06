import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//// 깔꼼~
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(answerOfQuestionTwo(br.readLine(), 0));

        br.close();
    }

    static StringBuilder answerOfQuestionTwo(String numStr, int cnt){
        //// 만일을 위한 AND 조건인가요?? (그냥 궁금한 것)
        //// -> 입력값이 int의 범위를 넘어갈 수 있기 때문에 자리 수를 계산해줘야 합니다
        if(numStr.length() == 1 && Integer.parseInt(numStr) < 10){
            StringBuilder sb = new StringBuilder();
            //// 결과를 반환하게 할 수도 있구나.. 발상 배워갑니다
            if(isMultiple(Integer.parseInt(numStr), 3)) return sb.append(cnt).append("\nYES");
            else return sb.append(cnt).append("\nNO");
        }

        int sum = 0;
        for(char c : numStr.toCharArray()){
            //// 의미전달도 되면서 간략한 charToInt 어떠쉰?
            //// -> 간략하게 좋네요! 반영했어요
            sum += charToInt(c);
        }

        return answerOfQuestionTwo(String.valueOf(sum), ++cnt);
    }

    static boolean isMultiple(int dividend, int divisor){
        return (dividend % divisor == 0);
    }

    static int charToInt(char c){
        return (c - '0');
    }
}