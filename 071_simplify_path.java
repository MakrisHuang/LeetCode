class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> queue = new LinkedList<>();
        int len = path.length();
        String[] dirs = path.split("/");
        for (String dir: dirs) {
            if (dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (queue.size() != 0) queue.pollLast();
            } else if (dir.length() != 0) {
                queue.offer(dir);
            }
        }
        StringBuilder sb = new StringBuilder("/");
        while (queue.size() != 0) {
            sb.append(queue.pollFirst());
            if (queue.size() > 0) sb.append("/");
        }
        return sb.toString();
    }
}
