import java.util.*;

class Program1{
    static class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    static int longestPath(List<List<Integer>> graph, int start) {
        int[] distances = new int[graph.size()];
        Arrays.fill(distances, Integer.MIN_VALUE);
        distances[start] = 0;

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.size()];

        for (int i = 1; i < graph.size(); i++) {
            if (!visited[i]) {
                topologicalSort(graph, i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (distances[vertex] != Integer.MIN_VALUE) {
                for (int neighbor : graph.get(vertex)) {
                    int newDistance = distances[vertex] + 1;
                    distances[neighbor] = Math.max(distances[neighbor], newDistance);
                }
            }
        }

        int ans=0;
        for(int i=0;i<graph.size();i++){
            ans=Math.max(ans,distances[i]);
        }
        return ans+1;
    }

    static void topologicalSort(List<List<Integer>> graph, int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                topologicalSort(graph, neighbor, visited, stack);
            }
        }

        stack.push(vertex);
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(3, 4));
        edges.add(new Edge(4, 5));
        edges.add(new Edge(5, 6));
        edges.add(new Edge(7, 6));

        int numVertices = 8;
        List<List<Integer>> graph = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            graph.get(edge.source).add(edge.destination);
        }


        int fans=0;
        for(int i=1;i<numVertices;i++){
            fans=Math.max(fans, longestPath(graph, i));
        }
        System.out.println(fans);
    }
}