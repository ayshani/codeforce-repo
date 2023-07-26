import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://codeforces.com/problemset/problem/755/C

public class PolandBallAndForest_755C {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int n = Integer.parseInt(br.readLine());
            int[][] relation = new int[n][2];
            //parent[1]=-1;
            String[] s = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                int y = Integer.parseInt(s[i]);
                y--;
                relation[i] = new int[]{i,y};
            }
            System.out.println(solve(relation,n));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int[][] relations, int n) {
        UnionFind uf = new UnionFind(n);
        for(int[] relation : relations){
            uf.union(relation[0],relation[1]);
        }
        return uf.count;
    }

}

class UnionFind{
    int[] parent, rank;
    int count;

    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        count = n;
    }

    public int find(int x){
        if(parent[x]==x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y){
        int parentX = find(x), parentY = find(y);

        if(parentX==parentY){
           return;
        }
        count--;
        if(rank[parentY]<rank[parentX])
            parent[parentY] = parentX;
        else if(rank[parentY]>rank[parentX])
            parent[parentX] = parentY;
        else{
            parent[parentY] = parentX;
            rank[parentX]++;
        }
    }

}
