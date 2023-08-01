/*
https://codeforces.com/problemset/problem/839/C
https://codeforces.com/contest/839/submission/29412220
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Journey_839C {
    static int total =0;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            int n = Integer.parseInt(br.readLine());

            List<List<Integer>> graph = new ArrayList<>();

            for(int i=0;i<n;i++){
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < n-1; i++) {
                String[] inp  = br.readLine().split(" ");
                int x = Integer.parseInt(inp[0]);
                int y = Integer.parseInt(inp[1]);
                x--;
                y--;
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
            System.out.println(solve(n,graph));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static double solve(int n, List<List<Integer>> graph) {
        return dfs(0,-1,graph);
    }

    private static double dfs(int cur, int parent, List<List<Integer>> graph){
        double sum =0;
        for(int next : graph.get(cur)){
            if(next !=parent){
                sum += dfs(next, cur, graph) +1;
            }
        }
        return sum>0 ? ( sum /(graph.get(cur).size()- (parent==-1? 0.0:1.0))) : 0;
    }

}

