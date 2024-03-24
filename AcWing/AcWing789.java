import java.util.Arrays;

/**
 * AcWing 789.数的范围
 * Tag: 二分查找
 * 
 * @author KureNaii
 * @since 2024-03-24 10:37:38
 */
public class AcWing789 {
    public static int[] Solution(int[] numbers, int target) {
        int[] resArray = new int[2];
        resArray[0] = left_bound(numbers, target);
        resArray[1] = right_bound(numbers, target);
        return resArray;
    }

    public static int left_bound(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 排除left越界的情况,无需关心right是否越界
        if (left == numbers.length)
            return -1;
        // 判断是否查找成功
        return numbers[left] == target ? left : -1;
    }

    public static int right_bound(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 排除right越界的情况,无需关心left是否越界
        if (right < 0)
            return -1;
        // 判断是否查找成功
        return numbers[right] == target ? right : -1;
    }

    public static void main(String[] args) {
        int[] testArray = { 1, 2, 2, 3, 3, 4 };
        int target = 3;
        System.out.println(Arrays.toString(Solution(testArray, target)));
    }
}
