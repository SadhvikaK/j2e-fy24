import java.util.*;

public class Program9{
    public int countPaths(int[][] graph, int s, int d) {
        List<List<Integer>> adjList = AdjList(graph);
        int[] arr = new int[graph.length];
        return dfs(adjList, s, d, arr);
    }

    private List<List<Integer>> AdjList(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
        }

        return list;
    }

    private int dfs(List<List<Integer>> adjacencyList, int s, int d, int[] arr) {
        if (s == d) {
            return 1;
        }

        if (arr[s] != 0) {
            return arr[s];
        }

        int ct = 0;
        for (int neighbor : adjacencyList.get(s)) {
            ct += dfs(adjacencyList, neighbor, d, arr);
        }

        arr[s] = ct;
        return ct;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int s=sc.nextInt();
        int d=sc.nextInt();
        Program9 p=new Program9();
        System.out.println(p.countPaths(arr,s,d));
    }
}