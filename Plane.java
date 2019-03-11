/*
Given a list of [origin, destination] pairs (you could think of them as plane tickets), sort them into a single continuous route.
Sample Input
[
    ["SFO", "EWR"],
    ["SJC", "LAX"],
    ["DFW", "SJC"],

    ["SJC", "MOU"]

    ["EWR", "OAK"],
    ["LAX", "SFO"]
]


Desired output
["DFW", "SJC", "LAX", "SFO", "EWR", "OAK"]
["DFW", "SJC", "OAK"]

BFS?
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    class Pair {
        String origin;
        String dest;
        Pair() {

        }
    }

    public List<List<String>> findRoute(List<Pair> pairs) {
        Set<String> uniqueSet = new HashSet<>();
        for (Pair pair: pairs) {
            uniqueSet.add(pair.origin);
            uniqueSet.add(pair.dest);
        }
        int N = uniqueSet.size();

        Queue<String> queue = new LinkedList<>();
        for (String city: uniqueSet) {
            boolean isPreExist = false;
            for (Pair pair: pairs) {
                if (pair.dest.equals(city)) {
                    isPreExist = true;
                }
            }
            if (!isPreExist) {
                queue.offer(city);
            }
        }

        Set<List<String>> paths = new HashSet<>();
        List<String> temp = new ArrayList<>();
        Set<String> visited = new HashSet<>();  //

        while (queue.size() != 0) {
            List<String> curr = new ArrayList<>(temp);

            String city = queue.poll();
            curr.add(city);

            // N = 6
            // ["DFW", "SJC", "LAX", "SFO", "EWR", "OAK"]: len = 6
            // ["DFW", "SJC", "OAK"]: len = 3

              // == 10,  the len of the route may be 3,
                boolean isDestExist = false;
            for (Pair pair: pairs) {
                paths.add(new ArrayList<>(curr));
            }

            for (Pair pair: pairs) {
                if (pair.origin.equals(city) && !visited.contains(pair.dest)) {
                    queue.offer(pair.dest);
                }
            }
        }
        // DFW, SJC, MOU
        // DFW, SJC, DAS


        // find mapping
        // List<String> cityNames = new ArrayList<>();
        // for (String city: uniqueSet) {
        //     cityNames.add(city);
        // }

        // Map<String, Integer> map = new HashMap<>();
        // for (int i = 0; i < cityNames.size(); i++) {
        //     map.put(i, cityNames.get(i));
        // }
        // int N = uniqueSet.size();


        // int[] indexes = new int[N];
        // "1": "DFW", "2": "SFO"

        // adjancet cities
        // int[][] adj = new int[N][N];    // adj[i][j]

        // find out the start city
        // int[] indegress = new int[uniqueSet.size()];
        // for (int i = 0; i < pairs.size(); i++) {
        //     String origin = pair.origin;
        //     String dest = pair.dest;
        //     if (adj[][] == 0) {

        //     }
        // }
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
}
