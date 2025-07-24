package hot100;

import java.util.Arrays;

public class hot128 {
    /*给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
    示例 1：
    输入：nums = [100,4,200,1,3,2]
    输出：4
    解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
    示例 2：
    输入：nums = [0,3,7,2,5,8,4,6,0,1]
    输出：9*/
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int lx = longestConsecutive(nums);
        System.out.println(lx);
    }

    private static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0; // 处理空数组
        Arrays.sort(nums);
        int maxLen = 1;
        int currentLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue; // 跳过重复元素
            if (nums[i] == nums[i - 1] + 1) {
                currentLen++;
            } else {
                // 序列中断，更新最长序列并重置当前计数
                maxLen = Math.max(maxLen, currentLen);
                currentLen = 1;
            }
        }
        // 检查最后一个序列是否为最长
        return Math.max(maxLen, currentLen);
    }
}
