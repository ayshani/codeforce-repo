import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


//https://codeforces.com/blog/entry/12265
//https://github.com/aanupam29/codeforces-problems/blob/master/429A%20-%20Xor-tree.cpp

public class XorTree_429A {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int n = Integer.parseInt(br.readLine());
            List<List<Long>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                String[] inp = br.readLine().split(" ");
                long u = Long.parseLong(inp[0]);
                long v = Long.parseLong(inp[1]);
                u--;
                v--;
                graph.get((int) u).add(v);
                graph.get((int) v).add(u);
            }
            int[] init = new int[n];

            int[] goal = new int[n];
            String[] inp = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                init[i] = Integer.parseInt(inp[i]);
            }

            inp = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                goal[i] = Integer.parseInt(inp[i]);
            }
            solve(n, graph,init,goal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int n, List<List<Long>> graph, int[] init, int[] goal) {
        List<Integer> result = new ArrayList<>();
        int level =0, oddLevelCount =0, evenLevelCount=0;
        dfs(0,-1,graph,init,goal,result, level, oddLevelCount, evenLevelCount);
        System.out.println(result.size());
        for (int node: result){
            System.out.println(node+1);
        }
    }

    private static void dfs(int node, int parent, List<List<Long>> graph, int[] init, int[] goal, List<Integer> result, int level, int oddLevelCount, int evenLevelCount) {
        if(level==0){
            if(evenLevelCount%2==1){
                init[node] = 1- init[node];
            }
            if(init[node]!= goal[node]){
                init[node] = 1- init[node];
                evenLevelCount++;
                result.add(node);
            }
        } else{
            if(oddLevelCount%2==1){
                init[node] = 1- init[node];
            }
            if(init[node]!= goal[node]){
                init[node] = 1- init[node];
                oddLevelCount++;
                result.add(node);
            }
        }
        for(Long child : graph.get(node)){
            if(child!=parent){
                dfs(Math.toIntExact(child),node,graph,init,goal,result,1-level,oddLevelCount,evenLevelCount);
            }
        }
    }


}
