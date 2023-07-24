import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CardboardForPictures_1850E {
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
                long c = Long.parseLong(inp[1]);
                long[] nums = new long[n];
                inp = br.readLine().split(" ");
                for(int i=0;i<n;i++){
                    nums[i] = Long.parseLong(inp[i]);
                }
                System.out.println(solve(n,nums, c));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int n, long[] nums, long c) {
        for(int i=1;i*i<=(int)Math.sqrt(c);i++){
            long sum =0;
            for(int j=0;j<nums.length;j++){
                sum += (nums[j]+(2*i))*(nums[j]+(2*i));
                if(sum>c)
                    break;
            }
            if(sum==c)
                return i;
        }
        return -1;
    }

}
