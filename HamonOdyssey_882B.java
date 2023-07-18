import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HamonOdyssey_882B {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                //System.out.println("hi");
                int n = Integer.parseInt(br.readLine());
                String[] input = br.readLine().split(" ");
                long[] nums = new long[n];
                for(int i=0;i<n;i++){
                    nums[i] = Long.parseLong(input[i]);
                }
                System.out.println(getCountOfGroup(n, nums));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long  getCountOfGroup(int n, long[] nums){
        if(n<2)
            return n;

        long count =0, andSum =nums[0];

        for(int i=0;i<n;i++){
            andSum &= nums[i];
            if(andSum==0) {
                count++;
                if (i < n - 1)
                    andSum = nums[i + 1];
            }
        }
        return count==0? 1: count;
    }
}
