import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BmailComputerNetwork_1057A {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int n = Integer.parseInt(br.readLine());
            int[] parent = new int[n+1];
            //parent[1]=-1;
            String[] s = br.readLine().split(" ");
            for(int i=2;i<=n;i++){
                parent[i] = Integer.parseInt(s[i-2]);
            }
            getPath(n,parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void getPath(int n, int[] parent) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<=n;i++){
            graph.get(parent[i]).add(i);
        }
        Stack<Integer> st = new Stack<>();
        boolean isPresent = dfs(1,n, graph,st);
        if(isPresent){
            //st.push(1);
            while(!st.isEmpty()){
                System.out.print(st.pop()+" ");
            }
        }
        System.out.println();
    }

    private static boolean dfs(int cur,int target, List<List<Integer>> graph,Stack<Integer> st) {
        if(cur==target){
            st.push(cur);
            return true;
        }
        for(int next : graph.get(cur)){
            if(dfs(next,target, graph,st)) {
                st.push(cur);
                return true;
            }
        }
        return false;
    }


}
