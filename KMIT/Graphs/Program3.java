
import java.util.*;
class Node {
    int n;
    List<Node> neighbors;
    Node(int n) {
        this.n = n;
        this.neighbors = new ArrayList<>();
    }
}

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int num = sc.nextInt();
        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            graph.add(new Node(i + 1));
        }
        System.out.print("Enter the number of edges: ");
        int m = sc.nextInt();
        System.out.println("Enter the edges:");
        for (int i = 0; i < m; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.get(source - 1).neighbors.add(graph.get(destination - 1));
        }
        List<Node> cg = cloneGraph(graph);
        System.out.println("Output :");
        for (Node node : cg) {
            System.out.print(node.n + " ");
            for (Node neighbor : node.neighbors) {
                System.out.print(neighbor.n + " ");
            }
            System.out.println();
        }
    }

    public static List<Node> cloneGraph(List<Node> graph) {
        if (graph == null || graph.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Node, Node> clonedNodes = new HashMap<>();
        for (Node node : graph) {
            clonedNodes.put(node, new Node(node.n));
        }
        for (Node node : graph) {
            Node clonedNode = clonedNodes.get(node);
            for (Node neighbor : node.neighbors) {
                clonedNode.neighbors.add(clonedNodes.get(neighbor));
            }
        }
        return new ArrayList<>(clonedNodes.values());
    }
}