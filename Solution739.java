import java.util.Deque;
import java.util.LinkedList;

/**
 * Leetcode 739.每日温度
 * Tag: 单调栈
 * 
 * @author KureNaii
 * @since 2022-03-22 17:44:58
 */
public class Solution739 {
    /**
     * 1. 将温度数组逆序入栈
     * 2. 若栈顶元素小于入栈元素，则循环出栈，直到栈顶元素大于入栈元素或栈空为止。
     * 3. 结果保存 res 数组中
     * 4. 入栈
     * 
     * @param temperatures
     * 
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return result;
    }
}
