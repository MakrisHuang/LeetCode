class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map m = new HashMap();
        for (Integer i=0; i<s.length(); ++i)
            // when no duplicated key exists, put() will return null
            // otherwise, return map.get(key)
            // in that way, one may return null, and one may return the key
            // which will make both return values unequal
            if (m.put(s.charAt(i), i) != m.put(t.charAt(i)+"", i))
                return false;
        return true;
    }
}
