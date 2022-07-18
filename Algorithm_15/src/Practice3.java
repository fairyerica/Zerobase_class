// Practice3
// sols 배열에 5지 선다 문제의 정답들이 적혀있다.
// 3번 연속 해서 같은 정답이 있는 경우가 없다는 것을 알아낸 후,
// 문제를 찍어서 푼다고 할 때, 5점 이상을 받을 경우의 수를 출력하세요.

// 문제는 총 10문제이며 각 문제당 1점이다.

// 입출력 예시
// sols: {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}
// 결과: 261622


public class Practice3 {
    final static int numOfProblems = 10;
    static int cnt = 0;

    public static void solution(int[] sols) {
        if (sols == null || sols.length != numOfProblems) {
            return;
        }

        cnt = 0;
        int[] submit = new int[numOfProblems];
        backTracking(sols, submit, 0, 0);
        System.out.println(cnt);

    }

    public static void backTracking(int[] sols, int[] submit, int correctCnt, int idx){
        if (numOfProblems - idx + correctCnt < 5){
            return;
        }

        if (idx == numOfProblems){
            if (correctCnt >= 5){
                cnt += 1;
            }
        }else {
            int twoInRow = 0;
            if (idx >= 2){
                if (submit[idx - 1] == submit[idx - 2]){
                    twoInRow = submit[idx - 1];
                }
            }

            for (int i = 1; i <= 5; i++) {
                if (i == twoInRow){
                    continue;
                }
                submit[idx] = i;
                if (sols[idx] == i){
                    backTracking(sols, submit, correctCnt + 1, idx + 1);
                }else {
                    backTracking(sols, submit, correctCnt, idx + 1);
                }
                submit[idx] = 0;
            }
        }

    }

    public static void main(String[] args) {
        // Test code
        int[] sols = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        solution(sols);

        sols = new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        solution(sols);
    }
}
