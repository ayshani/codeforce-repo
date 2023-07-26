//https://codeforces.com/problemset/problem/1627/C
//https://www.acwing.com/solution/content/155991/
//https://codeforces.com/blog/entry/99067
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotAssigning_1627C {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            while(t-->0) {
                int n = Integer.parseInt(br.readLine());
                int[] degree = new int[n+1];
                List<List<Pair>> graph = new ArrayList<>();
                for(int i=0;i<=n;i++){
                    graph.add(new ArrayList<>());
                }
                boolean flag = true;
                for (int i = 0; i < n-1; i++) {
                    String[] inp = br.readLine().split(" ");
                    int x = Integer.parseInt(inp[0]);
                    int y = Integer.parseInt(inp[1]);
                    graph.get(x).add(new Pair(y,i));
                    graph.get(y).add(new Pair(x,i));
                    degree[x]++;
                    degree[y]++;
                    if(degree[x]>2 || degree[y]>2) {
                        flag =false;
                    }
                }
                if(!flag){
                    System.out.println("-1");
                } else {
                    solve(n, graph, degree);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solve(int n, List<List<Pair>> graph, int[] degree) {
        int startIndex =0;
        for(int i=1;i<=n;i++){
            if(degree[i]==1){
                startIndex=i;
                break;
            }
        }
        int[] res = new int[n];
        //res[startIndex] = 3;
        dfs(startIndex, -1, graph,res,  2);
        for (int i=0;i<n-1;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    private static void dfs(int startIndex, int parent, List<List<Pair>> graph, int[] res, int color) {
        for(Pair next : graph.get(startIndex)){
            if(next.y!=parent){
                res[next.index] = color;
                dfs(next.y,startIndex,graph,res,5-color);
            }
        }
    }
}

class Pair{
    int y, index;
    public Pair(int y, int indx){
        this.y = y;
        this.index = indx;
    }
}
