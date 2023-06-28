
import java.util.*;
class Program13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<String>> tickets = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String d = sc.next();
            List<String> ticket = new ArrayList<>();
            ticket.add(s);
            ticket.add(d);
            tickets.add(ticket);
        }
        List<String> itinerary = findItinerary(tickets);
        System.out.println(itinerary);
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();
        for (List<String> ticket : tickets) {
            String s = ticket.get(0);
            String d = ticket.get(1);
            if (!adjList.containsKey(s)) {
                adjList.put(s, new PriorityQueue<>());
            }
            adjList.get(s).offer(d);
        }
        List<String> itinerary = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String curr = stack.peek();
            if (adjList.containsKey(curr) && !adjList.get(curr).isEmpty()) {
                stack.push(adjList.get(curr).poll());
            } else {
                itinerary.add(0, stack.pop());
            }
        }
        return itinerary;
    }
}