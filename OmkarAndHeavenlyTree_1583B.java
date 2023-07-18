import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://codeforces.com/problemset/problem/1583/B

/*
Because the number of restrictions is less than 𝑛
, there is guaranteed to be at least one value from 1
 to 𝑛
 that is not a value of 𝑏
 for any of the restrictions. Find a value that is not 𝑏
 for all of the restrictions and construct a tree that is a "star" with that value in the middle. An easy way to
 do this is to make an edge from that value to every other number from 1
 to 𝑛
.
 */
public class OmkarAndHeavenlyTree_1583B {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {

                String[] s = br.readLine().split(" ");
                int n = Integer.parseInt(s[0]);
                int m = Integer.parseInt(s[1]);
                Map<Integer, List<Integer>> graph = new HashMap<>();
                Set<Integer> set = new HashSet<>();
                for(int i=1;i<=n;i++)
                    set.add(i);
                for(int i=0;i<m;i++){
                    s = br.readLine().split(" ");
                    int a = Integer.parseInt(s[0]);
                    int b = Integer.parseInt(s[1]);
                    int c = Integer.parseInt(s[2]);

                    if(set.contains(b))
                        set.remove(b);
                }
                int start =0;
                for(int i: set){
                    start =i;
                    break;
                }
                for(int i=1;i<=n;i++){
                    if(i!=start)
                        System.out.println(i +" "+ start);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
