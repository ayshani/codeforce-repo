import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheLakes_1829E {
    static int[] dir = new int[]{0,1,0,-1,0};
    static int count;
    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                //System.out.println("hi");
                String[] inp = br.readLine().split(" ");
                int n = Integer.parseInt(inp[0]);
                int m = Integer.parseInt(inp[1]);
                int[][] grid = new int[n][m];

                for(int i=0;i<n;i++){
                    inp = br.readLine().split(" ");
                    for(int j=0;j<m;j++) {
                        grid[i][j] = Integer.parseInt(inp[j]);
                    }
                }
                count=0;
                solve(n,m, grid);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void solve(int n, int m, int[][] grid) {
        int startX =0, startY =0;
        int maxCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(grid[i][j]!=0) {
                    count = 0;
                    dfs(i,j,n,m,grid);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        System.out.println(maxCount);
    }




    private static void dfs(int i, int j, int n, int m, int[][] grid) {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0)
            return;
        count+= grid[i][j];
        grid[i][j]=0;
        for(int d =0;d<4;d++){
            int x = i + dir[d];
            int y = j + dir[d+1];
            dfs(x,y,n,m,grid);
        }
    }
}
