package hot100;

public class hot11 {
    /*给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    返回容器可以储存的最大水量。
    说明：你不能倾斜容器。
    示例 1：
    输入：[1,8,6,2,5,4,8,3,7]
    输出：49
    解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。*/

    public static void main(String[] args) {
        int[] nums={1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(nums);
        System.out.println(maxArea);
    }
    public static int maxArea(int[] nums) {
        int maxArea = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int wight = right - left;
            int height = Math.min(nums[left], nums[right]);
            int currentArea = wight * height;
            maxArea = Math.max(maxArea, currentArea);
            // 移动指针：总是移动较短的那一侧，因为这样才有可能找到更大的面积
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
