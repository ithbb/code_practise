class Trie {

    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int id = (int) (c - 'a');
            if (cur.children[id] != null) {
                cur = cur.children[id];
            } else {
                cur.children[id] = new TrieNode();
                cur = cur.children[id];
            }
           
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int id = (int) (ch - 'a');
            if(cur.children[id] == null) return false;
            else {
                cur = cur.children[id];
            }
        }
        return cur.isEnd; 
    }
    
    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode cur = root;
        for(char c : prefix.toCharArray()) {
            int id = (int) (c - 'a');
            cur = cur.children[id];

            if (cur == null) {
                return false;
            }
        }
        return true;
    }
    
    private class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
