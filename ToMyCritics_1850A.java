import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ToMyCritics_1850A {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                String[] s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                // its time complexity is big
                //printSum(n,k,x);

                solve(a,b,c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void solve(int a, int b, int c) {

        if(a+b>=10 || a+c>=10 || b+c>=10) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }


}
