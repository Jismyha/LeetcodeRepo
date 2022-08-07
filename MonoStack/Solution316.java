package MonoStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution316 {
    /**
     * 1.使用单调栈和 lastIndex 数组确保单调栈的字典序
     * 2. 使用 visited 数组确保结果不重复
     * 
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        char[] string = s.toCharArray();
        for (int i = 0; i < string.length; i++) {
            lastIndex[string[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        // 记录栈中出现的元素
        boolean[] visited = new boolean[26];
        for (int i = 0; i < string.length; i++) {
            char c = string[i];
            // 应该先判断栈中是否存在元素，避免单调栈出现类似 aba-> aa 的错误
            if (visited[c - 'a'] == true) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                char topChar = stack.peek();
                if (lastIndex[stack.peek() - 'a'] > i) {
                    stack.pop();
                    visited[topChar - 'a'] = false;
                } else {
                    break;
                }
            }

            stack.push(c);
            visited[c - 'a'] = true;

        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
