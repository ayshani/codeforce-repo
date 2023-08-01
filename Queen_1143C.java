//https://codeforces.com/problemset/problem/1627/C
//https://www.acwing.com/solution/content/155991/
//https://codeforces.com/blog/entry/99067
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Queen_1143C {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();

            boolean flag = true;
            for (int i = 0; i < n; i++) {
                String[] inp = br.readLine().split(" ");
                int x = Integer.parseInt(inp[0]);
                int y = Integer.parseInt(inp[1]);
                if(x==-1){
                    set.add(i+1);
                }else if(y==0){
                    set.add(x);
                    set.add(i+1);
                }
            }
            if(set.size()==n)
                System.out.println(-1);
            else {
                for (int i = 1; i <= n; i++) {
                    if (!set.contains(i))
                        System.out.print(i+" ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
