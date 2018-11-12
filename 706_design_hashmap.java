class MyHashMap {
    Integer[] bucket;
    final int SIZE = 1000000;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = new Integer [SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        bucket[key] = new Integer(value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (bucket[key] == null) {
            return -1;   
        }
        return bucket[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (bucket[key] != null) {
            bucket[key] = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */