import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//https://codeforces.com/problemset/problem/1559/D1
//https://codeforces.com/blog/entry/93898
public class MochaAndDianaEasyVersion_1559D1 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //int t = Integer.parseInt(br.readLine());
            //while(t-->0) {
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int m1 = Integer.parseInt(inp[1]);
            int m2 = Integer.parseInt(inp[2]);
            List<List<Integer>> graphMocha = new ArrayList<>();
            List<List<Integer>> graphDiana = new ArrayList<>();
            for(int i=0;i<=n;i++){
                graphMocha.add(new ArrayList<>());
                graphDiana.add(new ArrayList<>());
            }
            List<int[]> res = new ArrayList<>();
            UnionFindMochaAndDiana ufMocha = new UnionFindMochaAndDiana(n);
            UnionFindMochaAndDiana ufDiana = new UnionFindMochaAndDiana(n);
            for (int i = 0; i < m1; i++) {
                inp = br.readLine().split(" ");
                int x = Integer.parseInt(inp[0]);
                int y = Integer.parseInt(inp[1]);
                ufMocha.union(x,y);
            }

            for (int i = 0; i < m2; i++) {
                inp = br.readLine().split(" ");
                int x = Integer.parseInt(inp[0]);
                int y = Integer.parseInt(inp[1]);
                ufDiana.union(x,y);
            }

            for(int i=1;i<=n;i++){
                for(int j=i+1;j<=n;j++){
                    int mochaX = ufMocha.find(i), mochaY = ufMocha.find(j);
                    int dianaX = ufDiana.find(i), dianaY = ufDiana.find(j);
                    if(mochaX!=mochaY && dianaX!=dianaY){
                        res.add(new int[]{i,j});
                        ufMocha.union(i,j);
                        ufDiana.union(i,j);
                    }
                }
            }
            System.out.println(res.size());
            for(int[] pair : res){
                System.out.println(pair[0] +" "+pair[1]);
            }
            //}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class UnionFindMochaAndDiana{
    int[] parent, rank;
    public UnionFindMochaAndDiana(int n){
        parent = new int[n+1];
        rank =  new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
    }

    public int find(int x){
        if(parent[x]==x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y){
        int parentX = find(x), parentY = find(y);
        if(parentX==parentY)
            return;
        if(rank[parentX]>rank[parentY]){
            parent[parentY] = parent[parentX];
        } else if(rank[parentX]<rank[parentY]) {
            parent[parentX] = parent[parentY];
        } else{
            parent[parentY] = parent[parentX];
            rank[parentX]++;
        }
    }
}
