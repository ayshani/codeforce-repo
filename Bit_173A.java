import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://codeforces.com/problemset/problem/282/A

 */
public class Bit_173A {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int n = Integer.parseInt(br.readLine());
            int sum =0;
            while(n-->0){
                //System.out.println("hi");

                String inp = br.readLine();
                if(inp.startsWith("X+") ||inp.startsWith("+")){
                    sum++;
                } else if(inp.startsWith("X-") ||inp.startsWith("-")){
                    sum--;
                }
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
