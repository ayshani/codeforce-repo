import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Party_115A {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int n = Integer.parseInt(br.readLine());
            int[] parent = new int[n];
            for(int i=0;i<n;i++){
                int inp = Integer.parseInt(br.readLine());
                if(inp!=-1)
                    parent[i] = inp-1;
                else
                    parent[i] = inp;

            }
            System.out.println(getMaxLevel(n, parent));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static int getMaxLevel(int n, int[] parent) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(parent[i]!=-1)
                graph.get(parent[i]).add(i);
        }
        int maxLevel = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(parent[i]==-1){
                maxLevel = Math.max(maxLevel, dfs(i, graph,1));
            }
        }
        return maxLevel;
    }

    private static int dfs(int cur, List<List<Integer>> graph, int level) {
        int curLevel =level;
        for(int next : graph.get(cur)){
            curLevel = Math.max(curLevel, dfs(next,graph,level+1));
        }
        return curLevel;
    }


}
