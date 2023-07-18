import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppleTree_1843D {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {

                int n = Integer.parseInt(br.readLine());
                Map<Integer, List<Integer>> graph = new HashMap<>();
                for(int i=0;i<n-1;i++){
                    String[] s = br.readLine().split(" ");
                    int x = Integer.parseInt(s[0]);
                    int y = Integer.parseInt(s[1]);
                    x--;
                    y--;
                    //int min = Math.min(x,y);
                    //int max = Math.max(x,y);
                    graph.computeIfAbsent(x, value -> new ArrayList<>()).add(y);
                    graph.computeIfAbsent(y, value -> new ArrayList<>()).add(x);
                }
                long[] countMap = new long[n];
                precompute(graph,n,countMap);
                int q = Integer.parseInt(br.readLine());

                while(q-->0){
                    String[] s = br.readLine().split(" ");
                    int x = Integer.parseInt(s[0]);
                    int y = Integer.parseInt(s[1]);
                    x--;
                    y--;
                    System.out.println(countMap[x]*countMap[y]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void precompute(Map<Integer, List<Integer>> graph, int n, long[] countMap) {
        //boolean[] visited = new boolean[n];
        dfs(0,graph,-1,countMap);
    }

    private static void dfs(int i, Map<Integer, List<Integer>> graph, int parent, long[] countMap) {

        if(graph.get(i).size()==1 && graph.get(i).get(0)==parent){
            countMap[i]=1;
            return;
        }
        for(int next : graph.get(i)){
            //if(next==parent)
                //continue;
            if(next!=parent) {
                dfs(next, graph, i, countMap);
                countMap[i] += countMap[next];
            }
        }
    }


}
