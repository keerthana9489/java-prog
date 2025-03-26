import java.util.*;

public class BFS {
    
    // Function to perform BFS traversal
    public static void bfs(Map<String, List<String>> graph, String start) {
        // Create a queue for BFS and a set to keep track of visited nodes
       LinkedList <String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        // Start by adding the start node to the queue and marking it as visited
        queue.add(start);
        visited.add(start);
        
        // Perform BFS
        while (!queue.isEmpty()) {
            // Dequeue a node from the queue
            String node = queue.poll();
            System.out.print(node + " ");
            
            // Get all the neighbors of the current node
            for (String neighbor : graph.get(node)) {
                // If the neighbor hasn't been visited, mark it as visited and add to the queue
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // Create the graph using an adjacency list (using a Map)
        Map<String, List<String>> graph = new HashMap<>();
        
        // Add edges to the graph
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D", "E"));
        graph.put("C", Arrays.asList("A", "F"));
        graph.put("D", Arrays.asList("B"));
        graph.put("E", Arrays.asList("B", "F"));
        graph.put("F", Arrays.asList("C", "E"));
        
        // Perform BFS starting from node "A"
        System.out.println("BFS Traversal starting from A:");
        bfs(graph, "A");
    }
}
