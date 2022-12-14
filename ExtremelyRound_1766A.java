import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
https://codeforces.com/contest/1766/problem/A
Explanation - https://codeforces.com/blog/entry/110066
 */
public class ExtremelyRound_1766A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        TreeMap<Integer,Integer> map = new TreeMap<>();
        populateExtremelyRoundNumber(map);

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int count=0;
            if(map.containsKey(n)){
                count = map.get(n);
            } else{
                count = map.floorEntry(n).getValue();
            }
            System.out.println(count);

        }
    }

    private static void populateExtremelyRoundNumber(TreeMap<Integer,Integer> map) {
        int totalCount =0;
        for(int i=1;i<1000000;i++){
            String current = String.valueOf(i);
            int count =0;
            for(int j=0;j<current.length();j++){
                if(current.charAt(j) !='0')
                {
                    count++;
                }
            }

            if(count==1) {
                totalCount++;
                map.put(i,totalCount);
            }
        }
    }
}
