import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://codeforces.com/problemset/problem/913/B
public class ChristmasSpruce_913B {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int n = Integer.parseInt(br.readLine());
            int[] parent = new int[n];
            for(int i=1;i<n;i++){
                parent[i]= Integer.parseInt(br.readLine());
                parent[i]--;
            }

            System.out.println(isSpruce(parent, n) ? "YES" : "NO");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isSpruce(int[] parent, int n) {
        int[] degree = new int[n];
        for(int i=1;i<n;i++){
            degree[parent[i]]++;
        }
        int[] numerOfSons = new int[n];
        for(int i=0;i<n;i++){
            if(degree[i]==0)
                numerOfSons[parent[i]]++;
        }
        for(int i=0;i<n;i++){
            if(degree[i]>0 && numerOfSons[i]<3) {
                return false;
            }
        }
        return true;
    }


}
