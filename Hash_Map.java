class MyHashMap {
    int HASH_NUMBER = 997;
    private ArrayList<LinkedList<Pair>> data;
    
    public MyHashMap() {
        data = new ArrayList<LinkedList<Pair>>(HASH_NUMBER + 1);
        for (int i = 0; i <= HASH_NUMBER; i++){
            data.add(new LinkedList<Pair>());
        }
    }
    
    public void put(int key, int value) {
        int pos = hash(key);
        Pair pair = new Pair(key, value);
        if (data.get(pos) == null) {
            LinkedList<Pair> conflictList = new LinkedList<Pair>();
            conflictList.add(pair);
            data.set(pos, conflictList);
        } else {
            LinkedList<Pair> conflictList = data.get(pos);
            boolean found = false;
            Iterator<Pair> iterator = conflictList.iterator();
            while (iterator.hasNext()) {
              Pair newPair = iterator.next();
              if (newPair.key == key) {
                newPair.value = value;  
                found = true; 
                break;
              }
            }
            if (found == false) {
                conflictList.add(new Pair(key, value));
            }
        }
    }
    
    public int get(int key) {
      int pos = hash(key);
      int result = -1;
      LinkedList<Pair> conflictList = data.get(pos);
      if (conflictList == null) {
          return result;
      }  
      Iterator<Pair> iterator = conflictList.iterator();
      while (iterator.hasNext()) {
          Pair pair = iterator.next();
          if (pair.key == key) {
              result = pair.value;
              break;
          }
      }
      return result;
    }
    
    public void remove(int key) {
      int pos = hash(key);
      if (data.get(pos) == null) {
          return;
      }
      LinkedList<Pair> conflictList = data.get(pos);
      Iterator<Pair> iterator = conflictList.iterator();
      while (iterator.hasNext()) {
          if (iterator.next().key == key) {
              iterator.remove();
              break;
          }
      }        
    }
    
    private class Pair {
        int key;
        int value;
        
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int hash(int key) {
        return key % HASH_NUMBER;
    }
 
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
