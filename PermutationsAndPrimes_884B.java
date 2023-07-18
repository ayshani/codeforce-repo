import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PermutationsAndPrimes_884B {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                //System.out.println("hi");

                long n = Long.parseLong(br.readLine());
                printPermutaton(n);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printPermutaton(long n) {

        if(n%2!=0) {
            System.out.print(n+" ");
            n--;
        }
        long i=1;
        while(i<=n){
            System.out.print((i+1) +" "+i +" ");
            i+=2;
        }
    }

}
