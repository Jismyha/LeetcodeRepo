package AcWing;

import java.util.Arrays;

/**
 * AcWing 788.逆序对数量
 * Tag: 归并排序
 * 
 * @author KureNaii
 * @since 2024-03-23 16:22:07
 */
public class AcWing788 {
    // 逆序对的个数为归并排序合并时，计算出来的总和
    public static int Solution(int[] numbers) {
        return mergeSort(numbers, 0, numbers.length - 1);
    }

    public static int mergeSort(int[] numbers, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftNum = mergeSort(numbers, left, mid);
        int rigtNum = mergeSort(numbers, mid + 1, right);
        return leftNum + rigtNum + merge(numbers, left, mid, right);
    }

    public static int merge(int[] numbers, int left, int mid, int right) {
        int ans = 0;
        int len = right - left + 1;
        int[] tmpArray = new int[len];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (numbers[i] <= numbers[j]) {
                tmpArray[k] = numbers[i];
                i++;
            } else {
                tmpArray[k] = numbers[j];
                j++;
                // left中i后所有数与j均可组成逆序数
                ans = ans + (mid - i + 1);
            }
            k++;
        }
        while (i <= mid) {
            tmpArray[k] = numbers[i];
            i++;
            k++;
        }
        while (j <= right) {
            tmpArray[k] = numbers[j];
            j++;
            k++;
        }
        for (int m = left; m <= right; m++) {
            numbers[m] = tmpArray[m - left];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] testArray = { 2, 3, 4, 5, 6, 1 };
        System.out.println(Solution(testArray));
    }

}
