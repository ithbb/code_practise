// Functions summary for collections usage

public class CollectionFunctionUsage {

/*
* char[] / int[] / int[][]
*/
char[] charArray;
int[]  intArray;
int[][] intMatrix;

public void arrayActions() {
 
}



/*
* String 
*/
String string1;
public void StringActions() {
 
}


/*
* ArrayList/ LinkedList
*/
LinkedList<String> linkedlist;
ArrayList<String> stringArryList;
List<String> stringList;
public void ListActions() {
 
}

/*
* HashMap / HashSet
*/
HashMap<Integer, String> hashmap;
HashSet<String> hashset;
public void hashActions() {
}

/*
* Stack / Queue
*/
Stack<String> stack;
Queue<String> queue;
public void stackActions() {
}

public void queueActions() {
}


/*
*  Binary Tree
*/
private class TreeNode {
    String label;
    TreeNode left;
    TreeNode right;
}

/*
* Graph
*/
private class UndirectedGraphNode {
    String label;
    ArrayList<UndirectedGraphNode> neighbors;
}

private class DirectedGraphNode {
    String label;
    ArrayList<DirectedGraphNode> inNeighbors;
    ArrayList<DirectedGraphNode> outNeighbors;
}





}
