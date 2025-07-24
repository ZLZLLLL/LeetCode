package hot100;

import java.util.ArrayList;
import java.util.List;

public class hot438 {
    /*给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    示例 1:
    输入: s = "cbaebabacd", p = "abc"
    输出: [0,6]
    解释:
    起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
    起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。*/

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        for (Integer anagram : anagrams) {
            System.out.println(anagram);
        }
    }


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        // 若 s 长度小于 p，直接返回空列表
        if (sLen < pLen) {
            return result;
        }
        // 初始化字符计数数组（26个小写字母）
        int[] pCount = new int[26];
        int[] windowCount = new int[26];
        // 统计 p 的字符频率
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        // 滑动窗口遍历 s
        int left = 0;
        for (int right = 0; right < sLen; right++) {
            // 加入右边界字符到窗口
            char rightChar = s.charAt(right);
            windowCount[rightChar - 'a']++;
            // 当窗口长度等于 p 的长度时，检查是否为异位词
            if (right - left + 1 == pLen) {
                // 直接在这里比较两个字符计数数组是否相等
                boolean isMatch = true;
                for (int i = 0; i < 26; i++) {
                    if (pCount[i] != windowCount[i]) {
                        isMatch = false;
                        break; // 一旦发现不相等，直接退出循环
                    }
                }
                // 如果匹配，记录起始索引
                if (isMatch) {
                    result.add(left);
                }
                // 移动左边界，移除窗口最左侧字符
                char leftChar = s.charAt(left);
                windowCount[leftChar - 'a']--;
                left++;
            }
        }
        return result;
    }
}
