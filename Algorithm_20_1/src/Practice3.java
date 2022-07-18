import java.util.ArrayList;
import java.util.Arrays;

public class Practice3 {

    public static int solution(int n, int[] items) {
        if (items == null || items.length == 0) {
            return -1;
        }

        boolean[] used = new boolean[items.length + 1];

        int cnt = 0;
        int idx = 0;

        while (cnt < n){ // 초기 값 설정
            if (!used[items[idx]]){
                used[items[idx]] = true;
                cnt++;
            }
            idx++;
        }

        int result = 0;
        while (idx < items.length){
            if (!used[items[idx]]){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = idx; i < items.length; i++) {
                    if (used[items[i]] && !list.contains(items[i])){
                        list.add(items[i]);
                    }
                }

                if (list.size() == n){
                    used[list.get(n - 1)] = false;
                }else {
                    for (int i = 1; i < items.length; i++) {
                        if (used[i] && !list.contains(i)){
                            used[i] = false;
                            break;
                        }
                    }
                }
                used[items[idx]] = true;
                result++;
            }
            idx++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int n = 2;
        int[] items = {2, 3, 2, 3, 1, 2, 7};
        System.out.println(solution(n, items));
    }
}
