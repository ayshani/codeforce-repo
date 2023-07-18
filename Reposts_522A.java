import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://codeforces.com/problemset/problem/522/A
public class Reposts_522A {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int n = Integer.parseInt(br.readLine());
            Map<String, List<String>> graph = new HashMap<>();
            while(n-->0){
                //System.out.println("hi");
                String[] edge = br.readLine().split(" ");
                String from = edge[2].toLowerCase();
                String to = edge[0].toLowerCase();
                graph.computeIfAbsent(from, value -> new ArrayList<String>()).add(to);
                graph.computeIfAbsent(to, value -> new ArrayList<String>());
            }

            System.out.println(getLevel(graph));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getLevel(Map<String, List<String>> graph) {

        if(graph.size()==0)
            return -1;

        Queue<String> q = new LinkedList<>();
        q.offer("polycarp");
        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String cur = q.poll();
                for(String next : graph.get(cur)){
                    q.offer(next);
                }
            }
            level++;
        }
        return level;
    }


}
