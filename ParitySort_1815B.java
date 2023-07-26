import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParitySort_1815B {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            while(t-->0) {
                int n = Integer.parseInt(br.readLine());
                List<Long> even = new ArrayList<>();
                List<Long> odd = new ArrayList<>();
                long[] nums = new long[n];
                String[] inp = br.readLine().split(" ");

                for(int i=0;i<n;i++){
                    nums[i] = Long.parseLong(inp[i]);
                    if(nums[i]%2==0)
                        even.add(nums[i]);
                    else{
                        odd.add(nums[i]);
                    }
                }
                if(n==1 ||even.size()==n || odd.size()==n)
                    System.out.println("YES");
                else
                    System.out.println(solve(n,even,odd,nums));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String solve(int n, List<Long> even, List<Long> odd, long[] nums) {

        Collections.sort(even);
        Collections.sort(odd);
        int index1=0, index2=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                nums[i] = even.get(index1);
                index1++;
            } else{
                nums[i] = odd.get(index2);
                index2++;
            }
            if(i>0 && nums[i]<nums[i-1])
                return "NO";
        }
        return "YES";
    }
}
