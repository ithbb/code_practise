/*
Singleton

33% Accepted
Singleton is a most widely used design pattern.
If a class has and only has one instance at every moment, we call this design as singleton.
For example, for class Mouse (not a animal mouse), we should design it in singleton.

You job is to implement a getInstance method for given class, 
return the same instance of this class every time you call this method.
*/

class Solution {
    /**
     * @return: The same instance of this class every time
     */
    
    private static Solution _solution;
    
    public static Solution getInstance() {
        
        if (_solution != null) {
            return _solution;
        } else {
            _solution = new Solution();
            return _solution;
        }
        
        
    }
};

