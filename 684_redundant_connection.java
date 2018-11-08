class Solution {

    class UnionFind {
        int[] parent;

        public UnionFind(int[][] edges) {
            Set<Integer> set = new HashSet<>();
            for (int[] pair: edges) {
                set.add(pair[0]);
                set.add(pair[1]);
            }
            parent = new int[set.size() + 1];
            for (int i = 1; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void union(int ele1, int ele2) {
            int root1 = find(ele1);
            int root2 = find(ele2);
            parent[root1] = root2;  // ele2 (child) has a far parent, so use it
        }

        public int find(int ele) {
            if (parent[ele] != ele) {
                parent[ele] = find(parent[ele]);
            }
            return parent[ele];
        }

        public void print() {
            for (int par: parent) {
                System.out.print(par + " ");
            }
            System.out.println();
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges);
        for (int[] pair: edges) {
            int child = pair[1];
            int parent = pair[0];
            if (uf.find(child) == uf.find(parent)) {
                return pair;
            } else {
                uf.union(parent, child);
            }
        }
        return null;
    }
}
