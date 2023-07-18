//https://codeforces.com/problemset/problem/862/B
//https://pastebin.com/w3bF7gKS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MahmoudAndEhabAndTheBipartiteness_862B {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            long n = Long.parseLong(br.readLine());
            Map<Long,List<Long>> graph = new HashMap<>();
            for(long i=1;i<n;i++){
                String[] inp =  br.readLine().split(" ");
                long x = Long.parseLong(inp[0]);
                long y = Long.parseLong(inp[1]);
                graph.computeIfAbsent(x, value -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, value -> new ArrayList<>()).add(x);
            }
            long[] colors = new long[2];
            dfs(1,-1,graph,0,colors);
            System.out.println(colors[0]*colors[1] - n+1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(long cur, long parent, Map<Long, List<Long>> graph, int currentColor, long[] colors) {
        colors[currentColor]++;
        for(long next : graph.get(cur)){
            if(parent!=next){

                dfs(next,cur,graph,currentColor==1 ? 0:1,colors);
            }
        }
    }
}
