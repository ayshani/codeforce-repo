//https://codeforces.com/problemset/problem/802/J
//https://assets.codeforces.com/files/helvetic/helvetic-coding-contest-2017-editorial.pdf

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KefaAndPark_580C {
    static int total =0;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int m = Integer.parseInt(inp[1]);
            List<List<Integer>> graph = new ArrayList<>();
            int[] c = new int[n];
            inp = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                c[i] = Integer.parseInt(inp[i]);
            }
            for(int i=0;i<n;i++){
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < n-1; i++) {
                inp = br.readLine().split(" ");
                int x = Integer.parseInt(inp[0]);
                int y = Integer.parseInt(inp[1]);
                x--;
                y--;
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
            System.out.println(solve(n,m,graph,c));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int solve(int n,int m, List<List<Integer>> graph, int[] c) {

        int count =0;
        dfs(0,-1,graph,c,m,count);
        return total;
    }

    private static void dfs(int cur, int parent, List<List<Integer>> graph,int[] c,int k,  int count) {
        if(c[cur]==1)
            count++;
        else
            count=0;
        if(count>k) {
            if(c[cur]==1)
                count--;
            return;
        }
        if(graph.get(cur).size()==1 && graph.get(cur).get(0)==parent){
            total++;
            if(c[cur]==1)
                count--;
            return;
        }

        for(Integer next : graph.get(cur)){
            if(next!=parent ){
                dfs(next, cur,graph,c,k, count);
            }
        }

        if(c[cur]==1)
            count--;
    }
}

