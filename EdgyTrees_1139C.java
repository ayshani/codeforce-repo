/*
https://codeforces.com/contest/1139/submission/51651756
https://codeforces.com/contest/1139/problem/C
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EdgyTrees_1139C {
    static long mod =(long)1e9 + 7;
    static long count =0;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            String[] inp  = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int k = Integer.parseInt(inp[1]);
            List<List<Integer>> edges = new ArrayList<>();
            for(int i=0;i<n;i++){
                edges.add(new ArrayList<>());
            }
            int[] degree = new int[n+1];
            for (int i = 0; i < n-1; i++) {
                inp  = br.readLine().split(" ");
                int x = Integer.parseInt(inp[0]);
                int y = Integer.parseInt(inp[1]);
                int c = Integer.parseInt(inp[2]);
                x--;
                y--;
                if(c==0) {
                    edges.get(x).add(y);
                    edges.get(y).add(x);
                }
            }
            //long total = (long)Math.pow(n,k)%mod;
            long total = fast_pow(n, k);
            long rem =0;

            boolean[] visited =  new boolean[n];
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    count =0;
                    dfs(i, edges,visited);
                    //rem += Math.pow(count,k) % mod;
                    rem += fast_pow(count, k);;
                }
            }
            rem %= mod;
            total = (total-rem+ mod)%mod;
            System.out.println(total);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(int i, List<List<Integer>> edges, boolean[] visited) {

        visited[i]= true;
        count++;
        for(int next : edges.get(i)){
            if(!visited[next]){
                dfs(next, edges,visited);
            }
        }
    }

    static long fast_pow(long a, long b) {
        if(b == 0)
            return 1L;

        long val = fast_pow(a, b / 2);

        if(b % 2 == 0)
            return val * val % mod;
        else
            return val * val % mod * a % mod;
    }
}


