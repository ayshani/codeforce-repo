import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                //System.out.println("hi");
                int n = Integer.parseInt(br.readLine());

                long[][] nums = new long[n][2];
                for(int i=0;i<n;i++){
                    String[] input = br.readLine().split(" ");
                    nums[i][0] = Long.parseLong(input[0]);
                    nums[i][1] = Long.parseLong(input[1]);
                }
                System.out.println(getCount(n, nums));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getCount(int n, long[][] nums) {
        long count =0;
        for(int i=0;i<n;i++){
            if(nums[i][0]-nums[i][1]>0){
                count++;
            }
        }
        return count;
    }
}
