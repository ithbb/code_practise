/*
Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors. (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)

Have you met this question in a real interview? Yes
Example
Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        
        
        List<List<Integer>> result = new ArrayList<>();
        //List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nodes == null || nodes.size() == 0) {
            return result;
        }
        
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        
        int size = 
        nodes.size();
        
        for(int i = 0; i < size; i++) {
             UndirectedGraphNode node = nodes.get(i);
             bfs(node, visited, result);
        }
        
        return result;
        
    }
    
    
    public void bfs(UndirectedGraphNode node, HashSet<UndirectedGraphNode> visited, List<List<Integer>> result){
        
        ArrayList<Integer> rowList = new ArrayList<Integer>();
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        
        
        if (visited.contains(node)) {
            return;
        }  
        
        queue.offer(node);
        visited.add(node);
        
        while(!queue.isEmpty()) {
            
            UndirectedGraphNode head = queue.poll();
            rowList.add(head.label);
            
            for(UndirectedGraphNode n : head.neighbors) {
                if(!visited.contains(n)) {
                  queue.offer(n);
                  visited.add(n);
                }
                
            }
            
        }
        Collections.sort(rowList);
        result.add(rowList);
        
    }
    
}


