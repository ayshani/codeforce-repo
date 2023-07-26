import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EscalatorConversations_1851A {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            while(t-->0) {
                String[] inp = br.readLine().split(" ");
                int n = Integer.parseInt(inp[0]);
                int m = Integer.parseInt(inp[1]);
                int k = Integer.parseInt(inp[2]);
                long H = Long.parseLong(inp[3]);
                //int[] heights = new int[n];
                inp = br.readLine().split(" ");
                long maxHeightDiff = m*k - k;
                long count=0;
                for(int i=0;i<n;i++){
                    long heightI= Long.parseLong(inp[i]);
                    long heightDiff = Math.abs(H-heightI);
                    if(heightDiff>0 && heightDiff<=maxHeightDiff && heightDiff%k==0)
                        count++;
                }
                System.out.println(count);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
