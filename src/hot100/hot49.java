package hot100;

import java.lang.invoke.StringConcatFactory;
import java.util.*;

public class hot49 {
    // 力扣第49题
    // 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
    // 示例 1:
    // 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    // 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = group2(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 使用 HashMap 存储分组结果，键为排序后的字符串，值为原字符串列表
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            // 将字符串转换为字符数组并排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // 将排序后的字符数组转回字符串，作为键
            String key = new String(chars);
            // 如果键不存在，初始化对应的列表
            // 检查当前键是否存在对应的列表，若不存在则初始化一个空列表
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            // 将原字符串添加到对应分组
            groups.get(key).add(s);
        }
        // 返回所有分组的列表
        return new ArrayList<>(groups.values());
    }
    public static List<List<String>> group2(String[] str){
        //1.创建一个map集合用于存储分组结果
        Map<String,List<String>> group=new HashMap<>();
        for (String s : str) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            if (!group.containsKey(key)){
                group.put(key,new ArrayList<>());
            }
            group.get(key).add(s);
        }
        return new ArrayList<>(group.values());
    }
}
