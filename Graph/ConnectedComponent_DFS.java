/*
Find the Connected Component in the Undirected Graph Show result 

18% Accepted
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
        
        int size = nodes.size();
        List<Integer> rowList = new ArrayList<Integer>();
        
        for(int i = 0; i < size; i++) {
             rowList = new ArrayList<Integer>();
             UndirectedGraphNode node = nodes.get(i);
             dfs(node, visited, result, rowList);
             
             // For DFS, the rows are sepereated here.
             Collections.sort(rowList);
             
            // Handle the case: size of rowList == 0; 
            if (rowList.size() > 0) {
                 result.add(rowList);
            }
        }
        
        return result;
        
    }
    
    // The result can be removed from the parameter.
    public void dfs(UndirectedGraphNode node, HashSet<UndirectedGraphNode> visited, List<List<Integer>> result, List<Integer> rowList){
        
        if (visited.contains(node)) {
            return;
        }  
        
        visited.add(node);
        rowList.add(node.label);
        int size = node.neighbors.size();
        
        if (size > 0) {
            for (UndirectedGraphNode n : node.neighbors) {
                if (!visited.contains(n)) {
                    dfs(n, visited, result, rowList);
                }
            }
        }
        
    }
    
}


