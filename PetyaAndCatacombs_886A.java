import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//https://codeforces.com/blog/entry/55734
//https://blog.csdn.net/no_O_ac/article/details/81637600
public class PetyaAndCatacombs_886A {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            String[] inp = br.readLine().split(" ");
            for (int i = 0; i < n ; i++) {
                nums[i] = Integer.parseInt(inp[i]);
            }
            solve(n,nums);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int n, int[] nums) {

        int[] count = new int[n];
        int answer =1;
        for(int i=0;i<n;i++){
            if(count[nums[i]]==0)
                count[nums[i]]++;
            else
                answer++;
        }
        System.out.println(answer);
    }
}
