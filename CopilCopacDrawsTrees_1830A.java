//https://codeforces.com/problemset/problem/1830/A
//https://codeforces.com/blog/entry/116527
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CopilCopacDrawsTrees_1830A {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            while(t-->0) {
                int n = Integer.parseInt(br.readLine());
                List<List<CCDPair>> graph = new ArrayList<>();
                for(int i=0;i<=n;i++){
                    graph.add(new ArrayList<>());
                }
                for (int i = 0; i < n-1; i++) {
                    String[] inp = br.readLine().split(" ");
                    int x = Integer.parseInt(inp[0]);
                    int y = Integer.parseInt(inp[1]);
                    graph.get(x).add(new CCDPair(y,i+1));
                    graph.get(y).add(new CCDPair(x,i+1));

                }
                System.out.println(solve(n, graph));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long solve(int n, List<List<CCDPair>> graph) {
        long[] dp= new long[n+1], id = new long[n+1];
        dp[1]=1;
        dfs(1, graph,dp,id);
        long max =0;
        for(int i=1;i<=n;i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static void dfs(int cur, List<List<CCDPair>> graph, long[] dp, long[] id) {

        for(CCDPair next : graph.get(cur)){
            if(dp[next.y]==0){
                dp[next.y] =  dp[cur] + (next.index<=id[cur]? 1: 0);
                id[next.y] = next.index;
                dfs(next.y, graph,dp,id);
            }
        }
    }
}

class CCDPair{
    int y, index;
    public CCDPair(int y, int indx){
        this.y = y;
        this.index = indx;
    }
}
