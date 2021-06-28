import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {
    static Map<Integer, Node> nodeMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }

        while (--N > 0) {
            String[] adjacentNodeInfo = br.readLine().split(" ");
            int roomA = Integer.parseInt(adjacentNodeInfo[0]);
            int roomB = Integer.parseInt(adjacentNodeInfo[1]);
            int distance = Integer.parseInt(adjacentNodeInfo[2]);

            setNodes(roomA, roomB, distance);
        }

        Node rootNode = nodeMap.get(1);
        System.out.println(getMaxDistance(rootNode, 0));
        br.close();
    }

    static long getMaxDistance(Node fromNode, long untilDistance) {
        long maxDistance = untilDistance;

        Map<Node, Integer> edgeDistanceMap = fromNode.getEdgeDistanceMap();

        for (Node adjacentNode : edgeDistanceMap.keySet()) {
            adjacentNode.removeAdjacentNode(fromNode);
            int edgeDistance = edgeDistanceMap.get(adjacentNode);
            maxDistance = Math.max(maxDistance, getMaxDistance(adjacentNode, untilDistance + edgeDistance));
        }

        return maxDistance;
    }

    static void setNodes(int dataA, int dataB, int edgeDistance) {
        Node nodeA = setNode(dataA);
        Node nodeB = setNode(dataB);

        nodeA.setAdjacentNode(nodeB, edgeDistance);
        nodeB.setAdjacentNode(nodeA, edgeDistance);
    }

    static Node setNode (int data) {
        Node node;
        if (nodeMap.containsKey(data)) {
            node = nodeMap.get(data);
        } else {
            node = new Node(data);
            nodeMap.put(data, node);
        }
        return node;
    }
}

class Node {
    private int data;
    private Map<Node, Integer> edgeDistanceMap;

    public Node(int data) {
        this.data = data;
        edgeDistanceMap = new HashMap<>();
    }

    public int getData() {
        return data;
    }

    public Map<Node, Integer> getEdgeDistanceMap() {
        return edgeDistanceMap;
    }

    public void setAdjacentNode(Node node, int distance) {
        edgeDistanceMap.put(node, distance);
    }

    public void removeAdjacentNode(Node node) {
        edgeDistanceMap.remove(node);
    }
}