import java.util.Arrays;

public class Practice1 {
    public static int solution(int n, int[] times) {
        if (times == null || times.length == 0) {
            return -1;
        }
        Arrays.sort(times);
        int left = 0;
        int right = n * times[times.length - 1];

        while (left <= right){
            int mid = (left + right) / 2 ;
            int cnt = 0;

            for (int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
            }

            if (cnt > n){
                right = mid - 1;
            }else if (cnt < n){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test code
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }
}
