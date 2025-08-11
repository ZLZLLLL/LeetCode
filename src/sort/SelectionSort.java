package sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 1};
        selectSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }


    public static void selectSort(int[] arr) {
        // 1. 健壮性校验
        if (arr == null || arr.length == 0) {
            return;
        }
        // 2. 选择排序执行
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
