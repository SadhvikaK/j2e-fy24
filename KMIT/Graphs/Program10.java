
import java.util.*;
class Program10
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        System.out.println(Connected_Comp(n, edges));
    }

    public static int Connected_Comp(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited);
                num++;
            }
        }
        return num;
    }

    private static void dfs(int u, List<List<Integer>> adjList, boolean[] visited) {
        visited[u] = true;
        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                dfs(v, adjList, visited);
            }
        }
    }
}