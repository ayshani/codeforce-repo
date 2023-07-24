import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BooksExchangeEasyVersion_1249B1 {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                //System.out.println("hi");

                int n = Integer.parseInt(br.readLine());
                int[] parent = new int[n];
                String[] inp = br.readLine().split(" ");
                for(int i=0;i<n;i++){
                    int par = Integer.parseInt(inp[i]);
                    par--;
                    parent[i] =par;
                }
                solve(n, parent);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int n, int[] parent) {
        for(int i=0;i<n;i++){
            int count =1, index =parent[i];
            while(index!=i){
                index =parent[index];
                count++;
            }
            System.out.print(count+" ");
        }
        System.out.println();
    }
}
