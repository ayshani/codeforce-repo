import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

//https://codeforces.com/problemset/problem/1675/D
//https://codeforces.com/blog/entry/102550
public class VerticalPaths_1678D {
    static int[] parent;
    static boolean[] isLeaf;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            long t = Long.parseLong(br.readLine());

            while(t-->0){
                int n = Integer.parseInt(br.readLine());
                String[] input = br.readLine().split(" ");
                parent = new int[n+1];
                isLeaf = new boolean[n+1];
                Arrays.fill(isLeaf,true);
                for(int i=1;i<=n;i++){
                    parent[i] = Integer.parseInt(input[i-1]);
                    isLeaf[parent[i]] = false;
                }
                totalPaths(n);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void totalPaths(int n) {
        if(n==1) {
            System.out.println(1+"\n"+1+"\n"+1);
            return;
        }
        Set<Integer> leafSet = new HashSet<>();
        int count =0;
        for(int i=1;i<=n;i++){
            if(isLeaf[i]){
                leafSet.add(i);
                count++;
            }
        }
        System.out.println(count);
        boolean[]  visited = new boolean[n+1];
        for(int i : leafSet){
            List<Integer> curPath = new ArrayList<>();
            visited[i] = true;
            curPath.add(i);
            int v =i;
            while(parent[v]!=v && !visited[parent[v]]){
                v = parent[v];
                visited[v]= true;
                curPath.add(v);
            }
            System.out.println(curPath.size());
            for(int j=curPath.size()-1; j>=0;j--)
                System.out.print(curPath.get(j) +" ");
            System.out.println();
        }
        System.out.println();
    }

}
