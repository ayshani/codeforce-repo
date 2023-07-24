//https://codeforces.com/problemset/problem/862/B
//https://pastebin.com/w3bF7gKS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MishaAndChangingHandles_501B {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            long q = Long.parseLong(br.readLine());
            Map<String,List<String>> graph = new HashMap<>();
            Map<String,Integer> map = new HashMap<>();
            for(long i=1;i<=q;i++){
                String[] inp =  br.readLine().split(" ");
                String x = inp[0];
                String y = inp[1];
                graph.computeIfAbsent(x, value -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, value -> new ArrayList<>());
                map.put(x,map.getOrDefault(x,0));
                map.put(y,map.getOrDefault(y,0)+1);
            }
            solve(graph,map,q);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solve(Map<String, List<String>> graph, Map<String, Integer> map, long q) {
        Set<String> set = new HashSet<>();
        for(Map.Entry<String ,Integer> entry : map.entrySet()){
            if(entry.getValue()==0)
                set.add(entry.getKey());
        }
        System.out.println(set.size());
        for(String cur : set){
            System.out.print(cur +" ");
            dfs(cur,"-1", graph);
            System.out.println();
        }
    }

    private static void dfs(String cur, String parent, Map<String, List<String>> graph) {
        if(graph.get(cur).size()==0){
            System.out.print(cur  +" ");
        }
        for(String next : graph.get(cur)){
            if(!next.equals(parent)){
                dfs(next,cur,graph);
            }
        }
    }


}
