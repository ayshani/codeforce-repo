import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheManWhoBecameAGod_882A {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                //System.out.println("hi");
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int k = Integer.parseInt(input[1]);
                input = br.readLine().split(" ");
                long[] nums = new long[n];
                for(int i=0;i<n;i++){
                    nums[i] = Long.parseLong(input[i]);
                }
                System.out.println(getMaxSum(n, nums,k));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long  getMaxSum(int n, long[] nums, int k){
        if(n<2)
            return 0;
        List<Long> list = new ArrayList<>();
        for(int i=1;i<n;i++){
            list.add(Math.abs(nums[i]- nums[i-1]));
        }
        Collections.sort(list);
        long sum =0;
        for(int i=0;i<=list.size()-k;i++){
            sum+=list.get(i);
        }
        return sum;
    }
}
