import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class VampiricPowersAnyon_882A {


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
                System.out.println(getMaxValue(n, nums));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getMaxValue(int n, long[] nums) {
        if(n==0){
            return 0;
        }
        if(n<2){
            return nums[0];
        }
        long max = 0,  x=0;
        Set<Long> set = new HashSet<>();
        for(int i=1;i<n;i++) {
            x ^= nums[i];
            set.add(x);
        }
        for(long i : set){
            for(long j : set) {
                max = Math.max(max, i^j);
            }
        }
        return max;
    }


}
