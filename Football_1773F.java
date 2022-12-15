import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
https://codeforces.com/problemset/problem/1773/F
Explanation - https://codeforces.com/contest/1773/attachments/download/18267/nef-2022-tutorial.pdf
 */
public class Football_1773F {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int draw =0 ;
        if(n==0){
            System.out.println(draw);
            System.out.println("0:0");
        }
        else if(n==1){
            if(a==b){
                draw =1;
            }
            System.out.println(draw);
            System.out.println(a+":"+b);
        } else if((a+b)<n){
            draw = n-(a+b);
            System.out.println(draw);
            while(draw-->0){
                System.out.println("0:0");
            }
            while(a-->0){
                System.out.println("1:0");
            }
            while(b-->0){
                System.out.println("0:1");
            }
        } else if((a+b)>=n && ((a==0) || (b==0))){
            System.out.println(0);
            List<Integer> lst = new ArrayList<>();
            if(a==0){
                for(int i=0;i<n;i++){
                    lst.add(1);
                    b--;
                }
                if(b>0)
                    lst.set(0,lst.get(0)+b);
                for(int num : lst){
                    System.out.println("0:"+num);
                }
            } else {
                for(int i=0;i<n;i++){
                    lst.add(1);
                    a--;
                }
                if(a>0)
                    lst.set(0,lst.get(0)+a);
                for(int num : lst){
                    System.out.println(num+":0");
                }
            }
        } else {
            System.out.println(0);
            List<int[]> lst = new ArrayList<>();
            for(int i=0;i<n;i++){
                lst.add(new int[]{0,0});
            }
            lst.get(0)[0] = 1;
            lst.get(0)[1] = 0;
            lst.get(1)[0] = 0;
            lst.get(1)[1] = 1;
            a--;
            b--;
            int i=2;
            while(i<n){
                if(a>0){
                    int[] temp = lst.get(i);
                    temp[0] += 1;
                    a--;
                    lst.set(i++,temp);
                } else if(b>0){
                    int[] temp = lst.get(i);
                    temp[1]+=1;
                    b--;
                    lst.set(i++,temp);
                }
            }

            if(a>0)
            {
                int[] temp = lst.get(0);
                temp[0] += a;
                lst.set(0,temp);
            }
            if(b>0)
            {
                int[] temp = lst.get(1);
                temp[1] += b;
                lst.set(1,temp);
            }
            for(int[] num : lst){
                System.out.println(num[0]+":"+num[1]);
            }
        }
    }
}
