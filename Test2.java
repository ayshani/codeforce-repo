import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int n = Integer.parseInt(br.readLine());

            while(n-->0){
                //System.out.println("hi");
                long[][] edges = new long[n-1][2];
                for(int i=0;i<n-1;i++){
                    String[] input = br.readLine().split(" ");
                    edges[i][0] = Long.parseLong(input[0])-1;
                    edges[i][1] = Long.parseLong(input[1])-1;
                }
                String[] input1 = br.readLine().split("");
                long[] weights = new long[input1.length];
                for(int i=0;i<weights.length;i++){
                    weights[i]= Long.parseLong(input1[i]);
                }

                printWeightsOfEdges(n, edges, weights);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printWeightsOfEdges(int n, long[][] edges, long[] weights) {
        List<Long> result = new ArrayList<>();

    }
}
