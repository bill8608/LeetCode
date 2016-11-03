/*
207. Course Schedule   QuestionEditorial Solution  My Submissions
Total Accepted: 58898
Total Submissions: 198482
Difficulty: Medium
Contributors: Admin
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
Hide Company Tags Apple Yelp Zenefits
Hide Tags Depth-first Search Breadth-first Search Graph Topological Sort
Hide Similar Problems (M) Course Schedule II (M) Graph Valid Tree (M) Minimum Height Trees
*/

//Topological sort:
//We have to use inderee because this is defferent from number of islands in which the order does not matter.

//BFS topological sort by using HashMap and Queue
// Create an adjacent list and an indegree array
// Each time, add to queue the node wiht indegree == 0
// Then transverse its neighbors
public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		int[] indegree = new int[numCourses];
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; ++i) {
			map.put(i, new ArrayList<>());
		}
		for(int[] prerequisite : prerequisites) {
			map.get(prerequisite[1]).add(prerequisite[0]);
			++indegree[prerequisite[0]];
		}
		for(int i = 0; i < indegree.length; ++i) {
			if(indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()) {
			int course = queue.poll();
			for (int i : map.get(course)) {
				if (--indegree[i] == 0) {
					queue.offer(i);
				}
			}
			++count;
		}
		return count == numCourses;
	}
}

public class Solution {
	//BFS topological without using hashmap
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        //caculate every vertices indegree
        int[] indegree = new int[numCourses];
        
        
        //Constructing a Adjacency matrices
        //and base on the matrix, set the indegree of every vertices
        for (int i = 0; i < prerequisites.length; i++) {
            //pre是起点，cur是终点
            // pre(1) -> cur(0)  (cur, pre) = (1, 0)  0是1的前序课程
            int pre = prerequisites[i][1];
            int cur = prerequisites[i][0];
            if (matrix[pre][cur] == 0) {
                indegree[cur]++;//cur的入度++
                matrix[pre][cur] = 1; //matrix这里设为1 只是表明存在从pre-cur的一条边，而不是计数！
            } 
        }
        //compute how many vertex has been visited,
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        //since we just offer every vertex once into queue, if count != numCourses, means has cycle
        return count == numCourses;
    }
}

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // BFS
        // first convert the grid to adjacent list
        // create a visited list
        // to tranverse the whole adjacnet list
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0 ) {
            return true;
        }
        int m = prerequisites.length;
        int n = prerequisites[0].length;
        boolean [] visited = new boolean[numCourses];
        List<Set<Integer>> graph = new LinkedList<>();
        
        // Create adjacent list
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new HashSet<Integer> ());
        }
        for(int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            //graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(prerequisites[0][0]);
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            if (visited[node] == true) {
                System.out.println("TS1");
                return false;
            }
            visited[node] = true;
            
            for(Integer course : graph.get(node)) {
                queue.offer(course);
                //graph.get(course).remove(node); 
            }
        }
        for(boolean visit : visited) {
            if (visit == false) {
                System.out.println("TS2");
                return false;
            }
        }
        return true;
    }
}

public class Solution {
		//DFS : find cycle by using dfs
    //visited array has 3 different number,
    //0 : not visited
    //1 : visiting
    //2 : visited
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //construct graph matrix, this is a adjecnt matrix of directed graph
        // first index is outgoing vertex, second index is incoming vertex
        // if (prerequisites == null || prerequisites.length == 0) {
        //     return true;
        // }
        int[][] directedGraph = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            directedGraph[prerequisites[i][1]][prerequisites[i][0]] = 1; 
        }
        int[] visited = new int[numCourses];
        for (int node = 0; node < numCourses; node++) {
            if (visited[node] == 0) {
                if (dfs(node, directedGraph, visited)) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, int[][] directedGraph, int[] visited) {
        visited[node] = 1;
        for (int otherNode = 0; otherNode < directedGraph.length; otherNode++) {
            if (directedGraph[node][otherNode] == 1) {
                if (visited[otherNode] == 1) {
                    return false;//find cycle
                }
                if (visited[otherNode] == 0 && !dfs(otherNode, directedGraph, visited)) {
                    return false;
                }
            }
        }
        visited[node] = 2;
        return true;
    }
}

