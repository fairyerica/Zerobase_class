// 알고리즘 - 다이나믹 프로그래밍

public class Main {
    public static int fib(int n) {
        // 피보나치 수열 일반 풀이
        if (n <= 1){
            return  n;
        }else{
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 피보나치 수열 dp 풀이
    public static int fibDP(int n) {
        int[] dp = new int[n < 2 ? 2 : n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] =dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    static int[] dp = new int[8];
    public static int fibDP2(int n) {
        if (n <= 2){
            return 1;
        }
        if (dp[n] != 0){
            return dp[n];
        }
        dp[n] = fibDP2(n -1) + fibDP2(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(fib(7));
        System.out.println(fibDP(7));
        System.out.println(fibDP2(7));
    }
}
