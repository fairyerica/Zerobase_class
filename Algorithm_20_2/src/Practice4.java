
public class Practice4 {
    public static int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        int maxVal = 0;
        int[][] dp = new int[2][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i % 2][j] = matrix[i][j];
                if (i != 0 && j != 0 && dp[i % 2][j] != 0){
                    int up = dp[i % 2][j - 1];
                    int left = dp[(i - 1) % 2][j];
                    int ul = dp[(i - 1) % 2][j - 1];

                    int minVal = Math.min(ul,Math.min(up, left));
                    dp[i % 2][j] = minVal + 1;
                }
                maxVal = Math.max(maxVal, dp[i % 2][j]);
            }
        }

        return maxVal * maxVal;
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{0, 1}, {1, 0}};
        System.out.println(solution(data));

        data = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 1, 1, 0}};
        System.out.println(solution(data));
    }
}
