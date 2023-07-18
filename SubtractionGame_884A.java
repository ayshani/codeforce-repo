import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SubtractionGame_884A {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                //System.out.println("hi");

                String[] input = br.readLine().split(" ");
                long a = Long.parseLong(input[0]);
                long b = Long.parseLong(input[1]);
                System.out.println(getNum(a,b));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long getNum(long a, long b) {
        return a+b;
    }

}
