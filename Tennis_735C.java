import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://codeforces.com/problemset/problem/735/C

C. Tennis Championship
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
Famous Brazil city Rio de Janeiro holds a tennis tournament and Ostap Bender doesn't want to miss this event.
There will be n players participating, and the tournament will follow knockout rules from the very first game.
That means, that if someone loses a game he leaves the tournament immediately.

Organizers are still arranging tournament grid (i.e. the order games will happen and who is going to play with whom)
but they have already fixed one rule: two players can play against each other only if the number of games one of
them has already played differs by no more than one from the number of games the other one has already played.
Of course, both players had to win all their games in order to continue participating in the tournament.

Tournament hasn't started yet so the audience is a bit bored. Ostap decided to find out what is the maximum number
of games the winner of the tournament can take part in (assuming the rule above is used). However, it is unlikely
he can deal with this problem without your help.

Input
The only line of the input contains a single integer n (2<=n<=10^18) — the number of players to participate in the
tournament.

Output
Print the maximum number of games in which the winner of the tournament can take part.



Think of it this way. To have a 1-game tournament, you must have 2 players. You can consider 1 player to be a 0-game
tournament since there already is a winner. In order to have an n-game tournament, the winner of an n-1 game tournament
 must play the winner of an n-2 game tournament. This is simply a Fibonacci sequence and can be calculated using
 dynamic programming. (Extra players beyond the target Fibonacci number cannot make a difference because they cannot
 reach a high enough game depth to challenge the current champion).
 */
public class Tennis_735C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        findNumberOfRounds(n);

    }
    private static void findNumberOfRounds(long n){
        long a=1,b=1;
        int count=0;
        while(b<=n) {
            long t=b;
            b = b + a;
            a=t;
            count++;
        }
        System.out.println(count-1);
    }

}
