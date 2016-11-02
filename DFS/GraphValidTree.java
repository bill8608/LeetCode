/*
261. Graph Valid Tree
Total Accepted: 22316
Total Submissions: 62791
Difficulty: Medium
Contributors: Admin
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Hide Company Tags Google Facebook Zenefits
Hide Tags Depth-first Search Breadth-first Search Graph Union Find
Hide Similar Problems (M) Course Schedule (M) Number of Connected Components in an Undirected Graph

*/
//Thought:
/* This is BFS.
First, we need to transfer the edges to a adjacent list: List<Set<Integer>> graph = new ArrayList<>();
Second, for each elment of the List, it is a HashSet
Third, Create the adjacant list: graph.get(edge[0]).add(edge[1])
Fourth, BFS. In each while cycle, decide whether a node is visited or not. If visitd, reture false, else assign true; 
    Add neighbors to the queue and remove the node from each neighbor.
Fifth, check the visited array is all true or not.
*/
/*public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n < 1) {
            return false;
        }
        List<Set<Integer>> graph = new ArrayList<>();
        // Initialize each node's set to create adjacent list
        for (int i = 0; i < n; ++i) {
            graph.add(new HashSet<Integer>());
        }
        // Create adjacent list according to edges
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // Mark whether each node is visited
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()) {
            int node = q.poll();
            if (visited[node] == true) {
                return false;
            }
            visited[node] = true;
            
            for(int neighbor : graph.get(node)) {
                q.offer(neighbor);
                graph.get(neighbor).remove(node);
            }
        }
        for (boolean connected : visited) {
            if (connected == false) {
                return false;
            }
        }
        return true;
    }
}
*/

//DFS
// The thought is the same as BFS. The only difference is to use stack instead of queue.
public class Solution {
    boolean validTree (int n, int[][] edges) {
        if (n < 1) {
            return false;
        }
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new HashSet<Integer>());
        }
        
        // Create the adj array
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node] == true) {
                return false;
            }
            visited[node] = true;
            
            for(Integer neighbor : graph.get(node)) {
                stack.push(neighbor);
                graph.get(neighbor).remove(node);
            }
        }
        
        for (boolean visit: visited) {
            // fasle means isolated node exists
            if (visit == false) {
                return false;
            }
        }
        return true;
    }
}