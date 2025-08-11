package sort;

public class QuickSort {

    // Bubble Sort 冒泡排序
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr, int i, int j) {
        //1.定义基准数与左右指针
        int start = i;
        int end = j;
        //递归退出条件
        if (start > end) {
            return;
        }
        int baseNumber = arr[i];
        //2.进入循环，交换左右指针位置
        while (start != end) {
            while (true) {
                if (end <= start || arr[end] < baseNumber) {
                    break;
                }
                end--;
            }
            while (true) {
                if (end <= start || arr[start] > baseNumber) {
                    break;
                }
                start++;
            }
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        //2.1.交换基准数的位置
        int temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;
        //3.记录基准数，递归
        quickSort(arr, i, start - 1);
        quickSort(arr, start + 1, j);
    }
}
