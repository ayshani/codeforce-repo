import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumInBinaryTree_1843C {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                //System.out.println("hi");

                long n = Long.parseLong(br.readLine());
                System.out.println(getSumFromPathTree(n));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getSumFromPathTree(long n) {
        long sum =0;
        while(n>=1){
            sum += n;
            n/=2;
        }
        return sum;
    }
}
