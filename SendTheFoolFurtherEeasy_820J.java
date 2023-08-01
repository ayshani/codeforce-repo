//https://codeforces.com/problemset/problem/802/J
//https://assets.codeforces.com/files/helvetic/helvetic-coding-contest-2017-editorial.pdf
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SendTheFoolFurtherEeasy_820J {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            int n = Integer.parseInt(br.readLine());
            List<List<FoolPair>> graph = new ArrayList<>();
            for(int i=0;i<n;i++){
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < n-1; i++) {
                String[] inp = br.readLine().split(" ");
                int x = Integer.parseInt(inp[0]);
                int y = Integer.parseInt(inp[1]);
                int c = Integer.parseInt(inp[2]);
                graph.get(x).add(new FoolPair(y,c));
                graph.get(y).add(new FoolPair(x,c));
            }
            System.out.println(solve(n,graph));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int solve(int n, List<List<FoolPair>> graph) {

        boolean[] visited = new boolean[n];
        return dfs(0,-1,graph,visited, 0);
    }

    private static int dfs(int cur, int parent, List<List<FoolPair>> graph, boolean[] visited, int maxCost) {
        visited[cur] = true;
        int currentCost =0;
        for(FoolPair next : graph.get(cur)){
            if(next.y!=parent && !visited[next.y]){
                currentCost = Math.max(currentCost, dfs(next.y, cur,graph,visited,next.cost));
            }
        }
        maxCost =  maxCost+currentCost;
        return maxCost;
    }
}

class FoolPair{
    int y, cost;
    public FoolPair(int y, int cost){
        this.y =y;
        this.cost = cost;
    }
}
