import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
https://codeforces.com/contest/1766/problem/C
Explanation - https://codeforces.com/blog/entry/110066
 */
public class HamiltoniamWall_1766C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            char[][] matrix = new char[2][];
            for(int i=0;i<2;i++){
                String s = br.readLine();
                matrix[i] = s.toCharArray();
            }
            int pos =-1;
            for(int i=0;i<n;i++){
                if(matrix[0][i]!=matrix[1][i])
                {
                    pos =i;
                    break;
                }
            }
            if(pos==-1){
                System.out.println("YES");
                continue;
            }
            int currentPosition = matrix[0][pos]=='B' ? 0 : 1;
            boolean flag = true;
            for(int i=pos+1;i<n;i++){
                if(matrix[currentPosition][i]=='W')
                    flag = false;
                if(matrix[currentPosition^1][i]=='B')
                    currentPosition^=1;
            }
            currentPosition = matrix[0][pos]=='B' ? 0 : 1;
            for(int i=pos-1;i>=0;i--){
                if(matrix[currentPosition][i]=='W')
                    flag = false;
                if(matrix[currentPosition^1][i]=='B')
                    currentPosition^=1;
            }
            if(flag)
            {
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }
}
