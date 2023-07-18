import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ForbiddenInteger_151A {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                String[] s = br.readLine().split(" ");
                int n = Integer.parseInt(s[0]);
                int k = Integer.parseInt(s[1]);
                int x = Integer.parseInt(s[2]);
                // its time complexity is big
                //printSum(n,k,x);

                printSumv2(n,k,x);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void printSumv2(int n, int k, int x) {

        if(x!=1){
            System.out.println("YES");
            System.out.println(n);
            for(int i=1;i<=n;i++){
                System.out.print(1+" ");
            }

        } else{
          // x ==1

          if(k==1)
              System.out.print("NO");
          else if(n%2==0){
              System.out.println("YES");
              System.out.println(n/2);
              for(int i=1;i<=n/2;i++){
                  System.out.print(2+" ");
              }
          } else if(n>=2){
              if(k<3){
                  System.out.print("NO");
              } else{
                  System.out.println("YES");
                  System.out.println(((n-3)/2)+1);
                  for(int i=1;i<=(n-3)/2+1;i++){
                      System.out.print(2+" "+3+" ");
                  }
              }
          } else{
              System.out.print("NO");
          }
        }
        System.out.println();
    }

    private static void printSum(int n, int k, int x) {
        String combination = "";
        ArrayList<Integer> temp = new ArrayList<>();
        if(findCombination(1, k, n, x, temp)){
            System.out.println("YES");
            System.out.println(temp.size());
            System.out.println(temp.stream().map(s -> s+" ").collect(Collectors.joining()).toString());
        } else{
            System.out.println("NO");
        }
    }

    static boolean findCombination(int start, int end, int target, int exclude, ArrayList<Integer> list){

        if(target==0 && start<=end){
            return true;
        }
        if(target<0 || start>end)
            return false;
        boolean ans = false;
        if(target>0){

            if(start==exclude) {
                ans = findCombination(start + 1, end, target, exclude, list);
                if(ans)
                    return true;
                else
                    return false;
            } else{
                list.add(start);
                ans = findCombination(start + 1, end, target-start, exclude, list);
                if(ans)
                    return true;
                ans = findCombination(start, end, target-start, exclude, list);
                if(ans)
                    return true;
                list.remove(list.size()-1);
            }
        }
        return ans;
    }
}
