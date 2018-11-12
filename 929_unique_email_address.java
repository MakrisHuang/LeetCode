class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email: emails) {
            int atIndex = email.indexOf("@");
            String domain = email.substring(atIndex + 1, email.length());
            String local = email.substring(0, atIndex);
            
            local = local.replace(".", "");
            local = local.substring(0, local.indexOf("+"));
            set.add(local + domain);
        }
        return set.size();
    }
}