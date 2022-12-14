import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Notepad {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Map<String,Integer> map = new HashMap<>();
            boolean flag = false;
            for(int i=0;i<n-1;i++){
                String current = s.substring(i,i+2);
                if(map.containsKey(current)){
                    if(map.get(current)<i-1){
                        flag = true;
                        break;
                    }
                } else{
                    map.put(current,i);
                }
            }
            if(flag)
            {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
