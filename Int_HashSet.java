//HashSet for Integer

class MyHashSet {

    private int[] data;
    
    public MyHashSet() {
      data = new int[1000001];
      Arrays.fill(data, -1);
    }
    
    public void add(int key) {
      if (data[key] < 0) {
          data[key] = key;
      }
    }
    
    public void remove(int key) {
      if (data[key] >= 0) {
          data[key] = -1;
      }
    }
    
    public boolean contains(int key) {
        return data[key] >= 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
