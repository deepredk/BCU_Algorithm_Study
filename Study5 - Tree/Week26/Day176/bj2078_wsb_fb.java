import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//// 깔끔
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nodeInfo = br.readLine().split(" ");
        int A = Integer.parseInt(nodeInfo[0]), B = Integer.parseInt(nodeInfo[1]);

        //// 구체적으로 구현하시려다보니 코드가 복잡해진 감이 있는 것 같습니다 : 22
        //// => 조금이나마 개선해봤습니다.
        PairNode rootNode = new PairNode(1, 1);
        PairNode targetNode = new PairNode(A, B);

        int leftRoute = 0, rightRoute = 0;
        while (!targetNode.equals(rootNode)) {
            int x = targetNode.getX(), y = targetNode.getY();
            if (x > y) {
                int nextX = x % y;
                leftRoute += x / y;
                if (nextX == 0) {
                    leftRoute--;
                    targetNode.setX(1);
                    continue;
                }
                targetNode.setX(nextX);
            } else {
                int nextY = y % x;
                rightRoute += y / x;
                if (nextY == 0) {
                    rightRoute--;
                    targetNode.setY(1);
                    continue;
                }
                targetNode.setY(nextY);
            }
        }

        sb.append(leftRoute).append(" ").append(rightRoute);
        System.out.println(sb);
        br.close();
    }
}

class PairNode {
    private int x;
    private int y;

    public PairNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        PairNode other = (PairNode) obj;
        if (x != other.x) return false;
        if (y != other.y) return false;
        return true;
    }
}