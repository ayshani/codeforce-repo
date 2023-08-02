/*
https://codeforces.com/problemset/problem/982/C
https://github.com/debsourav33/CodeForces-Problem-Solutions/blob/master/982C-%20Cut%20'em%20all!.cpp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CutEmAll_982C {
    static long evens =0;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {


            int n = Integer.parseInt(br.readLine());
            if(n%2==1)
                System.out.println(-1);
            else{
                List<List<Integer>> edges = new ArrayList<>();
                for(int i=0;i<n;i++){
                    edges.add(new ArrayList<>());
                }
                evens=0;
                for (int i = 0; i < n-1; i++) {
                    String[] inp  = br.readLine().split(" ");
                    int x = Integer.parseInt(inp[0]);
                    int y = Integer.parseInt(inp[1]);
                    x--;
                    y--;
                    edges.get(x).add(y);
                    edges.get(y).add(x);
                }
                boolean[] visited =  new boolean[n];

                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        dfs(i, -1, edges, visited);
                    }
                }
                System.out.println(evens - 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int dfs(int i,int parent,  List<List<Integer>> edges, boolean[] visited) {

        visited[i]= true;
        int count =1;
        for(int next : edges.get(i)){
            if(next != parent && !visited[next]){
                count += dfs(next,i, edges,visited);
            }
        }
        if(count%2==0)
            evens++;
        return count;
    }

}


