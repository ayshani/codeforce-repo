import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordOnThePaper_1850C {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                //System.out.println("hi");
                char[][] nums = new char[8][8];
                for (int i = 0; i < 8; i++) {
                    char[] inp = br.readLine().toCharArray();
                    nums[i] = inp;
                }
                solve(nums);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(char[][] nums) {
        StringBuilder sb = new StringBuilder();
        int i=0, j=0;
        for(i=0;i<8;i++){
            boolean flag = false;
            for(j=0;j<8;j++) {
                if (nums[i][j] != '.') {
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }

        while( j <8 && i<8 && nums[i][j] !='.'){
            sb.append(nums[i][j]);
            i++;
        }

        System.out.println(sb);
    }


}