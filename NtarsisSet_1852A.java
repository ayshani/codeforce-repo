import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NtarsisSet_1852A {
    static List<Long> list = new ArrayList<>();
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
                long k = Long.parseLong(inp[1]);
                long[] nums = new long[n];
                inp = br.readLine().split(" ");
                for(int i=0;i<n;i++){
                    nums[i] = Long.parseLong(inp[i]);
                }


                System.out.println(solve(n,nums, k));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int n, long[] nums, long k) {
        for(int i=1;i<=n*k;i++){
            list.add((long) i);
        }

        while(k-->0){
            for(int i=0;i<n;i++){
                list.remove(nums[i]-1);
            }
        }
        return Math.toIntExact(list.get(0));

    }

}
