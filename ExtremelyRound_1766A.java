import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
https://codeforces.com/contest/1766/problem/A

Let's call a positive integer extremely round if it has only one non-zero digit.
For example, 5000, 4, 1, 10, 200 are extremely round integers; 42, 13, 666, 77, 101 are not.

You are given an integer 𝑛. You have to calculate the number of extremely round integers 𝑥 such that 1≤𝑥≤𝑛.

Input
The first line contains one integer 𝑡 (1≤𝑡≤104) — the number of test cases.

Then, 𝑡 lines follow. The 𝑖-th of them contains one integer 𝑛 (1≤𝑛≤999999) — the description of the 𝑖-th test case.

Output
For each test case, print one integer — the number of extremely round integers 𝑥 such that 1≤𝑥≤𝑛.

Example
inputCopy
5
9
42
13
100
111
outputCopy
9
13
10
19
19
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
