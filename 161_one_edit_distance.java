class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;
        
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    // replace one char from longStr and check equality
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(i, t.charAt(i));
                    return (sb.toString().equals(t));
                } else if (s.length() > t.length()){
                    // delete one element for long str
                    StringBuilder sb = new StringBuilder(s);
                    sb.deleteCharAt(i);
                    return (sb.toString().equals(t));
                } else {
                    StringBuilder sb = new StringBuilder(t);
                    sb.deleteCharAt(i);
                    return (sb.toString().equals(s));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}