import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YetAnotherCardDeck_1511C {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int q = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            int[] colors = new int[n];
            for(int i=0;i<n;i++){
                colors[i] = Integer.parseInt(input[i]);
            }

            input = br.readLine().split(" ");
            int[] queries = new int[q];
            for(int i=0;i<q;i++){
                queries[i] = Integer.parseInt(input[i]);
            }


            printIndex(colors,queries,n,q);
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printIndex(int[] colors, int[] queries, int n, int q) {
        for(int query : queries){
            int index = find(colors,query);
            if(index!=-1) {
                rotate(colors, index);
                colors[0]=query;
                System.out.print((index+1)+" ");
            }
        }
    }

    private static void rotate(int[] colors, int index) {
        for(int i= index;i>0;i--){
            colors[i]= colors[i-1];
        }
    }

    private static int find(int[] colors, long query) {
        for(int i=0;i<colors.length;i++){
            if(colors[i]==query)
                return i;
        }
        return -1;
    }
}
