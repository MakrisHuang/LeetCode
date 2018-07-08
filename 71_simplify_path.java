// please see the Deque/Stack solution in discussion
class Solution {
    public String simplifyPath(String path) {
        List<String> dirs = new ArrayList<>();

        int dirStart = 0, len = path.length();
        while (dirStart < len) {
            // consume one slash and the string
            // find the index of directory
            while (dirStart < len && path.charAt(dirStart) == '/') dirStart++;

            int dirEnd = dirStart;
            while (dirEnd < len && path.charAt(dirEnd) != '/') dirEnd++;

            String dir = path.substring(dirStart, dirEnd);
            if (dir.equals(".")) {
            }
            else if (dir.equals("..")) {
                if (! dirs.isEmpty()){
                    dirs.remove(dirs.size() - 1);
                }
            } else {
                if (dir.length() > 0) {
                    dirs.add(dir);
                }
            }
            dirEnd++;
            dirStart = dirEnd;
        }

        // combine all dirs
        StringBuilder sb = new StringBuilder("/");
        for (int i = 0; i < dirs.size(); i++) {
            if (i == dirs.size() - 1) {
                sb.append(dirs.get(i));
            } else {
                sb.append(dirs.get(i)).append("/");
            }
        }

        return sb.toString();
    }
}
