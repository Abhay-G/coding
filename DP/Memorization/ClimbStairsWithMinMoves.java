import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stepsAllowed[] = new int[n];
        for(int i=0;i<n;i++)
        {
            stepsAllowed[i] = sc.nextInt();
        }
        int t[] = new int[n+1];
        Arrays.fill(t,-1);
        int ans = solve(0,n,stepsAllowed,t);
        System.out.println(ans);
        
    }
    
    public static int solve(int curr, int n, int[]stepsAllowed, int[]t)
    {
        if(curr==n)
        {
            return 0;
        }
        if(curr>n)
        {
            return Integer.MAX_VALUE;
        }
        if(t[curr]!=-1)
        return t[curr];
        int steps = Integer.MAX_VALUE;
        for(int i=1;i<=stepsAllowed[curr];i++)
        {
           if(steps>solve(curr+i,n,stepsAllowed,t))
           {
               steps = 1+solve(curr+i,n,stepsAllowed,t);
           }
        }
        return t[curr] = steps;
    }

}
