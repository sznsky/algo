package week8.task;

import java.util.Arrays;

/**
 * 684. 冗余连接
 */
public class NO_684_RedundantConnection {

    int findSet(int[] bset, int a) {
        if (bset[a] == -1) {
            return a;
        }
        return bset[a] = findSet(bset, bset[a]);
    }

    void unionSet(int[] bset, int a, int b) {
        int ai = findSet(bset, a);
        int bi = findSet(bset, b);
        if (ai != bi) {
            bset[ai] = bi;
        }
    }

    // 肯定会有多个解
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        int[] bset = new int[n + 1];
        Arrays.fill(bset, -1);

        for (int i = 0; i < n; i++) {
            int[] e = edges[i];
            if (findSet(bset, e[0]) == findSet(bset, e[1])) return e;
            unionSet(bset, e[0], e[1]);
        }

        // can't reachable
        return new int[0];
    }
}
