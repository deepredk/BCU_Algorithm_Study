import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int startTime[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int endTime[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int wantNum = Integer.parseInt(br.readLine());
        int numCnt = 0;

        if(startTime[0] == endTime[0]){
            if(containWantNum(startTime[0], wantNum)) numCnt += endTime[1] - startTime[1] + 1;
            else{
                for(int i = startTime[1]; i <= endTime[1]; i++){
                    if(containWantNum(i, wantNum)) numCnt++;
                }
            }
        }else{
            if(containWantNum(startTime[0], wantNum)) numCnt += 60 - startTime[1];
            else{
                for(int i = startTime[1]; i < 60; i++){
                    if(containWantNum(i, wantNum)) numCnt++;
                }
            }

            for(int i = startTime[0] + 1; i < endTime[0]; i++){
                if(containWantNum(i, wantNum)) numCnt += 60;
                else{
                    if(wantNum < 6) numCnt += 15;
                    else numCnt += 6;
                }
            }

            if(containWantNum(endTime[0], wantNum)) numCnt += endTime[1] + 1;
            else{
                for(int i = 0; i <= endTime[1]; i++){
                    if(containWantNum(i, wantNum)) numCnt++;
                }
            }
        }

        System.out.print(numCnt);
    }

    static boolean containWantNum(int num, int want){
        return want == num || want == num / 10 || want == num % 10;
    }
}