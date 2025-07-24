package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hot15 {
    /*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
     同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    示例 1：
    输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]
    解释：
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
    不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
    注意，输出的顺序和三元组的顺序并不重要。
    示例 2：
    输入：nums = [0,1,1]
    输出：[]
    解释：唯一可能的三元组和不为 0 */

    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        //结果集
        List<List<Integer>> result = new ArrayList<>();
        // nums.length-2，因为左右指针占据两个
        for (int i = 0; i < nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            //最小值大于0时必然不满足
            if (nums[i] > 0) return result;
            //对前值去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //左右指针循环
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) right--;
                else if (nums[i] + nums[left] + nums[right] < 0) left++;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //left right去重
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
