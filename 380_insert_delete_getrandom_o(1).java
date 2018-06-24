class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int valIdx;
        if (map.containsKey(val)){
            valIdx = map.get(val);

            // Cache current last ele in the list
            int lastIdxInList = list.size() - 1;
            int lastEle = list.get(lastIdxInList);

            // Move val to be remove in the last position of list
            map.put(val, lastIdxInList);
            list.set(lastIdxInList, val);

            // Move cached last element to where the val to be removed  (before it was moved to last)
            list.set(valIdx, lastEle);
            map.put(lastEle, valIdx);

            // remove the last element from the list
            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
