public class UnionFindQuiz1 {

  static class LocalQuickFindUF {
    private int[] id;
    private int count;

    // instantiate N isolated components 0 through N-1
    public LocalQuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    // return number of connected components
    public int count() {
        return count;
    }

    // Return component identifier for component containing p
    public int find(int p) {
        return id[p];
    }

    // are elements p and q in the same component?
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // merge components containing p and q
    public void union(int p, int q) {
        if (connected(p, q)) return;
        int pid = id[p];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = id[q];
        count--;
    }
  }

  static class LocalQuickUnionUF {
    public int[] id;    // id[i] = parent of i
    private int count;   // number of components

    // instantiate N isolated components 0 through N-1
    public LocalQuickUnionUF(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // return number of connected components
    public int count() {
        return count;
    }

    // return root of component corresponding to element p
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    // are elements p and q in the same component?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // merge components containing p and q
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        id[i] = j;
        count--;
    }
  }

  static class LocalWeightedQuickUnionUF {
    public int[] id;    // id[i] = parent of i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components

    // Create an empty union find data structure with N isolated sets.
    public LocalWeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    // Return the number of disjoint sets.
    public int count() {
        return count;
    }

    // Return component identifier for component containing p
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

   // Are objects p and q in the same set?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


   // Replace sets containing p and q with their union.
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // make smaller root point to larger one
        if   (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else                 { id[j] = i; sz[i] += sz[j]; }
        count--;
    }
  }

  public static void main (String[] argv) {
    int N = 10;

    LocalQuickFindUF qf = new LocalQuickFindUF(10);
    qf.union(6, 5);
    qf.union(9, 1);
    qf.union(5, 7);
    qf.union(3, 5);
    qf.union(8, 0);
    qf.union(8, 7);

    for (int i = 0; i < N; i++) {
      StdOut.printf("%s ", qf.id[i]);
    }
    StdOut.printf("%n");

    LocalWeightedQuickUnionUF wqf =
        new LocalWeightedQuickUnionUF(10);
    //2-5 3-8 5-6 9-4 0-7 0-1 8-0 2-4 9-1
    wqf.union(2, 5);
    wqf.union(3, 8);
    wqf.union(5, 6);
    wqf.union(9, 4);
    wqf.union(0, 7);
    wqf.union(0, 1);
    wqf.union(8, 0);
    wqf.union(2, 4);
    wqf.union(9, 1);

    for (int i = 0; i < N; i++) {
      StdOut.printf("%s ", wqf.id[i]);
    }
    StdOut.printf("%n");

  }

}