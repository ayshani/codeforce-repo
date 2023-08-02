/*
https://codeforces.com/problemset/problem/1325/C
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EhabAndPathEticMEXs_1325C {
    static int total =0;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            int n = Integer.parseInt(br.readLine());


            ArrayList<MEXpair> edges = new ArrayList<>();

            int[] degree = new int[n+1];
            for (int i = 1; i < n; i++) {
                String[] inp  = br.readLine().split(" ");
                int x = Integer.parseInt(inp[0]);
                int y = Integer.parseInt(inp[1]);
                edges.add(new MEXpair(x,y));
                degree[x]++;
                degree[y]++;
            }
            int small = 0;
            int large = n-2;
            int[] ans = new int[n-1];

            for(int i = 0;i<n-1;i++) {
                MEXpair edge = edges.get(i);
                if (degree[edge.x] == 1 || degree[edge.y] == 1) {
                    ans[i] = small++;
                } else {
                    ans[i] = large--;
                }
            }
            for (int i : ans ){
                System.out.println(i);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class MEXpair{
    int x, y;
    public MEXpair(int x, int y){
        this.x = x;
        this.y =y;
    }
}

