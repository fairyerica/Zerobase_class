
public class Practice2 {
    public static int solution(int n, int[] plates, int types, int coupon) {
        if (plates == null || plates.length == 0) {
            return -1;
        }
        int[] selected = new int[types + 1];

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) { // 초기값 설정
            if (selected[plates[i]] == 0){
                cnt++;
            }
            selected[plates[i]]++;
        }
        max = cnt;

        for (int i = 1; i < plates.length; i++) { // 다음 경우의수 순회

            if (max <= cnt){
                if (selected[coupon] == 0){
                    max = cnt + 1;
                }else{
                    max = cnt;
                }

            }

            int p1 = i - 1; // 초기 접시
            int p2 = (i - 1 + n) % plates.length; // n 가지를 먹는다고 했을때, 순회를 위해 % 연산

            selected[plates[p1]]--;
            if (selected[plates[p1]] == 0){
                cnt--;
            }

            if (selected[plates[p2]] == 0){
                cnt++;
            }
            selected[plates[p2]]++;


        }
        return max;
    }

    public static void main(String[] args) {
        // Test code
        int n = 4;
        int[] plates = {7, 9, 7, 30, 2, 7, 9, 25};
        int types = 30;
        int coupon = 30;
        System.out.println(solution(n, plates, types, coupon));
    }
}
