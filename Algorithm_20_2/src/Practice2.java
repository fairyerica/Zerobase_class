
public class Practice2 {
    public static void solution(int n) {
        int A = 1; // 실제
        int E = 1; // 예상


        while ((A*A) - (E*E) < 1000){
            if ((A*A) - (E*E) < n){
                A++;
            }else if ((A*A) - (E*E) == n){
                System.out.print(A + " ");
                A++;
                E++;
            }else {
                E++;
            }

        }



    }

    public static void main(String[] args) {
        // Test code
        solution(15);
    }
}
