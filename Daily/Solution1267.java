package Daily;

/**
 * Leetcode 1267.统计参与通信的服务器
 * Tag:
 * 
 * @author KureNaii
 * @since 2023-08-24 22:24:45
 */
class Solution1267 {
    public int countServers(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] tmpRes = new int[m];
        // 扫描列
        for (int i = 0; i < m; i++) {
            int tmp = -1;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    tmp++;
                }
            }
            if (tmp > 0) {
                tmpRes[i] = 1;
                tmp++;
            } else if (tmp == -1) {
                tmp = 0;
            }
            result += tmp;
        }
        // 扫描行
        for (int j = 0; j < n; j++) {
            int tmp = -1;
            int min = -1;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    tmp++;
                    // 计算需要减去的台数
                    if (tmpRes[i] == 1) {
                        min++;
                    }
                }
            }
            // 只有能通信才需要减
            if (tmp > 0) {
                tmp++;
                if (min >= 0) {
                    min++;
                }
            } else if (tmp == -1) {
                tmp = 0;
            }

            if (min == -1) {
                min = 0;
            }
            result = tmp + result - min;
        }
        return result;
    }
}
