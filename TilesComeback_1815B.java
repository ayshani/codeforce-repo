import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TilesComeback_1815B {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            while(t-->0) {
                String[] inp = br.readLine().split(" ");
                int n = Integer.parseInt(inp[0]);
                int k = Integer.parseInt(inp[1]);
                long[] nums = new long[n];
                inp = br.readLine().split(" ");

                for(int i=0;i<n;i++){
                    nums[i] = Long.parseLong(inp[i]);
                }
                if(n==1 )
                    System.out.println("YES");
                else if(n==2 && k==2){
                    if(nums[0] == nums[1])
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                }
                else{
                    System.out.println(solve(n,k,nums));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String solve(int n,int k, long[] nums) {
        long first = nums[0], last = nums[n-1];
        int kthIndexFromStart = -1, kthIndexFromLast = -1;
        int startK=0, lastK=0;
        int i=0;
        while(i< n && startK<=k ){
            if(nums[i]==first){
                startK++;
            }
            if(startK==k){
                kthIndexFromStart=i;
                break;
            }
            i++;
        }
        i=n-1;
        while(i>=0 && lastK<=k ){
            if(nums[i]==last){
                lastK++;
            }
            if(lastK==k){
                kthIndexFromLast=i;
                break;
            }
            i--;
        }
        if(kthIndexFromStart==-1 || kthIndexFromLast==-1)
            return "NO";
        if(kthIndexFromStart<=kthIndexFromLast || first==last)
            return "YES";
        return "NO";
    }


}
