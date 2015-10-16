/*
Given a boolean 2D matrix, find the number of islands.

Have you met this question in a real interview? Yes
Example
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.

Note
0 is represented as the sea, 1 is represented as the island. 
If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
*/

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int lengthX = grid.length;
        int lengthY = grid[0].length;
        
        
        int result = 0;

        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
               if (grid[i][j] == true) {
                    result++;
                    search(grid, i, j);  
                }
            }
        }
        return result;
        
        
    }
    
    private void search(boolean[][] grid, int i, int j) {
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        
        if (grid[i][j] == false) {
            return;
        }
        
        grid[i][j] = false;
        
        search(grid, i - 1, j);
        search(grid, i + 1, j);
        search(grid, i, j - 1);
        search(grid, i, j + 1);
    }

}
