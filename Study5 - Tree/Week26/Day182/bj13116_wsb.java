import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    //// 깔끔하고 효율적입니다 : 동의
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        //// 배우고 바로 사용하는 점 멋져요!
        while (T-- > 0) {
            String[] nodeInfo = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodeInfo[0]);
            int node2 = Integer.parseInt(nodeInfo[1]);

            sb.append(10 * LcaOfBfsTree(node1, node2)).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
    
    static int LcaOfBfsTree(int node1, int node2) {
        if (node1 == node2) return node1;
        
        if (node1 > node2) return LcaOfBfsTree(node1 / 2, node2);
        return LcaOfBfsTree(node1, node2 / 2);
    }
}