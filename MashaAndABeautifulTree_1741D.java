import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://codeforces.com/problemset/problem/1741/D
//https://codeforces.com/blog/entry/107908
public class MashaAndABeautifulTree_1741D {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            long t = Long.parseLong(br.readLine());

            while(t-->0){
                //System.out.println("hi");
                int m = Integer.parseInt(br.readLine());
                String[] input = br.readLine().split(" ");
                long[] nums = new long[m];
                for(int i=0;i<m;i++){
                    nums[i] = Long.parseLong(input[i]);
                }
                System.out.println(getRequiredOperations(m, nums));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getRequiredOperations(int m, long[] nums) {
        long ans = solve(nums,0,m);
        if(isSorted(nums))
            return ans;
        return -1;
    }

    private static long solve(long[] nums, int low, int high) {
        if(high-low==1)
            return 0;
        int mid = (low+high)/2;
        long maxLow = getMax(nums,low,mid);
        long maxHigh = getMax(nums,mid,high);
        int ans =0;
        if(maxLow>maxHigh){
            ans++;
            for(int i=0;i<(mid-low);i++){
                swap(nums,low+i,mid+i);
            }
        }
        return solve(nums,low,mid)+ solve(nums,mid,high)+ans;
    }

    private static void swap(long[] nums, int i, int j) {
        long temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static long getMax(long[] nums, int low, int high) {

        long max = nums[low];
        for(int i=low;i<high;i++){
            max = Math.max(max,nums[i]);
        }
        return max;
    }

    private static boolean isSorted(long[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1])
                return false;
        }
        return true;
    }


}
