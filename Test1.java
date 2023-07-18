import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

    public static void main(String[] args) {
        //System.out.println("hi");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //System.out.println("hi");
            int t = Integer.parseInt(br.readLine());

            while(t-->0){
                //System.out.println("hi");

                String[][] board = new String[3][3];
                for(int i=0;i<3;i++){
                    String[] input = br.readLine().split("");
                    for(int j=0;j<3;j++) {
                        board[i][j] = input[j];
                    }
                }
                System.out.println(getWinner(board));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getWinner(String[][] board) {


        String winner = board[0][0];
        String superWinner = "";
        boolean flag = true;
        for(int i=0;i<3;i++){
            if(!winner.equals(board[i][i])){
                flag = false;
                break;
            }
        }
        if(flag){
            if(".".equals(winner))
                superWinner =  "DRAW";
            else
                superWinner =  winner;
        }


        winner = board[0][2];
        flag = true;
        for(int i=0;i<3;i++){
            if(!winner.equals(board[i][2-i])){
                flag = false;
                break;
            }
        }
        if(flag ){
            if(("".equals(superWinner) || "DRAW".equals(superWinner) ) && ".".equals(winner))
                superWinner =  "DRAW";
            else
                superWinner =  winner;
        }

        for(int i=0;i<3;i++){
            winner = board[i][0];
            flag = true;
            for(int j=0;j<3;j++){
                if( !winner.equals(board[i][j])){
                    flag = false;
                    break;
                }
            }
            if(flag ){
                if(("".equals(superWinner) || "DRAW".equals(superWinner) ) && ".".equals(winner))
                    superWinner =  "DRAW";
                else
                    superWinner =  winner;
            }
        }

        for(int j=0;j<3;j++){
            winner = board[0][j];
            flag = true;
            for(int i=0;i<3;i++){
                if( !winner.equals(board[i][j])){
                    flag = false;
                    break;
                }
            }
            if(flag ){
                if(("".equals(superWinner) || "DRAW".equals(superWinner) ) && ".".equals(winner))
                    superWinner =  "DRAW";
                else
                    superWinner =  winner;
            }
        }
        if("".equals(superWinner))
            return "DRAW";

        return superWinner;
    }

}
