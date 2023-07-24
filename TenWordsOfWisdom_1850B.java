import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TenWordsOfWisdom_1850B {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                //System.out.println("hi");
                int n = Integer.parseInt(br.readLine());
                int[][] nums = new int[n][2];
                for (int i = 0; i < n; i++) {
                    String[] inp = br.readLine().split(" ");
                    nums[i][0] = Integer.parseInt(inp[0]);
                    nums[i][1] = Integer.parseInt(inp[1]);

                }
                solve(n, nums);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int n, int[][] nums) {
        int index =-1, max=-1;
        for(int i=0;i<n;i++){
            if(nums[i][0]<=10 && nums[i][1]>max){
                max = nums[i][1];
                index =i;
            }
        }
        System.out.println(index+1);
    }


}