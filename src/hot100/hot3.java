package hot100;

import java.util.HashSet;
import java.util.Set;

public class hot3 {
    /*给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
    示例 1:
    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:
    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。*/

    public static void main(String[] args) {
        String str = "abcabcbb";
        int maxLength = lengthOfLongestSubstring(str);
        System.out.println(maxLength);
    }

    public static int lengthOfLongestSubstring(String s) {
        // 用于存储当前窗口中的字符，检查是否有重复
        Set<Character> charSet = new HashSet<>();
        int maxLength = 0;  // 记录最长子串长度
        int left = 0;       // 左指针，窗口起始位置

        // 右指针遍历字符串，作为窗口结束位置
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果当前字符已存在于窗口中，移动左指针直到移除重复字符
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }

            // 将当前字符加入窗口
            charSet.add(currentChar);

            // 更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
