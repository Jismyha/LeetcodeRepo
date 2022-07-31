package Public;

/**
 * 差分数组工具类
 * 
 * @author KureNaii
 * @since 2022-07-26 20:58:30
 */
public class Difference {
    private int[] diff;

    public Difference(int[] num) {
        diff = new int[num.length];
        diff[0] = num[0];
        for (int i = 1; i < num.length; i++) {
            diff[i] = num[i] - num[i - 1];
        }
    }

    /**
     * 当源数组有更新操作，更新差分数组
     * 
     * @param i
     * @param j
     * @param offset
     */
    public void increment(int i, int j, int offset) {
        diff[i] += offset;
        // 注意需要判断j的范围，防止越界
        if (j != diff.length - 1) {
            diff[j + 1] -= offset;
        }
    }

    public int[] result(int[] res) {
        res[0] = diff[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
