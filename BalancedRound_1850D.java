import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BalancedRound_1850D {
    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                //System.out.println("hi");
                String[] inp = br.readLine().split(" ");
                int n = Integer.parseInt(inp[0]);
                int k = Integer.parseInt(inp[1]);
                int[] nums = new int[n];
                inp = br.readLine().split(" ");
                for(int i=0;i<n;i++){
                    nums[i] = Integer.parseInt(inp[i]);
                }
                System.out.println(solve(n,nums, k));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int n, int[] nums, int k) {
        if(n==1 && k>=1)
            return 0;
        Arrays.sort(nums);
        int count=1, max =1;
        for(int i =1; i<n;i++){
            if(nums[i]- nums[i-1]>k){
                count=1;
            } else{
                count++;
            }
            max =  Math.max(max, count);
        }

        return n-max;
    }

}
