// 알고리즘 - 이진 탐색

public class Main {
    // 반복문 구조
    public static int binarySearch(int arr[], int target) {
//        int mid = (arr.length - 1) / 2 ;
//        int answer = 0;
//        if (arr[mid] < target){
//            for (int i = mid; i < arr.length; i++) {
//                if (arr[i] == target){
//                    answer = i;
//                }
//            }
//        }else if (arr[mid] > target){
//            for (int i = 0; i < mid; i++) {
//                if (arr[i] == target){
//                    answer = i;
//                }
//            }
//        }else {
//            answer = mid;
//        }
//
//        return answer;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = (left + right ) / 2;

            if (target == arr[mid]){
                return mid;
            }else if (target <= arr[mid]){
                right = mid - 1;
            }else {
                left = mid  + 1;
            }
        }
        return -1;
    }
    
    // 재귀 호출 구조
    public static int binarySearch2(int[] arr, int target, int left, int right) {
        if (left > right){
            return  -1;
        }

        int mid = (left + right) / 2;

        if (target == arr[mid]){
            return mid;

        }else if (target < arr[mid]){
            return binarySearch2(arr, target, left, mid - 1);
        }else {
            return binarySearch2(arr, target, mid + 1 , right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("Index: " + binarySearch(arr, 60));
        System.out.println();

        System.out.println("Index: " + binarySearch2(arr, 30, 0, arr.length - 1));
    }
}
