import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Leetcode 870.优势洗牌
 * Tag: 优先队列，双指针
 * 
 * @author KureNaii
 * @since 2022-08-03 23:28:57
 */
public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] res = new int[len];
        // 将数组 2 的数组 index 和 val 用 int[] 存入优先队列
        // 传入 Comparator 构造器实现逆序出队
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] n1, int[] n2) -> {
            return n2[1] - n1[1];
        });
        for (int i = 0; i < len; i++) {
            queue.add(new int[] { i, nums2[i] });
        }

        // 对 nums1 排序
        Arrays.sort(nums1);

        // 双指针
        int left = 0, right = len - 1;
        while (!queue.isEmpty()) {
            int[] n2 = queue.poll();
            int index = n2[0], val = n2[1];
            if (nums1[right] > val) {
                res[index] = nums1[right];
                right--;
            } else {
                res[index] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
