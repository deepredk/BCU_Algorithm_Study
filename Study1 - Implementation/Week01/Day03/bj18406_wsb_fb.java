import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine();
        int halfLen = strN.length() / 2;
        //// 1/2보다 left/right, front/back 등으로 지었으면 더 직관적이었을 것 같아요
        //// -> 좋은 지적 감사해요
        String left = strN.substring(0, halfLen), right = strN.substring(halfLen);
        int leftSum = 0, rightSum = 0;
        
        for(int i = 0; i < halfLen; i++){
            leftSum += Character.getNumericValue(left.charAt(i));
            rightSum += Character.getNumericValue(right.charAt(i));
        }
        System.out.print(leftSum == rightSum ? "LUCKY" : "READY");
    }
}