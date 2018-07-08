class Solution {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
//         int len1 = version1.length(), len2 = version2.length();
//         int v1Start = 0, v1End = 0;
//         int v2Start = 0, v2End = 0;
//         int result = 0;
//         while (v1End < len1 || v2End < len2) {
//             int v1 = 0, v2 = 0;

//             while (v1End < len1 && version1.charAt(v1End) != '.') v1End++;
//             while (v2End < len2 && version2.charAt(v2End) != '.') v2End++;

//             if (v1End < len1) {
//                 v1 = Integer.parseInt(version1.substring(v1Start, v2End));
//                 v1End++;
//                 v1Start = v1End;
//             }
//             if (v2End < len2) {
//                 v2 = Integer.parseInt(version2.substring(v2Start, v2End));
//                 v2End++;
//                 v2Start = v2End;
//             }

//             if (v1 > v2) {
//                 result = 1; break;
//             } else if (v1 < v2) {
//                 result = -1; break;
//             }
//         }

//         return result;
    }
}
