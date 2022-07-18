// 거스름돈 문제

import java.util.*;

public class Main2 {
    public static void getChangeCoins(int receivedMoney, int price) {
        final int[] coins = {500, 100, 50, 10, 5, 1};
        HashMap<Integer, Integer> result = new HashMap<>();
        int change = receivedMoney - price;
        int cnt = 0;

        for (int i = 0; i < coins.length; i++) {
            if (change < coins[i]){
                continue;
            }

            int q = change / coins[i];
            result.put( coins[i], result.getOrDefault(coins[i], 0) + q );

            change %= coins[i];
            cnt += q;
        }



        for (Map.Entry<Integer, Integer> cur : result.entrySet()){
            System.out.println(cur.getKey() + " : " + cur.getValue());
        }


    }

    public static void main(String[] args) {
        // Test code
        getChangeCoins(1000, 100);
        System.out.println("---------");
        getChangeCoins(1234, 500);
    }
}
