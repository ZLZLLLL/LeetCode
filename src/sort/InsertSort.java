package sort;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 1};
        insertSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }


    public static void insertSort(int[] arr) {
        //1.健壮性判断
        if (arr == null || arr.length == 0) {
            return;
        }
        //2.寻找无序起始索引
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                index = i + 1;
                break;
            }
        }
        //3.执行插入排序
        for (int i = index; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }
}
