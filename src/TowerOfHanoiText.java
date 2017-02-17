/**
 * Created by islammd on 2/14/2017.
 */
public class TowerOfHanoiText {
    static int count =0;
    public static void main(String[] args){
        solve(3,'A','C','B');
    }
    public static void solve(int n, char source, char destination, char temp){
        if(n>0){solve(n-1, source,temp, destination);
            move(source, destination);
            solve(n-1, temp,destination, source);}


    }
    private static void move(char from, char to)
    {
        System.out.printf("%2d: Move disk from %c to %c.\n",
                ++count, from, to);
    }
}
