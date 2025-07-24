package hot100;

public class hot42 {
    /*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    示例 1：
    输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    输出：6
    解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
    示例 2：
    输入：height = [4,2,0,3,2,5]
    输出：9*/

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int sum = trapNice(height);
        System.out.println(sum);
    }


    //双指针算法--暴力算法
    public static int trap(int[] height) {
        int sum = 0;
        if (height.length<3)return sum;
        for (int i = 1; i < height.length; i++) {
            if (i == height.length - 1) continue;
            int left = i - 1;
            int right = i + 1;
            int LMax = 0;
            int RMax = 0;
            while (left >= 0) {
                if (height[left] > LMax) {
                    LMax = height[left];
                }
                left--;
            }
            while (right <= height.length - 1) {
                if (height[right] > RMax) {
                    RMax = height[right];
                }
                right++;
            }
            if (LMax > height[i] && RMax > height[i]) {
                int min = Math.min(LMax, RMax);
                sum += min - height[i];
            }
        }
        return sum;
    }
    //双指针算法--优化
    public static int trapNice(int[] height) {
        if (height == null || height.length <= 2) {
            return 0; // 边界情况处理
        }

        int left = 0;                  // 左指针，从最左侧开始
        int right = height.length - 1; // 右指针，从最右侧开始
        int leftMax = 0;               // 左侧已遍历的最大值
        int rightMax = 0;              // 右侧已遍历的最大值
        int sum = 0;                   // 总储水量

        while (left < right) {
            // 左侧高度较低，以左侧为基准计算
            if (height[left] < height[right]) {
                // 更新左侧最大值
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // 可以储水，水量为左侧最大值与当前高度的差值
                    sum += leftMax - height[left];
                }
                left++; // 左指针右移
            } else {
                // 右侧高度较低，以右侧为基准计算
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // 可以储水，水量为右侧最大值与当前高度的差值
                    sum += rightMax - height[right];
                }
                right--; // 右指针左移
            }
        }

        return sum;
    }
}
